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
package org.eclipse.xwt.tests.events.initialize;

import java.net.URL;

import org.eclipse.swt.widgets.Button;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class EventsInitTests extends XWTTestCase {

	public void testInitializeComponent() throws Exception {
		URL url = UserControl.class.getResource(UserControl.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				Object element = XWT.findElementByName(root, "button");
				assertTrue(element instanceof Button);
				Button button = (Button) element;
				assertEquals(button.getText(), UserControl.Message);
			}
		});
	}
}
