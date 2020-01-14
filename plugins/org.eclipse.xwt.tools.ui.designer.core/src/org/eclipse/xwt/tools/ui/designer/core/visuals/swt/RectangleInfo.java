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
package org.eclipse.xwt.tools.ui.designer.core.visuals.swt;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.xwt.tools.ui.designer.core.visuals.VisualInfo;

/**
 * It is used to manage a visual widget such as SashFrom
 * 
 * @author yyang <yves.yang@soyatec.com>
 */
public class RectangleInfo extends VisualInfo {

	public RectangleInfo(Rectangle visualObject, boolean isRoot) {
		super(visualObject, isRoot);
	}

	public Rectangle getBounds() {
		return (Rectangle) getVisualObject();
	}

	public Rectangle getVisualObject() {
		return (Rectangle) super.getVisualObject();
	}

	public void refreshImage() {
		// do nothing.
	}
}
