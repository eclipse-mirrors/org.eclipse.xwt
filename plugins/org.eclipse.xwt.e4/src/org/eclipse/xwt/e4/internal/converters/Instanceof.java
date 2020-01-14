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
package org.eclipse.xwt.e4.internal.converters;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.xwt.validation.AbstractValidationRule;

public class Instanceof extends AbstractValidationRule {
	private Class<?> type;

	public Class<?> getType() {
		return type;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}

	private boolean convert(Object fromObject) {
		if (fromObject == null) {
			return false;
		}

		Class<?> objectType = null;

		if (fromObject instanceof Class<?>) {
			objectType = (Class<?>) fromObject;
		} else {
			objectType = fromObject.getClass();
		}

		return type == null ? false : type.isAssignableFrom(objectType);
	}

	@Override
	public IStatus validateBack(Object value) {
		return null;
	}

	@Override
	public IStatus validate(Object value) {
		return convert(value) ? Status.OK_STATUS : Status.CANCEL_STATUS;
	}

	@Override
	public Phase getPhase() {
		return Phase.AfterGet;
	}

	@Override
	public Direction getBindingMode() {
		return Direction.SourceToTarget;
	}
}
