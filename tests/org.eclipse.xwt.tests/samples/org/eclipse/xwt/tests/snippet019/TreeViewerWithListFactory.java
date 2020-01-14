/*******************************************************************************
 * Copyright (c) 2005, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Matthew Hall - bugs 260329, 260337
 *     Yves YANG - port to XWT
 *******************************************************************************/
package org.eclipse.xwt.tests.snippet019;

import java.net.URL;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;

public class TreeViewerWithListFactory {
	private IObservableValue clipboard = new WritableValue(XWT.getRealm());
	
	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		URL url = TreeViewerWithListFactory.class.getResource(TreeViewerWithListFactory.class.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.open(url, new Bean("input"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addRoot(Object sender, Event e) {		
		Bean bean = (Bean) XWT.getDataContext(e.widget);
		IObservableList observableList = XWT.findObservableList(e.widget, bean, "list");
		Bean root = createBean("root");
		observableList.add(root);
	
		TreeViewer beanViewer = (TreeViewer) XWT.findElementByName(e.widget, "TreeViewer");
		beanViewer.setSelection(new StructuredSelection(root));
		
		Text beanText = (Text) XWT.findElementByName(e.widget, "nameText");
		beanText.selectAll();
		beanText.setFocus();
	}
	
	public static Bean createBean(String name) {
		return new Bean(name);
	}
	
	public void addChild(Object sender, Event e) {
		TreeViewer beanViewer = (TreeViewer) XWT.findElementByName(e.widget, "TreeViewer");
		IStructuredSelection structuredSelection = (IStructuredSelection) beanViewer.getSelection();
		Bean bean = (Bean) structuredSelection.getFirstElement();
		IObservableList observableList = XWT.findObservableList(e.widget, bean, "list");
		Bean root = createBean("root");
		observableList.add(root);
		
		beanViewer.setSelection(new StructuredSelection(root));
		
		Text beanText = (Text) XWT.findElementByName(e.widget, "nameText");
		beanText.selectAll();
		beanText.setFocus();
	}

	public void remove(Object sender, Event e) {
		TreeViewer beanViewer = (TreeViewer) XWT.findElementByName(e.widget, "TreeViewer");
		IStructuredSelection structuredSelection = (IStructuredSelection) beanViewer.getSelection();
		Bean bean = (Bean) structuredSelection.getFirstElement();
		
		TreeItem selectedItem = beanViewer.getTree().getSelection()[0];
		TreeItem parentItem = selectedItem.getParentItem();
		Bean parent;
		if (parentItem == null) {
			parent = (Bean) beanViewer.getInput();
		} else {
			parent = (Bean) parentItem.getData();
		}
		IObservableList observableList = XWT.findObservableList(e.widget, parent, "list");
		observableList.remove(bean);
	}

	public void copy(Object sender, Event e) {
		TreeViewer beanViewer = (TreeViewer) XWT.findElementByName(e.widget, "TreeViewer");
		IStructuredSelection structuredSelection = (IStructuredSelection) beanViewer.getSelection();
		Bean bean = (Bean) structuredSelection.getFirstElement();
		clipboard.setValue(bean);
	}

	public void paste(Object sender, Event e) {
		TreeViewer beanViewer = (TreeViewer) XWT.findElementByName(e.widget, "TreeViewer");
		IStructuredSelection structuredSelection = (IStructuredSelection) beanViewer.getSelection();
		Bean bean = (Bean) structuredSelection.getFirstElement();
		IObservableList observableList = XWT.findObservableList(e.widget, bean, "list");
		Bean child = (Bean) clipboard.getValue();
		observableList.add(child);
		
		beanViewer.setSelection(new StructuredSelection(child));
		
		Text beanText = (Text) XWT.findElementByName(e.widget, "nameText");
		beanText.selectAll();
		beanText.setFocus();
	}

	public void refresh(Object sender, Event e) {
		TreeViewer beanViewer = (TreeViewer) XWT.findElementByName(e.widget, "TreeViewer");
		beanViewer.refresh();
	}
}
