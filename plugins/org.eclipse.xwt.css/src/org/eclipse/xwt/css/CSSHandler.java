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
package org.eclipse.xwt.css;

import org.eclipse.swt.widgets.Widget;
import org.eclipse.xwt.INamespaceHandler;

public class CSSHandler implements INamespaceHandler {
	public static final String NAMESPACE = "http://www.eclipse.org/css";
	public static final CSSHandler handler = new CSSHandler();

	public void handleAttribute(Widget widget, Object target, String name,
			String value) {
		widget.setData("org.eclipse.e4.ui.css." + name, value);
	}
}
