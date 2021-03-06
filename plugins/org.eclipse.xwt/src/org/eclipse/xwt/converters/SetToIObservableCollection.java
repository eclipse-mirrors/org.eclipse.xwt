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

import java.util.Set;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.IObservableCollection;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.xwt.XWT;

/**
 * Set to IObservableCollection converter
 * 
 * @author yyang
 */
public class SetToIObservableCollection implements IConverter {
	public static SetToIObservableCollection instance = new SetToIObservableCollection();

	public Object convert(Object fromObject) {
		Set<?> set = (Set<?>) fromObject;
		return new WritableSet(XWT.getRealm(), (Set<?>)set, Object.class);
	}

	public Object getFromType() {
		return Set.class;
	}

	public Object getToType() {
		return IObservableCollection.class;
	}
}
