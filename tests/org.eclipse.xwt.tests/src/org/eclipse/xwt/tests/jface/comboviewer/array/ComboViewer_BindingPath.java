/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.jface.comboviewer.array;

import java.net.URL;

import org.eclipse.core.databinding.observable.IObservableCollection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;

public class ComboViewer_BindingPath {
	public static void main(String[] args) {

		URL url = ComboViewer_BindingPath.class
				.getResource(ComboViewer_BindingPath.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.open(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void addPerson(Object sender, Event event) {
		org.eclipse.jface.viewers.Viewer viewer = (org.eclipse.jface.viewers.Viewer) XWT
				.findElementByName(event.widget, "ComboViewer");
		IObservableCollection collection = (IObservableCollection) viewer
				.getInput();
		Employee employee = new Employee();
		employee.setName("New hired one");
		collection.add(employee);
	}
}
