/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec & hceylan - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.databinding.validation;

import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.xwt.validation.AbstractValidationRule;

/**
 * @author hceylan
 *
 */
public class RequiredValidationRule extends AbstractValidationRule {

	/**
	 *
	 */
	public RequiredValidationRule() {
		super();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.xwt.IValueValidator#validateBack(java.lang.Object)
	 */
	public IStatus validateBack(Object value) {
		return ValidationStatus.ok();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.core.databinding.validation.IValidator#validate(java.lang
	 * .Object)
	 */
	public IStatus validate(Object value) {
		if (value == null || value.toString().length() == 0){
			return ValidationStatus.error("Value is required");
		}

		return ValidationStatus.ok();
	}

}
