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
package org.eclipse.xwt.tests.trigger.multidatatrigger;

import java.net.URL;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class MultiDataTriggerTests extends XWTTestCase {

	public MultiDataTriggerTests() {
	}

	public void test_MultiDataTrigger1() {
		URL url = MultiDataTriggerTests.class
				.getResource(MultiDataTrigger.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Button button1 = (Button) XWT.findElementByName(root, "Button");
				selectButton(button1);
				Text text = (Text) XWT.findElementByName(root, "Text");
				text.setText("11");
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

	public void test_MultiDataTrigger_Restore1() {
		URL url = MultiDataTriggerTests.class
				.getResource(MultiDataTrigger_Restore.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Button button1 = (Button) XWT.findElementByName(root, "Button");
				selectButton(button1, false);
				selectButton(button1, true);
			}
		}, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				Button button1 = (Button) XWT.findElementByName(root, "Button");

				assertEquals(button1.getText(), "true");
			}
		});
	}

	public void test_MultiDataTrigger_Restore2() {
		URL url = MultiDataTriggerTests.class
				.getResource(MultiDataTrigger_Restore.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Button button1 = (Button) XWT.findElementByName(root, "Button");
				selectButton(button1, false);
				selectButton(button1, true);
				selectButton(button1, false);
			}
		}, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				Button button1 = (Button) XWT.findElementByName(root, "Button");

				assertEquals(button1.getText(), "");
			}
		});
	}

	public void test_MultiDataTrigger2() {
		URL url = MultiDataTriggerTests.class
				.getResource(MultiDataTrigger.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Button button1 = (Button) XWT.findElementByName(root, "Button");
				selectButton(button1, false);
				Text text = (Text) XWT.findElementByName(root, "Text");
				text.setText("15");
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

	public void test_MultiDataTrigger3() {
		URL url = MultiDataTriggerTests.class
				.getResource(MultiDataTrigger.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Button button1 = (Button) XWT.findElementByName(root, "Button");
				selectButton(button1, false);
				Text text = (Text) XWT.findElementByName(root, "Text");
				text.setText("15");
				selectButton(button1, true);
			}
		}, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				assertFalse(root.isVisible());
			}
		});
	}

	public void test_MultiDataTrigger4() {
		URL url = MultiDataTriggerTests.class
				.getResource(MultiDataTrigger_Default.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Button button1 = (Button) XWT.findElementByName(root, "Button");
				selectButton(button1, false);
				Text text = (Text) XWT.findElementByName(root, "Text");
				text.setText("15");
				selectButton(button1, true);
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
}
