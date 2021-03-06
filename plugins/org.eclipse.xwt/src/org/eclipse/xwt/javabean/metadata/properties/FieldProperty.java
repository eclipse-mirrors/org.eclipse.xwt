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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.XWTException;
import org.eclipse.xwt.internal.utils.ObjectUtil;

/**
 * @author jliu
 * 
 */
public class FieldProperty extends AbstractProperty {

	private Field field;

	public FieldProperty(Field field) {
		super(field.getName(), field.getType());
		this.field = field;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.metadata.IProperty#getValue(java.lang.Object)
	 */
	@Override
	public Object getValue(Object target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		return field.get(target);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.metadata.IProperty#setValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void setValue(Object target, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		if (value != null) {
			Class<?> fieldType = field.getType();
			Class<?> valueType = value.getClass();
			if (!ObjectUtil.isAssignableFrom(fieldType, valueType)) {
				IConverter converter = XWT.findConvertor(valueType, fieldType);
				if (converter != null) {
					value = converter.convert(value);
				} else {
					throw new XWTException("Converter " + valueType.getName() + "->" + fieldType.getName());
				}
			}
		}
		field.set(target, value);
		fireSetPostAction(target, this, value);
	}

	@Override
	public boolean isDefault() {
		return true;
	}
}
