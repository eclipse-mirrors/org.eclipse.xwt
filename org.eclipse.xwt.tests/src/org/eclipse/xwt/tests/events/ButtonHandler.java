/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.events;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;

public class ButtonHandler {
	public static final String message = "OK";

	protected void selection(Event event) {
		Button button = (Button) event.widget;
		button.setText(message);
	}
}
