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
package org.eclipse.xwt.tests.trigger.multitrigger;

import java.net.URL;

import org.eclipse.swt.widgets.Button;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class MultiTriggerTests extends XWTTestCase {

	public MultiTriggerTests() {
	}

	public void test_Button_Click_MultiTrigger() {
		URL url = MultiTriggerTests.class
				.getResource(Button_Click_MultiTrigger.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Button buttonHide = (Button) XWT.findElementByName(root,
						"ButtonHide");
				selectButton(buttonHide);
				Button buttonNotHide = (Button) XWT.findElementByName(root,
						"ButtonNotHide");
				selectButton(buttonNotHide);
			}
		}, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				Button buttonHide = (Button) XWT.findElementByName(root,
						"ButtonHide");
				assertFalse(buttonHide.isVisible());
				Button buttonNotHide = (Button) XWT.findElementByName(root,
						"ButtonNotHide");
				assertTrue(buttonNotHide.isVisible());
			}
		});
	}

	public void test_Button_Click_MultiTrigger_SourceName1() {
		URL url = MultiTriggerTests.class
				.getResource(Button_Click_MultiTrigger_SourceName.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Button button1 = (Button) XWT
						.findElementByName(root, "button1");
				selectButton(button1);
			}
		}, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				assertTrue(root.isVisible());
			}
		});
	}

	public void test_Button_Click_MultiTrigger_SourceName2() {
		URL url = MultiTriggerTests.class
				.getResource(Button_Click_MultiTrigger_SourceName.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Button button2 = (Button) XWT
						.findElementByName(root, "button2");
				selectButton(button2);
			}
		}, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				assertTrue(root.isVisible());
			}
		});
	}

	public void test_Button_Click_MultiTrigger_SourceName3() {
		URL url = MultiTriggerTests.class
				.getResource(Button_Click_MultiTrigger_SourceName.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Button button1 = (Button) XWT
						.findElementByName(root, "button1");
				selectButton(button1);
				Button button2 = (Button) XWT
						.findElementByName(root, "button2");
				selectButton(button2);
			}
		}, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				Button button1 = (Button) XWT
						.findElementByName(root, "button1");
				assertFalse(button1.isVisible());
				Button button2 = (Button) XWT
						.findElementByName(root, "button2");
				assertFalse(button2.isVisible());
			}
		});
	}
}
