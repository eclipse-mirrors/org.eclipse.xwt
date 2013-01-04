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
package org.eclipse.xwt.tests.controls.button;

import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class ButtonTests extends XWTTestCase {
	public void testButtonVisible() throws Exception {
		URL url = ButtonTests.class.getResource(Button_Visible.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkButtonVisible();
				checkButtonNonVisible();
			}

			public void checkButtonVisible() {
				Object element = XWT.findElementByName(root, "buttonVisible");
				assertTrue(element instanceof Button);
				Button button = (Button) element;
				assertTrue(button.getVisible());
			}

			public void checkButtonNonVisible() {
				Object element = XWT
						.findElementByName(root, "buttonNonVisible");
				assertTrue(element instanceof Button);
				Button button = (Button) element;
				assertFalse(button.getVisible());
			}
		});
	}

	public void testButtonAlignment() throws Exception {
		URL url = ButtonTests.class.getResource(Button_Alignment.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkButtonLeft();
				checkButtonRight();
				checkButtonCenter();
			}

			public void checkButtonLeft() {
				Object element = XWT.findElementByName(root, "ButtonLeft");
				assertTrue(element instanceof Button);
				Button button = (Button) element;
				assertTrue(button.getAlignment() == SWT.LEFT);
			}

			public void checkButtonRight() {
				Object element = XWT.findElementByName(root, "ButtonRight");
				assertTrue(element instanceof Button);
				Button button = (Button) element;
				assertTrue(button.getAlignment() == SWT.RIGHT);
			}

			public void checkButtonCenter() {
				Object element = XWT.findElementByName(root, "ButtonCenter");
				assertTrue(element instanceof Button);
				Button button = (Button) element;
				assertTrue(button.getAlignment() == SWT.CENTER);
			}
		});
	}

	public void testButtonEnabled() throws Exception {
		URL url = ButtonTests.class.getResource(Button_Enabled.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkButtonEnabled();
				checkButtonNotEnabled();
			}

			public void checkButtonEnabled() {
				Object element = XWT.findElementByName(root, "EnabledButton");
				assertTrue(element instanceof Button);
				Button button = (Button) element;
				assertTrue(button.isEnabled());
			}

			public void checkButtonNotEnabled() {
				Object element = XWT
						.findElementByName(root, "NotEnabledButton");
				assertTrue(element instanceof Button);
				Button button = (Button) element;
				assertFalse(button.isEnabled());
			}
		});
	}

	public void testButtonStyles() throws Exception {
		URL url = ButtonTests.class.getResource(Button_Styles.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkPushButton();
				checkCheckButton();
				checkRadioButton();
				checkToggleButton();
				checkArrowButton();
				checkFlatButton();
			}

			public void checkPushButton() {
				Object element = XWT.findElementByName(root, "PushButton");
				assertTrue(element instanceof Button);
				Button button = (Button) element;
				assertTrue((button.getStyle() & SWT.PUSH) == SWT.PUSH);
			}

			public void checkCheckButton() {
				Object element = XWT.findElementByName(root, "CheckButton");
				assertTrue(element instanceof Button);
				Button button = (Button) element;
				assertTrue((button.getStyle() & SWT.CHECK) == SWT.CHECK);
			}

			public void checkRadioButton() {
				Object element = XWT.findElementByName(root, "RadioButton");
				assertTrue(element instanceof Button);
				Button button = (Button) element;
				assertTrue((button.getStyle() & SWT.RADIO) == SWT.RADIO);
			}

			public void checkToggleButton() {
				Object element = XWT.findElementByName(root, "ToggleButton");
				assertTrue(element instanceof Button);
				Button button = (Button) element;
				assertTrue((button.getStyle() & SWT.TOGGLE) == SWT.TOGGLE);
			}

			public void checkArrowButton() {
				Object element = XWT.findElementByName(root, "ArrowButton");
				assertTrue(element instanceof Button);
				Button button = (Button) element;
				assertTrue((button.getStyle() & SWT.ARROW) == SWT.ARROW);
			}

			public void checkFlatButton() {
				Object element = XWT.findElementByName(root, "FlatButton");
				assertTrue(element instanceof Button);
				Button button = (Button) element;
				assertTrue((button.getStyle() & SWT.FLAT) == SWT.FLAT);
			}
		});
	}
}
