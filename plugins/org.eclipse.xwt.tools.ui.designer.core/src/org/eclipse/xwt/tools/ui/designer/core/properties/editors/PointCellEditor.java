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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xwt.tools.ui.designer.core.dialogs.IntArrayDialog;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class PointCellEditor extends AbstractCellEditor {

	public PointCellEditor(Composite parent) {
		super(parent);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.DialogCellEditor#openDialogBox(org.eclipse.swt.widgets.Control)
	 */
	protected Object openDialogBox(Control cellEditorWindow) {
		Point point = new Point(0, 0);
		Object value = getValue();
		if (value instanceof Point) {
			point.x = ((Point) value).x;
			point.y = ((Point) value).y;
		}
		IntArrayDialog dialog = new IntArrayDialog(cellEditorWindow.getShell(), new int[] { point.x, point.y },
				new String[] { "x:", "y:" });
		if (dialog.open() == Window.OK) {
			int[] result = dialog.getResult();
			point.x = result[0];
			point.y = result[1];
		}
		return point;
	}
}
