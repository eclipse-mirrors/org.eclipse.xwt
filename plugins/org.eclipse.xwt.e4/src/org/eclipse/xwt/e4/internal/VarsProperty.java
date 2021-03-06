/*******************************************************************************
 * Copyright (c) 2013 Eclipse XWT Project.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Erdal Karaca - initial API and implementation
 ******************************************************************************/
package org.eclipse.xwt.e4.internal;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.xwt.javabean.metadata.properties.AbstractProperty;
import org.eclipse.xwt.metadata.DefaultLoadingType;
import org.eclipse.xwt.metadata.IProperty;
import org.eclipse.xwt.metadata.IValueLoading;

public class VarsProperty extends AbstractProperty {
	public VarsProperty() {
		super("Vars", Var[].class, new DefaultLoadingType(
				IValueLoading.Normal, new IProperty[0]));
	}

	public void setValue(Object target, Object value)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SecurityException, NoSuchFieldException {
	}

	public Object getValue(Object target) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			SecurityException, NoSuchFieldException {
		return null;
	}
}
