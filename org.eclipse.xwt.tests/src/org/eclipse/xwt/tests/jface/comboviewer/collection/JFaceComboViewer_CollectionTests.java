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
package org.eclipse.xwt.tests.jface.comboviewer.collection;

import java.net.URL;

import org.eclipse.core.databinding.observable.IObservableCollection;
import org.eclipse.swt.widgets.Button;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class JFaceComboViewer_CollectionTests extends XWTTestCase {

	public void test_ComboViewer() throws Exception {
		URL url = JFaceComboViewer_CollectionTests.class
				.getResource(ComboViewer.class.getSimpleName()
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
				assertTrue(items.length == 2);
				assertEquals(items[0], "Thomas");
				assertEquals(items[1], "Jin");
			}
		});
	}

	public void test_ComboViewer_Simple() throws Exception {
		URL url = JFaceComboViewer_CollectionTests.class
				.getResource(ComboViewer_Simple.class.getSimpleName()
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
				assertTrue(items.length == 2);
				assertEquals(items[0], "Thomas");
				assertEquals(items[1], "Jin");
			}
		});
	}

	public void test_ComboViewer_DataBinding() {
		URL url = JFaceComboViewer_CollectionTests.class
				.getResource(ComboViewer.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Button button = (Button) XWT.findElementByName(root, "Button");
				selectButton(button);
			}
		}, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				org.eclipse.jface.viewers.ComboViewer comboViewer = (org.eclipse.jface.viewers.ComboViewer) XWT
						.findElementByName(root, "ComboViewer");
				assertTrue(comboViewer.getInput() instanceof IObservableCollection);
				IObservableCollection collection = (IObservableCollection) comboViewer
						.getInput();
				assertTrue(collection.size() == 3);
			}
		});
	}

	public void test_ComboViewer_BindingPath() {
		URL url = JFaceComboViewer_CollectionTests.class
				.getResource(ComboViewer_BindingPath.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Button button = (Button) XWT.findElementByName(root, "Button");
				selectButton(button);
			}
		}, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				org.eclipse.jface.viewers.ComboViewer comboViewer = (org.eclipse.jface.viewers.ComboViewer) XWT
						.findElementByName(root, "ComboViewer");
				assertTrue(comboViewer.getInput() instanceof IObservableCollection);
				IObservableCollection collection = (IObservableCollection) comboViewer
						.getInput();
				assertTrue(collection.size() == 3);
			}
		});
	}
}
