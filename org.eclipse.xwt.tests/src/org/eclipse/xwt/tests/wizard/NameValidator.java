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

import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.xwt.validation.AbstractValidationRule;

public class NameValidator extends AbstractValidationRule {

	public NameValidator() {
		super();
	}

	@Override
	public Phase getPhase() {
		return Phase.BeforeSet;
	}

	@Override
	public Direction getBindingMode() {
		return Direction.Both;
	}

	public IStatus validate(Object value) {
		
		if (value.equals(0) || value == null || value.toString().length() == 0	|| value.equals("") ) {
		    return	ValidationStatus.error("This field is mandatory. It must be specified");
			} 
		
			if (value.toString().charAt(0) == '.') {
				return	ValidationStatus.error("This field must not begin with a '.'");
			
			}
						
			for (int i = 0; i < value.toString().length(); i++) {
				char c = value.toString().charAt(i);
				if ((c < 'A' || 'Z' < c) && (c < 'a' || 'z' < c) && (c < '0' || '9' < c) && c != '_' && c != '-') {
					if (i == 0 || i == value.toString().length() - 1 || c != '.') {
						return ValidationStatus.error("This field cannot contain ''" + c + "''");
					}
				}
			}
	
			
			
			 ValidationStatus.info("Define data fields of a new person");
				
		return ValidationStatus.ok();

	}

	public IStatus validateBack(Object value) {
		return validate(value);
	}

}
