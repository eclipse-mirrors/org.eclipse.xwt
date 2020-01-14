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
package org.eclipse.xwt.vex.palette.part;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.internal.ui.palette.editparts.DrawerFigure;
import org.eclipse.swt.widgets.Control;

/**
 * 
 */
public class ToolDrawerFigure extends DrawerFigure {

	private static final int COLOR_INCREMENT = 15;

	private static final int X_OFFSET = 17;

	public ToolDrawerFigure(Control control, int childLevel) {
		super(control);

		// Color baseColor = control.getBackground();
		// Color backgroundColor = new Color(Display.getCurrent(), getNewValue(baseColor.getRed(), childLevel), getNewValue(
		// baseColor.getGreen(), childLevel), getNewValue(baseColor.getBlue(), childLevel));
		// getContentPane().setBackgroundColor(backgroundColor);
	}

	private int getNewValue(int oldValue, int childLevel) {
		int result = oldValue - childLevel * COLOR_INCREMENT;
		return (result > 0 ? result : 0);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(bounds.x + X_OFFSET, bounds.y, bounds.width, bounds.height);
	}
}
