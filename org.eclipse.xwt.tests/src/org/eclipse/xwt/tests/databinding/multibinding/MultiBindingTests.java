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
package org.eclipse.xwt.tests.databinding.multibinding;

import java.net.URL;

import org.eclipse.swt.widgets.Text;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class MultiBindingTests extends XWTTestCase {

	public void testMultiBindingPath_Read() throws Exception {
		URL url = MultiBindingTests.class.getResource(MultiBinding.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				Object element = XWT.findElementByName(root, "multiValueText");
				assertTrue(element instanceof Text);
				Text text = (Text) element;
				assertEquals(text.getText(), "Luc DUMAS");
			}
		});
	}
	
	public void testMultiBindingPath_Update() throws Exception {
		URL url = MultiBindingTests.class.getResource(MultiBinding.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				Object element = XWT.findElementByName(root, "multiValueText");
				assertTrue(element instanceof Text);
				Text text = (Text) element;
				text.setText("NewFirst DUMAS");
			}
		}, new Runnable() {
			public void run() {
				checkFirstText();
				checkLastText();
			}

			public void checkFirstText() {
				Object element = XWT.findElementByName(root, "firstNameText");
				assertTrue(element instanceof Text);
				Text text = (Text) element;
				assertEquals(text.getText(), "NewFirst");

			}

			public void checkLastText() {
				Object element = XWT.findElementByName(root, "lastNameText");
				assertTrue(element instanceof Text);
				Text text = (Text) element;
				assertEquals(text.getText(), "DUMAS");
			}
		});
	}

	public void testMultiBindingPath_Update_Outside() throws Exception {
		URL url = MultiBindingTests.class.getResource(MultiBinding.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				Object element = XWT.findElementByName(root, "firstNameText");
				assertTrue(element instanceof Text);
				Text text = (Text) element;
				text.setText("NewFirst");
			}
		}, new Runnable() {
			public void run() {
				Object element = XWT.findElementByName(root, "multiValueText");
				assertTrue(element instanceof Text);
				Text text = (Text) element;
				assertEquals(text.getText(), "NewFirst DUMAS");
			}
		});
	}
}
