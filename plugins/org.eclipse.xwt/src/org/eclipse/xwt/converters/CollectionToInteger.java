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

import java.util.Collection;

import org.eclipse.core.databinding.conversion.IConverter;

/**
 * String to Boolean converter
 * 
 * @author yyang
 */
public class CollectionToInteger implements IConverter {
	public static CollectionToInteger instance = new CollectionToInteger();

	public Object convert(Object fromObject) {
		Collection<?> collection = (Collection<?>) fromObject;
		return collection.size();
	}

	public Object getFromType() {
		return Collection.class;
	}

	public Object getToType() {
		return Integer.class;
	}
}
