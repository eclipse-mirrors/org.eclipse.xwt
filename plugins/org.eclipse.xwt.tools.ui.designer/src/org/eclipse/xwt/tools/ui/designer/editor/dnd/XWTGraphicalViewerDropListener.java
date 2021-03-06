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
package org.eclipse.xwt.tools.ui.designer.editor.dnd;

import org.eclipse.xwt.tools.ui.palette.Entry;
import org.eclipse.xwt.tools.ui.palette.PaletteFactory;
import org.eclipse.xwt.tools.ui.palette.request.EntryCreationFactory;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.xwt.tools.ui.designer.core.editor.dnd.GraphicalViewerDropCreationListener;
import org.eclipse.xwt.tools.ui.designer.core.util.XWTCodeGenUtil;

/**
 * @author Jin Liu(jin.liu@soyatec.com)
 */
public class XWTGraphicalViewerDropListener extends
		GraphicalViewerDropCreationListener {

	public XWTGraphicalViewerDropListener(EditPartViewer viewer) {
		super(viewer);
	}

	protected CreationFactory createCreationFactory(Object selection) {
		if (selection instanceof ICompilationUnit) {
			Class<?> dataContext = getClassType((ICompilationUnit) selection);
			if (dataContext == null) {
				return null;
			}
			String generate = XWTCodeGenUtil.generate(dataContext);
			Entry entry = PaletteFactory.eINSTANCE.createEntry();
			entry.setContent(generate);
			entry.setScope("Composite");
			entry.setName(dataContext.getSimpleName());

			return new EntryCreationFactory(entry);
		}
		return null;
	}
}
