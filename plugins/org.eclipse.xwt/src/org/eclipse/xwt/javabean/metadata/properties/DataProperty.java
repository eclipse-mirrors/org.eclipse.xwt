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
package org.eclipse.xwt.javabean.metadata.properties;

import org.eclipse.xwt.internal.utils.UserData;
import org.eclipse.xwt.metadata.ILoadingType;

/**
 * Additional property to store in user data in widget
 * 
 * @author yyang
 *
 */
public class DataProperty extends AbstractProperty {
	protected String key;
	protected Object defaultValue;

	public DataProperty(String name, String key) {
		this(name, key, Object.class, null);
	}

	public DataProperty(String name, String key, Class<?> propertyType) {
		this(name, key, propertyType, null);
	}

	public DataProperty(String name, String key, Class<?> propertyType, Object defaultValue) {
		this(name, key, propertyType, defaultValue, ILoadingType.DEFAULT);
	}

	public DataProperty(String name, String key, Class<?> propertyType, Object defaultValue, ILoadingType loadingType) {
		super(name, propertyType, loadingType);
		this.key = key;
		this.defaultValue = defaultValue;
	}

	public Object getValue(Object target) {
		Object object = UserData.getLocalData(target, key);
		if (object == null) {
			return defaultValue;
		}
		return object;
	}

	public void setValue(Object target, Object value) {
		UserData.setLocalData(target, key, value);
	}
}
