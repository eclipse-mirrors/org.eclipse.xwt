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
package org.eclipse.xwt.tests.events.loaded;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;

public class ButtonHandler {
	public static final String Message = "OK -> Loaded";

	protected void onLoaded(Event event) {
		Button button = (Button) event.widget;
		button.setText(Message);
	}
}
