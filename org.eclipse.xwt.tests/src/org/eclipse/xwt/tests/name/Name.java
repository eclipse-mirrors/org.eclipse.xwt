/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.name;

import java.net.URL;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;

/**
 * @author jliu
 */
public class Name {
	public static void main(String[] args) {

		URL url = Name.class.getResource(Name.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.open(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void handleButton(Event event) {
		Label message = (Label) XWT.findElementByName(event.widget, "Message");
		if (message == null) {
			MessageDialog.openError(XWT.findShell(event.widget), "Test Name",
					"Label message is not found");
		} else {
			MessageDialog.openInformation(XWT.findShell(event.widget),
					"Test Name", "Name works.");
		}
	}
}
