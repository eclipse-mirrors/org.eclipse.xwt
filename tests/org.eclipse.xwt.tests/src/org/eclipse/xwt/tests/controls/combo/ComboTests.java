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
package org.eclipse.xwt.tests.controls.combo;

import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class ComboTests extends XWTTestCase {

	public void testComboStyle() throws Exception {
		Runnable prepare = new Runnable() {
			public void run() {
			}
		};

		Runnable checker = new Runnable() {
			public void run() {
				checkComboStyle("combo1", SWT.DROP_DOWN);
				checkComboStyle("combo2", SWT.DROP_DOWN | SWT.READ_ONLY);
				checkComboStyle("combo3", SWT.SIMPLE);
			}

			public void checkComboStyle(String name, int style) {
				Object element = XWT.findElementByName(root, name);
				assertTrue(element instanceof Combo);
				Combo combo = (Combo) element;
				assertTrue((combo.getStyle() & style) == style);
			}
		};

		URL url = Combo_Styles.class.getResource(Combo_Styles.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, prepare, checker);
	}

	public void testComboItems() throws Exception {
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
				assertTrue(element instanceof Combo);
				Combo combo = (Combo) element;
				assertEqualsArray(combo.getItems(), items);
			}
		};

		URL url = Combo_Styles.class.getResource(Combo_Styles.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, prepare, checker);
	}

	public void testComboText() throws Exception {
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
				assertTrue(element instanceof Combo);
				Combo combo = (Combo) element;
				assertEquals(combo.getText(), item);
			}
		};

		URL url = Combo_Styles.class.getResource(Combo_Styles.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, prepare, checker);
	}
}
