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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

/**
 * @author jliu jin.liu@soyatec.com
 */
public class GridLayoutFeedbackFigure extends RectangleFigure {

	public GridLayoutFeedbackFigure() {
		super();
		setLineStyle(SWT.LINE_SOLID);
		setLineWidth(2);
	}

	public void fillShape(Graphics g) {
		Rectangle r = getBounds().getCopy();
		r.expand(-4, -4);
		g.setBackgroundColor(ColorConstants.green);
		try {
			g.setAlpha(175);
		} catch (Exception e) {
			// For OS platforms that don't support setAlpha
			g.setXORMode(true);
			g.setBackgroundColor(ColorConstants.green);
		}
		g.fillRectangle(r.x, r.y, r.width, r.height);
	}

	public void outlineShape(Graphics g) {
		Rectangle r = getBounds().getCopy();
		r.expand(-4, -4);
		g.drawRectangle(r.x, r.y, r.width, r.height);
	}
}
