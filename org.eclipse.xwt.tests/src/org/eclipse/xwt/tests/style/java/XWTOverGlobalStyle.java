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
package org.eclipse.xwt.tests.style.java;

import java.net.URL;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;

public class XWTOverGlobalStyle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		URL url = XWTOverGlobalStyle.class.getResource("RedStyle"
				+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.addDefaultStyle(new GreenStyle());
			XWT.open(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
