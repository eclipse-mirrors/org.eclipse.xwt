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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xwt.tools.ui.designer.core.util.Draw2dTools;
import org.eclipse.xwt.tools.ui.designer.core.util.swt.WidgetLocator;
import org.eclipse.xwt.tools.ui.designer.core.visuals.VisualInfo;

/**
 * @author jin.liu(jin.liu@soyatec.com)
 */
public class WidgetInfo extends VisualInfo {

	public WidgetInfo(Object visualObject, boolean isRoot) {
		super(visualObject, isRoot);
	}

	public Rectangle getBounds() {
		Widget widget = getVisualObject();
		if (widget != null && !widget.isDisposed()) {
			return Draw2dTools.toDraw2d(WidgetLocator.getBounds(widget, isRoot()));
		}
		return super.getBounds();
	}

	public Widget getVisualObject() {
		return (Widget) super.getVisualObject();
	}

	public void refreshImage() {
		// do nothing.
	}

	public Display getDisplay() {
		Widget widget = getVisualObject();
		if (widget != null && !widget.isDisposed()) {
			return widget.getDisplay();
		}
		Display display = Display.getCurrent();
		if (display == null) {
			display = Display.getDefault();
		}
		return display;
	}

}
