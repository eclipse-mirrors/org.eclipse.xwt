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

import java.lang.reflect.InvocationTargetException;

/**
 * 
 * This is a new type of dynamic properties, some properties, such as texts for TableItem and TreeItem, we used the setText(String[]) and String = getText();
 * 
 * @author jliu
 * 
 */
public class DynamicBeanProperty extends DynamicProperty {

	public DynamicBeanProperty(Class<?> type, Class<?> propertyType, String propertyName) {
		super(propertyType, createSetter0(type, propertyType, propertyName), null, propertyName);
	}

	public DynamicBeanProperty(Class<?> type, Class<?> propertyType, String propertyName, String setterName) {
		super(propertyType, createSetter0(type, propertyType, setterName), null, propertyName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.javabean.metadata.properties.DynamicProperty#getValue (java.lang.Object)
	 */
	@Override
	public Object getValue(Object target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		throw new UnsupportedOperationException();
	}
}
