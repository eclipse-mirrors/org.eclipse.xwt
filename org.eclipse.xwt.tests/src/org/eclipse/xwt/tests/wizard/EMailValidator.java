/******************************************************************************* 
 * Copyright (c) 2006, 2015 Soyatec (http://www.soyatec.com) and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Soyatec - initial API and implementation 
 *******************************************************************************/ 
package org.eclipse.xwt.tests.wizard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.xwt.validation.AbstractValidationRule;

public class EMailValidator extends AbstractValidationRule {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private Pattern pattern;
	private Matcher matcher;

	public EMailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	@Override
	public Phase getPhase() {
		return Phase.BeforeSet;
	}

	@Override
	public Direction getBindingMode() {
		return Direction.TargetToSource;
	}

	public IStatus validate(Object value) {
		if (value == null || value.equals("")) {
			return ValidationStatus.error("Email can not be empty.");
		}
		matcher = pattern.matcher(value.toString());
		if (matcher.matches()) {
			return ValidationStatus.ok();
		}
		return ValidationStatus.error("'" + value.toString()
				+ "' is not a validate email.");
	}

	public IStatus validateBack(Object value) {
		return validate(value);
	}

}
