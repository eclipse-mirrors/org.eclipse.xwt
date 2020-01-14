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
package org.eclipse.xwt.converters;

import org.eclipse.core.databinding.conversion.IConverter;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class StringToEnum implements IConverter {

	private Class<?> toType;

	public StringToEnum(Class<?> toType) {
		this.toType = toType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#convert(java.lang.Object)
	 */
	@Override
	public Object convert(Object fromObject) {
		if (fromObject == null || "".equals(fromObject)) {
			Class<?> type = (Class<?>) getToType();
			Object[] values = type.getEnumConstants();
			if (values != null && values.length > 0) {
				return values[0];
			}
		}

		return Enum.valueOf((Class) getToType(), (String) fromObject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#getFromType()
	 */
	@Override
	public Object getFromType() {
		return String.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#getToType()
	 */
	@Override
	public Object getToType() {
		return toType;
	}

	public void setToType(Class<?> toType) {
		this.toType = toType;
	}

}
