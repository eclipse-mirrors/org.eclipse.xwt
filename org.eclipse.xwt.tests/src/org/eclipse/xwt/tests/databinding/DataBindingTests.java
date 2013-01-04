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
package org.eclipse.xwt.tests.databinding;

import java.net.URL;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class DataBindingTests extends XWTTestCase {

	public void testDataBindingPath() throws Exception {
		URL url = DataBindingTests.class.getResource(DataBindingPath.class
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
				selectButton(button);
			}
		}, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				Object element = XWT.findElementByName(root, "ManagerCity");
				assertTrue(element instanceof Text);
				Text text = (Text) element;
				assertEquals(text.getText(), "ShenZhen");
			}
		});
	}

	public void testDataBindingPath_UpdateSourceTrigger() throws Exception {
		URL url = DataBindingTests.class
				.getResource(DataBinding_UpdateSourceTrigger.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				Object input = XWT.findElementByName(root, "inputText");
				Object target = XWT.findElementByName(root, "targetText");
				assertTrue(input instanceof Text);
				Text inputText = (Text) input;
				assertTrue(target instanceof Text);
				inputText.setText("new value");
				Text targetText = (Text) target;
				// setFocus() doesn't work on Mac OS 64 Bits cocoa
				setFocusOut(inputText);
			}
		}, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				Object target = XWT.findElementByName(root, "targetText");
				assertTrue(target instanceof Text);
				Text targetText = (Text) target;
				assertEquals("new value", targetText.getText());
			}
		});
	}

	public void testDataBindingPath_UpdateSourceTrigger_2() throws Exception {
		URL url = DataBindingTests.class
				.getResource(DataBinding_UpdateSourceTrigger.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				Object input = XWT.findElementByName(root, "inputText");
				Object target = XWT.findElementByName(root, "targetText");
				assertTrue(input instanceof Text);
				Text inputText = (Text) input;
				assertTrue(target instanceof Text);
				Text targetText = (Text) target;
				inputText.setText("new value");
			}
		}, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				Object target = XWT.findElementByName(root, "targetText");
				assertTrue(target instanceof Text);
				Text targetText = (Text) target;
				assertEquals(targetText.getText(), "toto");
			}
		});
	}
}
