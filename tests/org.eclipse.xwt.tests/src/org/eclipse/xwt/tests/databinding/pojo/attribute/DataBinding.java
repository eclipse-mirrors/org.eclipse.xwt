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
package org.eclipse.xwt.tests.databinding.pojo.attribute;

import java.net.URL;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;

public class DataBinding {
	public static void main(String[] args) {

		URL url = DataBinding.class.getResource(DataBinding.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.open(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void onNew(Event event) {
		Shell shell = (Shell) XWT.findElementByName(event.widget, "Root");
		Company company = (Company) XWT.getDataContext(shell);
		company.setNAME("Eclipse");
		IObservableValue managerValue = XWT.observableValue(shell, company,
				"name");
		managerValue.setValue("Eclipse");
	}
}
