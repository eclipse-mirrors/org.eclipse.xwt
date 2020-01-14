/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.animation.interpolator;

import org.eclipse.swt.graphics.Rectangle;
import org.pushingpixels.trident.interpolator.PropertyInterpolator;

public class RectanglePropertyInterpolator implements
		PropertyInterpolator<Rectangle> {
	private Rectangle value = new Rectangle(0, 0, 0, 0);

	public RectanglePropertyInterpolator() {
	}

	public Class<?> getBasePropertyClass() {
		return Rectangle.class;
	}

	public Rectangle interpolate(Rectangle from, Rectangle to,
			float timelinePosition) {
		double x = from.x + (to.x - from.x) * timelinePosition;
		double y = from.y + (to.y - from.y) * timelinePosition;
		double width = from.width + (to.width - from.width) * timelinePosition;
		double height = from.height + (to.height - from.height)
				* timelinePosition;
		value.x = (int) x;
		value.y = (int) y;
		value.width = (int) width;
		value.height = (int) height;
		return value;
	}
}
