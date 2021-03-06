/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.vex.palette;

import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xwt.vex.palette.part.ToolPaletteViewerProvider;

/**
 * @author bqian
 * 
 */
public class PaletteViewManager {
	private PaletteViewerProvider provider;
	private PaletteRoot paletteRoot;
	private IEditorPart editorPart;
	private DefaultEditDomain editDomain;

	/**
	 * @param editorPart
	 */
	public PaletteViewManager(IEditorPart editorPart) {
		this.editorPart = editorPart;
	}

	public PaletteViewerProvider getPaletteViewerProvider() {
		if (provider == null)
			provider = createPaletteViewerProvider();
		return provider;
	}

	private PaletteViewerProvider createPaletteViewerProvider() {
		return new ToolPaletteViewerProvider(getEditDomain(), editorPart);
	}

	private EditDomain getEditDomain() {
		if (editDomain == null) {
			editDomain = new DefaultEditDomain(editorPart);
			editDomain.setPaletteRoot(getPaletteRoot());
		}
		return editDomain;
	}

	public PaletteRoot getPaletteRoot() {
		if (paletteRoot == null)
			paletteRoot = PaletteRootFactory.createPalette(editorPart);
		return paletteRoot;
	}

	public PaletteRoot getPaletteRootByResourceManager(PaletteResourceManager resourceManager) {
		paletteRoot = PaletteRootFactory.createPaletteByResourceManager(resourceManager);
		return paletteRoot;
	}

}
