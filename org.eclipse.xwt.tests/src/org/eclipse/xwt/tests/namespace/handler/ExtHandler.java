/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.namespace.handler;

import org.eclipse.swt.widgets.Widget;
import org.eclipse.xwt.INamespaceHandler;

public class ExtHandler implements INamespaceHandler {
	public void handleAttribute(Widget widget, Object target, String name,
			String value) {
		widget.setData(name, value);
	}
}
