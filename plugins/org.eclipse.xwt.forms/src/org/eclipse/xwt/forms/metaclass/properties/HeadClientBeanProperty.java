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
package org.eclipse.xwt.forms.metaclass.properties;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.xwt.javabean.metadata.properties.BeanProperty;

public class HeadClientBeanProperty extends BeanProperty {

	public HeadClientBeanProperty(PropertyDescriptor descriptor) {
		super(descriptor);
		setValueAsParent(true);
	}
		
	@Override
	public Object getValue(Object target) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			SecurityException, NoSuchFieldException {
		Object value = super.getValue(target);
		if (value == null) {
			Form form = (Form) target;
			return form.getHead();
		}
		return value;
	}
}
