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
package org.eclipse.xwt.tools.ui.palette.page.editparts.figures;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.internal.ui.palette.editparts.DrawerFigure;
import org.eclipse.swt.widgets.Control;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class PaletteDrawerFigure extends DrawerFigure {

	private static final int X_OFFSET = 17;

	/**
	 * @param control
	 */
	public PaletteDrawerFigure(Control control) {
		super(control);
	}

	public Rectangle getBounds() {
		return new Rectangle(bounds.x + X_OFFSET, bounds.y, bounds.width, bounds.height);
	}
}
