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
package org.eclipse.xwt.tests.controls.tree;

import java.net.URL;

import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class TreeTests extends XWTTestCase {

	public void testTree() throws Exception {
		URL url = TreeTests.class.getResource(Tree_Expanded.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Object element = XWT.findElementByName(root, "TreeItem");
				assertTrue(element instanceof TreeItem);
				TreeItem treeItem = (TreeItem) element;
				assertTrue(treeItem.getItemCount() == 2);
			}
		});
	}
	
	public void testTree_Columns() throws Exception {
		URL url = TreeTests.class.getResource(Tree_Columns.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Object element = XWT.findElementByName(root, "TreeItem");
				assertTrue(element instanceof TreeItem);
				TreeItem treeItem = (TreeItem) element;
				assertTrue(treeItem.getItemCount() == 2);
				assertEquals("1", treeItem.getText(2));
				assertEquals("classes", treeItem.getText(1));
			}
		});
	}


	public void testTree_Expanded() throws Exception {
		URL url = TreeTests.class.getResource(Tree_Expanded.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Object element = XWT.findElementByName(root, "TreeItem");
				assertTrue(element instanceof TreeItem);
				TreeItem treeItem = (TreeItem) element;
				assertTrue(treeItem.getExpanded());
			}
		});
	}
}
