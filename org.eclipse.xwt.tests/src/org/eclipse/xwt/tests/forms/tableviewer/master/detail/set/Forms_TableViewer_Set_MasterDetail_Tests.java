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
package org.eclipse.xwt.tests.forms.tableviewer.master.detail.set;

import java.net.URL;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.forms.FormTestCase;

public class Forms_TableViewer_Set_MasterDetail_Tests extends FormTestCase {

	public void testTableViewer_MasterDetail() throws Exception {
		URL url = TableViewer_MasterDetail.class
				.getResource(TableViewer_MasterDetail.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Object element = XWT.findElementByName(root, "TableViewer");
				assertTrue(element instanceof TableViewer);
				TableViewer tableViewer = (TableViewer) element;
				TableItem[] items = tableViewer.getTable().getItems();
				assertTrue(items.length == 2);
				if ("Jin".equals(items[1].getText(0))) {
					assertEquals(items[1].getText(1), "27");
					assertEquals(items[0].getText(0), "Thomas");
					assertEquals(items[0].getText(1), "32");
				} else if ("Thomas".equals(items[1].getText(0))) {
					assertEquals(items[1].getText(1), "32");
					assertEquals(items[0].getText(0), "Jin");
					assertEquals(items[0].getText(1), "27");
				}
			}
		});
	}

	public void testTableViewer_MasterDetail_DetailDisplay() throws Exception {
		URL url = TableViewer_MasterDetail.class
				.getResource(TableViewer_MasterDetail.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Object element = XWT.findElementByName(root, "TableViewer");
				assertTrue(element instanceof TableViewer);
				TableViewer tableViewer = (TableViewer) element;

				IObservableValue observableValue = XWT.findObservableValue(
						root, tableViewer, "singleSelection");

				Company company = (Company) XWT.getDataContext(element);
				Employee employee = company.getEmployees().iterator().next();
				observableValue.setValue(employee);
			}
		}, new Runnable() {
			public void run() {
				checkListViewer();
			}

			public void checkListViewer() {
				Object element = XWT.findElementByName(root, "TableViewer");
				assertTrue(element instanceof TableViewer);
				TableViewer tableViewer = (TableViewer) element;
				TableItem[] items = tableViewer.getTable().getItems();
				assertTrue(items.length == 2);

				Label label = (Label) XWT.findElementByName(root, "Label");
				assertTrue(label != null);

				IObservableValue observableValue = XWT.findObservableValue(
						root, tableViewer, "singleSelection");
				Object selected = observableValue.getValue();
				assertTrue(selected instanceof Employee);
				Employee employee = (Employee) selected;
				assertEquals(label.getText(), employee.getName());
			}
		});
	}
}
