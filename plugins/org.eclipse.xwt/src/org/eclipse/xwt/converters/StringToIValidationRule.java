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
import org.eclipse.xwt.IValidationRule;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.XWTException;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class StringToIValidationRule implements IConverter {
	public static StringToIValidationRule instance = new StringToIValidationRule();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#convert(java.lang.Object)
	 */
	@Override
	public Object convert(Object fromObject) {
		try {
			Class<?> type = XWT.getLoadingContext().loadClass(fromObject.toString());
			if (type == null) {
				throw new XWTException("Class " + fromObject.toString() + " is not found.");
			}
			return type.newInstance();
		} catch (Exception e) {
			throw new XWTException(e);
		}
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
		return IValidationRule.class;
	}
}
