/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.converters;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.xwt.IValueConverter;
import org.eclipse.xwt.XWT;

/**
 * The operation to inverse the converter direction.
 * 
 * @author yyang
 * 
 */
public class ValueConverterAdapter implements IValueConverter {
	private IConverter fromConvertor;
	private IConverter toConvertor;
	
	public ValueConverterAdapter(IConverter fromConvertor, IConverter toConvertor) {
		this.fromConvertor = fromConvertor;
		this.toConvertor = toConvertor;
	}

	public Object convertBack(Object value) {
		return toConvertor.convert(value);
	}

	public Object convert(Object fromObject) {
		return fromConvertor.convert(fromObject);
	}

	public Object getFromType() {
		return fromConvertor.getFromType();
	}

	public Object getToType() {
		return toConvertor.getFromType();
	}
	
	public static ValueConverterAdapter create(Class<?> sourceType, Class<?> targetType) {
		IConverter fromConvertor = XWT.findConvertor(sourceType, targetType);
		if (fromConvertor == null) {
			return null;
		}
		IConverter toConvertor = XWT.findConvertor(targetType, sourceType);
		if (toConvertor == null) {
			return null;
		}
		return new ValueConverterAdapter(fromConvertor, toConvertor);
	}
}
