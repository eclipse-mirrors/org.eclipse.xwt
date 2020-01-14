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
package org.eclipse.xwt.tests.usercontrol;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;

public class UserControl extends Composite {
	static public final String SELECTION_MESSAGE = "OK";

	public UserControl(Composite parent, int style) {
		super(parent, style);
	}

	protected void selection(Event event) {
		Button button = (Button) event.widget;
		button.setText(SELECTION_MESSAGE);
	}
}
