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

import java.util.List;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.IObservableCollection;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.xwt.XWT;

/**
 * List to IObservableCollection converter
 * 
 * @author yyang
 */
public class ListToIObservableCollection implements IConverter {
	public static ListToIObservableCollection instance = new ListToIObservableCollection();

	public Object convert(Object fromObject) {
		List<?> list = (List<?>) fromObject;
		return new WritableList(XWT.getRealm(), (List<?>)list, Object.class);
	}

	public Object getFromType() {
		return List.class;
	}

	public Object getToType() {
		return IObservableCollection.class;
	}
}
