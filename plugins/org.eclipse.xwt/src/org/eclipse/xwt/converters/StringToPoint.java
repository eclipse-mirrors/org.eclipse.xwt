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
import org.eclipse.swt.graphics.Point;

/**
 * String to Point converter
 * 
 * @author yyang
 */
public class StringToPoint implements IConverter {
	public static StringToPoint instance = new StringToPoint();

	public Object convert(Object fromObject) {
		int x = 0;
		int y = 0;
		if (fromObject != null) {
			StringToIntArray convArray = new StringToIntArray();
			int[] array = (int[]) convArray.convert(fromObject);
			if (array.length == 2) {
				x = array[0];
				y = array[1];
			}
		}
		return new Point(x, y);
	}

	public Object getFromType() {
		return String.class;
	}

	public Object getToType() {
		return Point.class;
	}

}
