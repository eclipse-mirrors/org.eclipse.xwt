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
package org.eclipse.xwt.tools.ui.designer.core.parts.tools;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class SelectionLocator implements Locator {

	private IFigure figure;

	/**
	 * @param figure
	 */
	public SelectionLocator(IFigure figure) {
		this.figure = figure;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Locator#relocate(org.eclipse.draw2d.IFigure)
	 */
	public void relocate(IFigure target) {
		Insets insets = target.getInsets();
		Rectangle bounds;
		if (figure instanceof HandleBounds)
			bounds = ((HandleBounds) figure).getHandleBounds();
		else
			bounds = figure.getBounds();
		bounds = new PrecisionRectangle(bounds.getResized(-1, -1));
		figure.translateToAbsolute(bounds);
		target.translateToRelative(bounds);
		bounds.translate(-insets.left, -insets.top);
		bounds.resize(insets.getWidth() + 1, insets.getHeight() + 1);
		target.setBounds(bounds);
	}

}
