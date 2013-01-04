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
package org.eclipse.xwt.tests.controls.ccombo;

import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class CComboTests extends XWTTestCase {

	public void testCComboStyle() throws Exception {
		Runnable prepare = new Runnable() {
			public void run() {
			}
		};

		Runnable checker = new Runnable() {
			public void run() {
				checkComboStyle("combo1", SWT.READ_ONLY);
				checkComboStyle("combo2", SWT.FLAT);
				checkComboStyle("combo3", SWT.BORDER);
			}

			public void checkComboStyle(String name, int style) {
				Object element = XWT.findElementByName(root, name);
				assertTrue(element instanceof CCombo);
				CCombo combo = (CCombo) element;
				assertTrue((combo.getStyle() & style) == style);
			}
		};

		URL url = CCombo_Styles.class.getResource(CCombo_Styles.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, prepare, checker);
	}

	public void testCComboItems() throws Exception {
		Runnable prepare = new Runnable() {
			public void run() {
			}
		};

		Runnable checker = new Runnable() {
			public void run() {
				checkComboItems("combo1", new String[] { "Item1", "Item2",
						"Item3", "Item4" });
			}

			public void checkComboItems(String name, String[] items) {
				Object element = XWT.findElementByName(root, name);
				assertTrue(element instanceof CCombo);
				CCombo combo = (CCombo) element;
				assertEqualsArray(combo.getItems(), items);
			}
		};

		URL url = CCombo_Styles.class.getResource(CCombo_Styles.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, prepare, checker);
	}

	public void testCComboText() throws Exception {
		Runnable prepare = new Runnable() {
			public void run() {
			}
		};

		Runnable checker = new Runnable() {
			public void run() {
				checkComboText("combo3", "Item3");
			}

			public void checkComboText(String name, String item) {
				Object element = XWT.findElementByName(root, name);
				assertTrue(element instanceof CCombo);
				CCombo combo = (CCombo) element;
				assertEquals(combo.getText(), item);
			}
		};

		URL url = CCombo_Styles.class.getResource(CCombo_Styles.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, prepare, checker);
	}
}
