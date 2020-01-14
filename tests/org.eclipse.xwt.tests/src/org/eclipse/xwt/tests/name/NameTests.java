/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.name;

import java.net.URL;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class NameTests extends XWTTestCase {

	public void testName() throws Exception {
		URL url = NameTests.class.getResource(Name.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Object element = XWT.findElementByName(root, "Message");
				assertTrue(element instanceof Label);
			}
		});
	}

	public void testNameX() throws Exception {
		URL url = NameTests.class.getResource(Name_x.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Object element = XWT.findElementByName(root, "Message");
				assertTrue(element instanceof Label);
			}
		});
	}

	public void testElementName() throws Exception {
		URL url = NameTests.class.getResource(ElementName_get.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Object element = XWT.getElementName(root);
				assertEquals("LabelElement", element);
			}
		});
	}

	public void testElementNameX() throws Exception {
		URL url = NameTests.class.getResource(ElementName_x_get.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Object element = XWT.getElementName(root);
				assertEquals("LabelElement", element);
			}
		});
	}

	public void testNameMenu() throws Exception {
		URL url = NameTests.class.getResource(Name_Menu.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Object element = XWT.findElementByName(root, "Message");
				assertTrue(element instanceof MenuItem);
			}
		});
	}
}
