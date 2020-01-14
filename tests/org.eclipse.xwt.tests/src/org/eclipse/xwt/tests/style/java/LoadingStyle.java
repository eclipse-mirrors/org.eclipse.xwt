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
package org.eclipse.xwt.tests.style.java;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.IXWTLoader;
import org.eclipse.xwt.XWT;

public class LoadingStyle {

	/**
	 * Style is provided in loading. The style is applied only on this file.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		URL url = LoadingStyle.class.getResource("Style"
				+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			Map<String, Object> options = new HashMap<String, Object>();
			options.put(IXWTLoader.DEFAULT_STYLES_PROPERTY, new GreenStyle());
			XWT.open(url, options);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
