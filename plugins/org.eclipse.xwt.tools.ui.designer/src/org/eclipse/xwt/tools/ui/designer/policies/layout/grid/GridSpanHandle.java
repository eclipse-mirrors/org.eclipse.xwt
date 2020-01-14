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
package org.eclipse.xwt.tools.ui.designer.policies.layout.grid;

/*
 *  $RCSfile: GridSpanHandle.java,v $
 *  $Revision: 1.2 $  $Date: 2010/06/18 00:15:48 $ 
 */

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.handles.ResizeHandle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.xwt.tools.ui.designer.policies.layout.GridLayoutEditPolicy;

public class GridSpanHandle extends ResizeHandle {
	public static int HANDLE_SIZE = DEFAULT_HANDLE_SIZE;

	public GridSpanHandle(GraphicalEditPart owner, int direction, GridLayoutEditPolicy layoutEditPolicy) {
		super(owner, direction);
		setLocator(new GridSpanHandleLocator(owner, direction, layoutEditPolicy));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.handles.SquareHandle#getBorderColor()
	 */
	protected Color getBorderColor() {
		return ColorConstants.darkGray;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.handles.SquareHandle#getFillColor()
	 */
	protected Color getFillColor() {
		return ColorConstants.lightGreen;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	public void paintFigure(Graphics g) {
		Rectangle r = getBounds();
		r.shrink(1, 1);
		try {
			g.setBackgroundColor(getFillColor());
			g.fillRectangle(r.x, r.y, r.width, r.height);
			g.setForegroundColor(getBorderColor());
			g.drawRectangle(r.x, r.y, r.width, r.height);
		} finally {
			// We don't really own rect 'r', so fix it.
			r.expand(1, 1);
		}
	}

}
