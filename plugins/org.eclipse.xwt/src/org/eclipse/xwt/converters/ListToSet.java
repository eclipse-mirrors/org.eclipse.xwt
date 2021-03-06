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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.conversion.IConverter;

/**
 * String to Boolean converter
 * 
 * @author yyang
 */
public class ListToSet implements IConverter {
	public static ListToSet instance = new ListToSet();

	public Object convert(Object fromObject) {
		List<?> list = (List<?>) fromObject;
		return new HashSet<Object>(list);
	}

	public Object getFromType() {
		return List.class;
	}

	public Object getToType() {
		return Set.class;
	}
}
