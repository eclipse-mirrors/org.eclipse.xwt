/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec and hceylan - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.databinding.bindcontrol;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.xwt.IValueConverter;

/**
 * A Converter that converts boolean values with not operator
 *
 * @author hceylan
 *
 */
public class NotConverter extends Converter implements IValueConverter {

	/**
	 *
	 */
	public NotConverter() {
		super(Boolean.class, Boolean.class);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.databinding.conversion.IConverter#convert(java.lang.Object)
	 */
	public Object convert(Object fromObject) {
		return !((Boolean) fromObject);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.xwt.IValueConverter#convertBack(java.lang.Object)
	 */
	public Object convertBack(Object value) {
		return this.convert(value);
	}

}
