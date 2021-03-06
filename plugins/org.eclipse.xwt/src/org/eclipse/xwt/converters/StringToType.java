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
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.metadata.IMetaclass;

/**
 * String to Type converter
 * 
 * @author yyang
 */
public class StringToType implements IConverter {
	public static StringToType instance = new StringToType();

	public Object convert(Object fromObject) {
		String str = (String) fromObject;
		String typeName = str;
		String namespace = IConstants.XWT_NAMESPACE;
		int index = str.lastIndexOf(':');
		if (index != -1) {
			typeName = str.substring(index + 1);
			namespace = str.substring(0, index);
		}
		IMetaclass metaclass = XWT.getMetaclass(typeName, namespace);
		if (metaclass != null) {
			return metaclass.getType();
		}
		return null;
	}

	public Object getFromType() {
		return String.class;
	}

	public Object getToType() {
		return Class.class;
	}
}
