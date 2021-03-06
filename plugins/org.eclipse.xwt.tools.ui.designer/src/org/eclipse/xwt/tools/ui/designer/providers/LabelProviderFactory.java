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
package org.eclipse.xwt.tools.ui.designer.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Layout;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class LabelProviderFactory {
	private static Map<Class<?>, ILabelProvider> cache = new HashMap<Class<?>, ILabelProvider>();

	public static ILabelProvider getLabelProvider(Class<?> type) {
		ILabelProvider labelProvider = cache.get(type);
		if (labelProvider == null) {
			labelProvider = createLabelProvider(type);
			cache.put(type, labelProvider);
		}
		return labelProvider;
	}

	private static ILabelProvider createLabelProvider(Class<?> type) {
		if (Color.class == type) {
			return new ColorLabelProvider();
		} else if (Font.class == type) {
			return new FontLabelProvider();
		} else if (Rectangle.class == type) {
			return new RectangleLabelProvider();
		} else if (Point.class == type) {
			return new PointLabelProvider();
		} else if (Layout.class == type) {
			return new LayoutLabelProvider();
		}
		return new LabelProvider() {
			public String getText(Object element) {
				if (element.getClass().isArray()) {
					return "[...]";
				}
				return super.getText(element);
			}
		};
	}
}
