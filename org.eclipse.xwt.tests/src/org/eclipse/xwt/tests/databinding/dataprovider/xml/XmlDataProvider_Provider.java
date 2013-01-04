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
package org.eclipse.xwt.tests.databinding.dataprovider.xml;

import java.net.URL;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.xml.XmlDataProvider;

public class XmlDataProvider_Provider {
	public static void main(String[] args) {
		XWT.registerMetaclass(XmlDataProvider.class);

		URL url = XmlDataProvider_Provider.class
				.getResource(XmlDataProvider_Provider.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		XmlDataProvider dataProvider = new XmlDataProvider();
		dataProvider.setSource(XmlDataProvider_Provider.class
				.getResource("books_test.xml"));
		try {
			XWT.open(url, dataProvider);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
