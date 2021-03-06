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
package org.eclipse.xwt.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.xwt.IValidationRule;

public class InverseValidationRule implements IValidationRule {

	private final IValidationRule delegate;

	public InverseValidationRule(IValidationRule delegate) {
		super();

		this.delegate = delegate;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xwt.IValueValidator#getBindingMode()
	 */
	public Direction getBindingMode() {
		switch (delegate.getBindingMode()) {
		case SourceToTarget:
			return Direction.TargetToSource;
		case TargetToSource:
			return Direction.SourceToTarget;
		case Both:
		default:
			return Direction.Both;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xwt.IValueValidator#getPhase()
	 */
	public Phase getPhase() {
		return delegate.getPhase();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xwt.IValueValidator#validateBack(java.lang.Object)
	 */
	public IStatus validateBack(Object value) {
		return delegate.validate(value);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.databinding.validation.IValidator#validate(java.lang.Object)
	 */
	public IStatus validate(Object value) {
		return delegate.validateBack(value);
	}

}
