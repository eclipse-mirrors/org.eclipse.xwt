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
package org.eclipse.xwt.tests.databinding.dataprovider.custom;

import java.net.URL;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.IDataProvider;
import org.eclipse.xwt.IDataProviderFactory;
import org.eclipse.xwt.XWT;

/**
 * Introduce the Default Data provider
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class CustomDataProvider_Default {
	public static void main(String[] args) {
		URL url = CustomDataProvider_Default.class
				.getResource(CustomDataProvider_Default.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.addDataProviderFactory("MyDataProviderfactory", new IDataProviderFactory() {
				@Override
				public Class<?> getType() {
					return CustomDataProvider.class;
				}

				@Override
				public IDataProvider create(Object dataContext) {
					if (dataContext instanceof DynamicObject) {
						CustomDataProvider provider = new CustomDataProvider();
						provider.setObjectInstance((DynamicObject) dataContext);
						return provider;
					}
					return null;
				}
			});
			XWT.open(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
