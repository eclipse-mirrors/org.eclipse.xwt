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
package org.eclipse.xwt.ui.editor;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.xml.ui.views.contentoutline.XMLContentOutlineConfiguration;
import org.eclipse.xwt.ui.editor.treeviewer.XWTNodeActionManager;

public class XWTContentOutlineConfiguration extends XMLContentOutlineConfiguration {

	public XWTContentOutlineConfiguration() {
	}

	protected XWTNodeActionManager createNodeActionManager(TreeViewer treeViewer) {
		return new XWTNodeActionManager((IStructuredModel) treeViewer.getInput(), treeViewer);
	}
}
