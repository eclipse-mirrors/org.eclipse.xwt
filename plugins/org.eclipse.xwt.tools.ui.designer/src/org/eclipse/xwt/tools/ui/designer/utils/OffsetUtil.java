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
package org.eclipse.xwt.tools.ui.designer.utils;

import org.eclipse.gef.EditPart;
import org.eclipse.xwt.tools.ui.designer.core.parts.VisualEditPart;
import org.eclipse.xwt.tools.ui.designer.core.visuals.IVisualInfo;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class OffsetUtil {

	public static int getXOffset(EditPart part) {
		int x = 0;
		if (part != null && part instanceof VisualEditPart) {
			IVisualInfo visualInfo = ((VisualEditPart) part).getVisualInfo();
			x = visualInfo.getClientArea().x;
		}
		return x;
	}

	public static int getYOffset(EditPart part) {
		int y = 0;
		if (part != null && part instanceof VisualEditPart) {
			IVisualInfo visualInfo = ((VisualEditPart) part).getVisualInfo();
			y = visualInfo.getClientArea().y;
		}
		return y;
	}
}
