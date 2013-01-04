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
package org.eclipse.xwt.tests.jface.listviewer.collection;

import java.net.URL;

import org.eclipse.core.databinding.observable.IObservableCollection;
import org.eclipse.swt.widgets.Button;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class JFaceListViewer_CollectionTests extends XWTTestCase {

	public void testListViewer() throws Exception {
		URL url = JFaceListViewer_CollectionTests.class
				.getResource(ListViewer.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkListViewer();
			}

			public void checkListViewer() {
				Object element = XWT.findElementByName(root, "ListViewer");
				assertTrue(element instanceof org.eclipse.jface.viewers.ListViewer);
				org.eclipse.jface.viewers.ListViewer listViewer = (org.eclipse.jface.viewers.ListViewer) element;
				String[] items = listViewer.getList().getItems();
				assertTrue(items.length == 2);
				assertEquals(items[0], "Thomas");
				assertEquals(items[1], "Jin");
			}
		});
	}

	public void testListViewer_Simple() throws Exception {
		URL url = JFaceListViewer_CollectionTests.class
				.getResource(ListViewer_Simple.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkListViewer();
			}

			public void checkListViewer() {
				Object element = XWT.findElementByName(root, "ListViewer");
				assertTrue(element instanceof org.eclipse.jface.viewers.ListViewer);
				org.eclipse.jface.viewers.ListViewer listViewer = (org.eclipse.jface.viewers.ListViewer) element;
				String[] items = listViewer.getList().getItems();
				assertTrue(items.length == 2);
				assertEquals(items[0], "Thomas");
				assertEquals(items[1], "Jin");
			}
		});
	}

	public void test_ListViewer_DataBinding() {
		URL url = JFaceListViewer_CollectionTests.class
				.getResource(ListViewer.class.getSimpleName()
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
				org.eclipse.jface.viewers.ListViewer listView = (org.eclipse.jface.viewers.ListViewer) XWT
						.findElementByName(root, "ListViewer");
				assertTrue(listView.getInput() instanceof IObservableCollection);
				IObservableCollection collection = (IObservableCollection) listView
						.getInput();
				assertTrue(collection.size() == 3);
			}
		});
	}

	public void test_ListViewer_BindingPath() {
		URL url = JFaceListViewer_CollectionTests.class
				.getResource(ListViewer_BindingPath.class.getSimpleName()
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
				org.eclipse.jface.viewers.ListViewer listView = (org.eclipse.jface.viewers.ListViewer) XWT
						.findElementByName(root, "ListViewer");
				assertTrue(listView.getInput() instanceof IObservableCollection);
				IObservableCollection collection = (IObservableCollection) listView
						.getInput();
				assertTrue(collection.size() == 3);
			}
		});
	}
}
