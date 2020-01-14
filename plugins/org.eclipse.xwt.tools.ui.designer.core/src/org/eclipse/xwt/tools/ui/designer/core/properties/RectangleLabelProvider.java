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
package org.eclipse.xwt.tools.ui.designer.core.properties;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.xwt.tools.ui.designer.core.util.StringUtil;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class RectangleLabelProvider extends LabelProvider {
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		if (element instanceof Rectangle) {
			Rectangle r = (Rectangle) element;
			return StringUtil.format(r);
		}
		return super.getText(element);
	}
}
