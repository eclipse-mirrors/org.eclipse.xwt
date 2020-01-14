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

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xwt.tools.ui.designer.core.util.image.ImageCollectedRunnable;
import org.eclipse.xwt.tools.ui.designer.core.util.image.ImageCollector;

/**
 * @author jin.liu(jin.liu@soyatec.com)
 */
public class ControlInfo extends WidgetInfo {

	public ControlInfo(Object visualObject, boolean isRoot) {
		super(visualObject, isRoot);
	}

	public void refreshImage() {
		if (!isRoot()) {
			return;
		}
		Widget widget = getVisualObject();
		if (widget == null || widget.isDisposed() || !(widget instanceof Control)) {
			return;
		}
		Control control = (Control) widget;
		ImageCollector.collectImage(control, new ImageCollectedRunnable() {
			public void imageNotCollected() {
			}

			public void imageCollected(Image image) {
				imageSupport.fireImageChanged(image);
			}
		});
	}
}
