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

import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;

public class FontCellEditor extends AbstractCellEditor {

	/**
	 * Creates a new Font dialog cell editor parented under the given control. The cell editor value is null initially, and has no validator.
	 * 
	 * @param parent
	 *            the parent control
	 */
	public FontCellEditor(Composite parent) {
		super(parent);
	}

	/**
	 * @see org.eclipse.jface.viewers.DialogCellEditor#openDialogBox(Control)
	 */
	protected Object openDialogBox(Control cellEditorWindow) {
		FontDialog ftDialog = new FontDialog(cellEditorWindow.getShell());
		Object value = getValue();
		if (value != null && value instanceof Font) {
			Font font = (Font) value;
			if (font != null) {
				FontData[] fontDatas = font.getFontData();
				ftDialog.setFontList(fontDatas);
			}
		}
		FontData fData = ftDialog.open();
		if (fData != null) {
			value = new Font(Display.getCurrent(), fData);
		}
		return value;
	}

}
