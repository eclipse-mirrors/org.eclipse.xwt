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
package org.eclipse.xwt.internal.core;

import org.eclipse.xwt.core.IDynamicValueBinding;
import org.eclipse.xwt.metadata.IProperty;

public class DynamicValueBinding<T> extends DynamicBinding implements
		IDynamicValueBinding {
	private T sourceValue;

	private IProperty property;
	private Object object;

	public DynamicValueBinding(T sourceValue) {
		this.sourceValue = sourceValue;
	}

	public IProperty getProperty() {
		return property;
	}

	public void setProperty(IProperty property) {
		this.property = property;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public T getSourceValue() {
		return sourceValue;
	}

	public Object getValue(Class<?> type) {
		return sourceValue;
	}

	public void reset() {
	}

	public Object createBoundSource() {
		return null;
	}

	public boolean isSourceControl() {
		return false;
	}
	
	
}
