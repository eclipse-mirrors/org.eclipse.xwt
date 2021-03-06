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

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.xwt.XWTException;

/**
 * String to int[] converter
 * 
 * @author jliu
 */
public class StringToIntArray implements IConverter {
	public static StringToIntArray instance = new StringToIntArray();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#convert(java.lang. Object)
	 */
	public Object convert(Object fromObject) {
		String source = (String) fromObject;
		List<Integer> result = new ArrayList<Integer>();
		StringTokenizer stk = new StringTokenizer(source, ",");
		while (stk.hasMoreTokens()) {
			String nextToken = stk.nextToken();
			try {
				result.add(Integer.parseInt(nextToken.trim()));
			} catch (NumberFormatException e) {
				throw new XWTException(source + " is not integer array");
			}
		}
		int[] intArray = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			intArray[i] = result.get(i);
		}
		return intArray;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#getFromType()
	 */
	public Object getFromType() {
		return String.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#getToType()
	 */
	public Object getToType() {
		return int[].class;
	}

}
