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

import org.eclipse.xwt.IValidationRule;

/**
 * Abstract implementation of {@link IValidationRule}
 *
 * @author hceylan
 */
public abstract class AbstractValidationRule implements IValidationRule {

	/**
	 *
	 */
	public AbstractValidationRule() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xwt.IValueValidator#getBindingMode()
	 */
	public Direction getBindingMode() {
		return Direction.Both;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xwt.IValueValidator#getPhase()
	 */
	public Phase getPhase() {
		return Phase.AfterGet;
	}

}
