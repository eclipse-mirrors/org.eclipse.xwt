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

import java.net.URL;

import org.eclipse.swt.widgets.Button;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

/**
 * 
 * @author yyang
 * 
 */
public class EventsLoadedTests extends XWTTestCase {

	public void testLoaded() throws Exception {
		URL url = org.eclipse.xwt.tests.events.loaded.Button.class
				.getResource(org.eclipse.xwt.tests.events.loaded.Button.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				Object element = XWT.findElementByName(root, "Button");
				assertTrue(element instanceof Button);
				Button button = (Button) element;
				assertEquals(
						button.getText(),
						org.eclipse.xwt.tests.events.loaded.ButtonHandler.Message);
			}
		});
	}

	public void testLoaded_Prefix() throws Exception {
		URL url = org.eclipse.xwt.tests.events.loaded.Button_prefix.class
				.getResource(org.eclipse.xwt.tests.events.loaded.Button_prefix.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				Object element = XWT.findElementByName(root, "Button");
				assertTrue(element instanceof Button);
				Button button = (Button) element;
				assertEquals(
						button.getText(),
						org.eclipse.xwt.tests.events.loaded.ButtonHandler.Message);
			}
		});
	}
}
