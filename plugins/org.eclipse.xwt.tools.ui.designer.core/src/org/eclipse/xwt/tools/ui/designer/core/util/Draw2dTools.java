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
package org.eclipse.xwt.tools.ui.designer.core.util;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author jliu jin.liu@soyatec.com
 */
public class Draw2dTools {

	public static Rectangle toDraw2d(org.eclipse.swt.graphics.Rectangle r) {
		return new Rectangle(r.x, r.y, r.width, r.height);
	}

	public static org.eclipse.swt.graphics.Rectangle toSWT(Rectangle r) {
		return new org.eclipse.swt.graphics.Rectangle(r.x, r.y, r.width, r.height);
	}

	public static Point toDraw2d(org.eclipse.swt.graphics.Point p) {
		return new Point(p.x, p.y);
	}

	public static org.eclipse.swt.graphics.Point toSWT(Point p) {
		return new org.eclipse.swt.graphics.Point(p.x, p.y);
	}
}
