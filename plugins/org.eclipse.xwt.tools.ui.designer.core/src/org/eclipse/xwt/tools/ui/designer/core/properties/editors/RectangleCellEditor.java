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
package org.eclipse.xwt.tools.ui.designer.core.properties.editors;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xwt.tools.ui.designer.core.dialogs.IntArrayDialog;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class RectangleCellEditor extends AbstractCellEditor {

	public RectangleCellEditor(Composite parent) {
		super(parent);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.DialogCellEditor#openDialogBox(org.eclipse.swt.widgets.Control)
	 */
	protected Object openDialogBox(Control cellEditorWindow) {
		Rectangle rect = new Rectangle(0, 0, 0, 0);
		Object value = getValue();
		if (value instanceof Rectangle) {
			Rectangle r = (Rectangle) value;
			rect.x = r.x;
			rect.y = r.y;
			rect.width = r.width;
			rect.height = r.height;
		}
		IntArrayDialog dialog = new IntArrayDialog(cellEditorWindow.getShell(), new int[] { rect.x, rect.y, rect.width,
				rect.height }, new String[] { "x:", "y:", "width:", "height:" });
		if (dialog.open() == Window.OK) {
			int[] result = dialog.getResult();
			rect.x = result[0];
			rect.y = result[1];
			rect.width = result[2];
			rect.height = result[3];
		}
		return rect;
	}

}
