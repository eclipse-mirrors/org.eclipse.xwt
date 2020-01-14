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
package org.eclipse.xwt.tests.jface.listviewer.array;

import java.net.URL;

import org.eclipse.core.databinding.observable.IObservableCollection;
import org.eclipse.swt.widgets.Button;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;
import org.eclipse.xwt.tests.jface.listviewer.collection.JFaceListViewer_CollectionTests;
import org.eclipse.xwt.tests.jface.listviewer.collection.ListViewer;

public class JFaceListViewer_ArrayTests extends XWTTestCase {

	public void testListViewer() throws Exception {
		URL url = JFaceListViewer_ArrayTests.class.getResource(ListViewer.class
				.getSimpleName()
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

	// TODO add Font and Color
}
