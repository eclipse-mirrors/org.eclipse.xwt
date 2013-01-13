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
package org.eclipse.xwt.tests.snippet019.array;

import java.net.URL;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class Snippet019Tests extends XWTTestCase {
	
	public void testTreeViewerWithListFactory_AddRoot() throws Exception {
		URL url = Snippet019Tests.class.getResource(TreeViewerWithArrayFactory.class.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, TreeViewerWithArrayFactory.createBean("Root"), new Runnable() {
			public void run() {
				Object element = XWT.findElementByName(root, "TreeViewer");
				assertTrue(element instanceof TreeViewer);
				TreeViewer treeViewer = (TreeViewer) element;
				Object dataContext = XWT.getDataContext(element);
				assertTrue(dataContext instanceof Bean);
				Object input = treeViewer.getInput();
				assertTrue(input instanceof Bean);
				assertEquals(input, dataContext);
				
				Button button = (Button) XWT.findElementByName(root, "addRootButton");
				selectButton(button);
			}
		}, 
		new Runnable() {
			public void run() {
				Object viewer = XWT.findElementByName(root, "TreeViewer");
				assertTrue(viewer instanceof TreeViewer);
				TreeViewer treeViewer = (TreeViewer) viewer;
				Object input = treeViewer.getInput();
				assertTrue(input instanceof Bean);
				
				Bean bean = (Bean) input;
				
				assertEquals(bean.getList().length, 1);
			}
		});
	}
	
	
	public void testTreeViewerWithListFactory_AddChild1() throws Exception {
		URL url = Snippet019Tests.class.getResource(TreeViewerWithArrayFactory.class.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, TreeViewerWithArrayFactory.createBean("Root"), new Runnable() {
			public void run() {
				Object element = XWT.findElementByName(root, "TreeViewer");
				assertTrue(element instanceof TreeViewer);
				TreeViewer treeViewer = (TreeViewer) element;
				Object dataContext = XWT.getDataContext(element);
				assertTrue(dataContext instanceof Bean);
				Object input = treeViewer.getInput();
				assertTrue(input instanceof Bean);
				assertEquals(input, dataContext);
				
				Button addChildButton = (Button) XWT.findElementByName(root, "addChildButton");
				assertTrue(!addChildButton.getEnabled());
				
				Button button = (Button) XWT.findElementByName(root, "addRootButton");
				selectButton(button);
			}
		}, 
		new Runnable() {
			public void run() {
				Button addChildbutton = (Button) XWT.findElementByName(root, "addChildButton");
				assertTrue(addChildbutton.getEnabled());
			}
		});
	}

	public void testTreeViewerWithListFactory_AddChild2() throws Exception {
		URL url = Snippet019Tests.class.getResource(TreeViewerWithArrayFactory.class.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, TreeViewerWithArrayFactory.createBean("Root"), new Runnable() {
			public void run() {
				Object element = XWT.findElementByName(root, "TreeViewer");
				assertTrue(element instanceof TreeViewer);
				TreeViewer treeViewer = (TreeViewer) element;
				Object dataContext = XWT.getDataContext(element);
				assertTrue(dataContext instanceof Bean);
				Object input = treeViewer.getInput();
				assertTrue(input instanceof Bean);
				assertEquals(input, dataContext);
				
				Button addChildButton = (Button) XWT.findElementByName(root, "addChildButton");
				assertTrue(!addChildButton.getEnabled());
				
				Button button = (Button) XWT.findElementByName(root, "addRootButton");
				selectButton(button);
				
				selectButton(addChildButton);
			}
		}, 
		new Runnable() {
			public void run() {
				Object viewer = XWT.findElementByName(root, "TreeViewer");
				assertTrue(viewer instanceof TreeViewer);
				TreeViewer treeViewer = (TreeViewer) viewer;
				Object input = treeViewer.getInput();
				assertTrue(input instanceof Bean);
				
				Bean bean = (Bean) input;
				
				assertEquals(bean.getList().length, 1);

				Bean child = bean.getList()[0];
				
				assertEquals(child.getList().length, 1);
			}
		});
	}

	public void testTreeViewerWithListFactory_Remove() throws Exception {
		URL url = Snippet019Tests.class.getResource(TreeViewerWithArrayFactory.class.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, TreeViewerWithArrayFactory.createBean("Root"), new Runnable() {
			public void run() {
				Object element = XWT.findElementByName(root, "TreeViewer");
				assertTrue(element instanceof TreeViewer);
				TreeViewer treeViewer = (TreeViewer) element;
				Object dataContext = XWT.getDataContext(element);
				assertTrue(dataContext instanceof Bean);
				Object input = treeViewer.getInput();
				assertTrue(input instanceof Bean);
				assertEquals(input, dataContext);
				
				Button addChildButton = (Button) XWT.findElementByName(root, "addChildButton");
				assertTrue(!addChildButton.getEnabled());
				
				Button button = (Button) XWT.findElementByName(root, "addRootButton");
				selectButton(button);
				
				selectButton(addChildButton);
				
				Button removeButton = (Button) XWT.findElementByName(root, "removeButton");
				selectButton(removeButton);
			}
		}, 
		new Runnable() {
			public void run() {
				Object viewer = XWT.findElementByName(root, "TreeViewer");
				assertTrue(viewer instanceof TreeViewer);
				TreeViewer treeViewer = (TreeViewer) viewer;
				Object input = treeViewer.getInput();
				assertTrue(input instanceof Bean);
				
				Bean bean = (Bean) input;
				
				assertEquals(bean.getList().length, 1);

				Bean child = bean.getList()[0];
				
				assertEquals(child.getList().length, 0);
				
				Button removeButton = (Button) XWT.findElementByName(root, "addChildButton");
				assertTrue(!removeButton.getEnabled());

				Button addChildButton = (Button) XWT.findElementByName(root, "addChildButton");
				assertTrue(!addChildButton.getEnabled());
			}
		});
	}
}
