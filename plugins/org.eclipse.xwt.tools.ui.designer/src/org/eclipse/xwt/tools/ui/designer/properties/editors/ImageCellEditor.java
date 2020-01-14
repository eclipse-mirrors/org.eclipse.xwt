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
package org.eclipse.xwt.tools.ui.designer.properties.editors;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xwt.tools.ui.designer.XWTDesignerPlugin;
import org.eclipse.xwt.tools.ui.designer.dialogs.ImageDialog;
import org.eclipse.xwt.tools.ui.designer.editor.XWTDesigner;

public class ImageCellEditor extends AbstractCellEditor {

	public ImageCellEditor(Composite parent) {
		super(parent);
	}

	protected Object openDialogBox(Control cellEditorWindow) {
		XWTDesigner designer = XWTDesignerPlugin.getDefault().getActiveDesigner();
		if (designer != null) {
			ImageDialog dialog = new ImageDialog(cellEditorWindow.getShell(), designer.getFile());
			if (Window.OK == dialog.open()) {
				return dialog.getImagePath();
			}
		}
		return null;
	}
}
