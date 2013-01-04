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
package org.eclipse.xwt.tests.keybinding;

import java.net.URL;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;

public class keybinding {
	public static void main(String[] args) {

		URL url = keybinding.class.getResource(keybinding.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.open(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void helloWorld(Event event) {
		MessageDialog.openInformation(XWT.findShell(event.widget), "Message",
				"Hello World!");
	}
}
