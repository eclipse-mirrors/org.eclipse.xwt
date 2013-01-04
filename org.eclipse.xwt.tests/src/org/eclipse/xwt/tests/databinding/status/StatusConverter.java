/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.databinding.status;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.xwt.IValueConverter;

public class StatusConverter extends Converter implements IValueConverter {

	/**
	 *
	 */
	public StatusConverter() {
		super(Object.class, String.class);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xwt.IValueConverter#convertBack(java.lang.Object)
	 */
	public Object convertBack(Object value) {
		return ValidationStatus.error((String) value);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.databinding.conversion.IConverter#convert(java.lang.Object)
	 */
	public Object convert(Object fromObject) {
		IStatus status = (IStatus) fromObject;

		if (fromObject == null){
			return ""; //$NON-NLS-1$
		}

		return status.getMessage();
	}
}
