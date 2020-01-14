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
/**
 *
 */
package org.eclipse.xwt.tests.databinding.status;

import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.xwt.XWTException;
import org.eclipse.xwt.validation.AbstractValidationRule;

/**
 * @author hceylan
 *
 */
public class IntValidator extends AbstractValidationRule {

	private String value;

	/**
	 *
	 */
	public IntValidator() {
		super();
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.core.databinding.validation.IValidator#validate(java.lang
	 * .Object)
	 */
	public IStatus validate(Object value) {
		if (this.value.equals(value)){
			return ValidationStatus.ok();
		}

		return ValidationStatus.error("Value must be " + this.value);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.xwt.IValidationRule#validateBack(java.lang.Object)
	 */
	public IStatus validateBack(Object value) {
		return validate(value);
	}

}
