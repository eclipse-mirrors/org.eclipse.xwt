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
import org.eclipse.core.runtime.IStatus;

/**
 * Binding to Object covnerter
 * 
 * @author yyang
 */
public class IStatusToBoolean implements IConverter {
	public static IStatusToBoolean instance = new IStatusToBoolean();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.databinding.conversion.IConverter#convert(java.lang.
	 * Object)
	 */
	public Object convert(Object fromObject) {
		IStatus status = (IStatus) fromObject;
		return status.isOK();
	}

	public Object getFromType() {
		return IStatus.class;
	}

	public Object getToType() {
		return Boolean.class;
	}
}
