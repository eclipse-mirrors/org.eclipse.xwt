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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date to String converter
 * 
 * @author yyang
 */
public class DateToString extends ObjectToString {
	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat();
	public static DateToString instance = new DateToString();

	public DateToString() {
		this(Date.class);
	}

	protected DateToString(Class<?> fromType) {
		super(fromType);
	}

	public Object convert(Object fromObject) {
		if (fromObject == null) {
			return super.convert(null);
		}
		return FORMATTER.format((Date) fromObject);
	}

	public Object getToType() {
		return String.class;
	}
}
