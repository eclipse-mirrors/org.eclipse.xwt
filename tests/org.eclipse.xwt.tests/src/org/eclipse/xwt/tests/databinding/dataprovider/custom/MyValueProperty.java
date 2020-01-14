/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.databinding.dataprovider.custom;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.ValueProperty;

public class MyValueProperty extends ValueProperty {

	public MyValueProperty() {
	}

	public Object getValueType() {
		return null;
	}

	public IObservableValue observe(Realm realm, Object source) {
		return null;
	}

	public IObservableList observeDetail(IObservableList master) {
		return null;
	}

	public IObservableMap observeDetail(IObservableSet master) {
		return null;
	}

	public IObservableMap observeDetail(IObservableMap master) {
		return null;
	}

}
