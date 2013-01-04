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
package org.eclipse.xwt.tests.forms;

import java.net.URL;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.forms.XWTForms;

public class Form_Background {
	public static void main(String[] args) {

		URL url = Form_Background.class.getResource(Form_Background.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWTForms.open(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
