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
package org.eclipse.xwt.converters;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.xwt.XWTException;

/**
 * String to Boolean converter
 * 
 * @author yyang
 */
public class StringToChar implements IConverter {
	public static StringToChar instance = new StringToChar();

	public Object convert(Object fromObject) {
		String str = (String) fromObject;
		if (str != null) {
			str = str.trim();
			if (str.length() > 0) {
				char c = str.charAt(0);
				return c;
			}
		}
		throw new XWTException(str + " is not a character");
	}

	public Object getFromType() {
		return String.class;
	}

	public Object getToType() {
		return Character.class;
	}
}
