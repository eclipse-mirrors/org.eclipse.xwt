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
import org.eclipse.xwt.core.IBinding;

/**
 * Binding to Object covnerter
 * 
 * @author yyang
 */
public class BindingToObject implements IConverter {
	public static BindingToObject instance = new BindingToObject();

	public Object convert(Object fromObject) {
		IBinding binding = (IBinding) fromObject;
		return binding.getValue(null);
	}

	public Object getFromType() {
		return IBinding.class;
	}

	public Object getToType() {
		return Object.class;
	}
}
