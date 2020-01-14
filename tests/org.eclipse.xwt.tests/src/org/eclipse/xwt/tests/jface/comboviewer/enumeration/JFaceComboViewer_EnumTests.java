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
package org.eclipse.xwt.tests.jface.comboviewer.enumeration;

import java.net.URL;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class JFaceComboViewer_EnumTests extends XWTTestCase {

	public void test_ComboViewer_enum() throws Exception {
		URL url = JFaceComboViewer_EnumTests.class
				.getResource(ComboViewer_enum.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkListViewer();
			}

			public void checkListViewer() {
				Object element = XWT.findElementByName(root, "ComboViewer");
				assertTrue(element instanceof org.eclipse.jface.viewers.ComboViewer);
				org.eclipse.jface.viewers.ComboViewer comboViewer = (org.eclipse.jface.viewers.ComboViewer) element;
				String[] items = comboViewer.getCombo().getItems();
				assertTrue(items.length == 3);
				Object input = comboViewer.getInput();
				assertTrue(input instanceof WritableList);
				WritableList list = (WritableList) input;
				assertTrue(list.contains(EmployeeType.FullTime));
				assertTrue(list.contains(EmployeeType.PartialTime));
				assertTrue(list.contains(EmployeeType.Unemployed));
			}
		});
	}

	public void test_ComboViewer_enum_singleSelection() throws Exception {
		URL url = JFaceComboViewer_EnumTests.class
				.getResource(ComboViewer_enum_singleSelection.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkListViewer();
			}

			public void checkListViewer() {
				Object element = XWT.findElementByName(root, "ComboViewer");
				assertTrue(element instanceof org.eclipse.jface.viewers.ComboViewer);
				org.eclipse.jface.viewers.ComboViewer comboViewer = (org.eclipse.jface.viewers.ComboViewer) element;
				String[] items = comboViewer.getCombo().getItems();
				assertTrue(items.length == 3);
				IStructuredSelection selection = (IStructuredSelection) comboViewer.getSelection();
				assertTrue(selection.size() == 1);
				assertEquals(selection.getFirstElement(), EmployeeType.FullTime);
			}
		});
	}
}
