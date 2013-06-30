/*******************************************************************************
 * Copyright (c) 2013 Eclipse XWT Project.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Erdal Karaca - initial API and implementation
 ******************************************************************************/
package org.eclipse.xwt.e4.internal;

import org.eclipse.xwt.IValidationRule;
import org.eclipse.xwt.e4.E4XWTUI;

public class Case {
	private Class<? extends E4XWTUI> uiClass;
	private IValidationRule when;

	public Case(Switch container) {
		container.addCase(this);
	}

	public Class<? extends E4XWTUI> getUiClass() {
		return uiClass;
	}

	public void setUiClass(Class<? extends E4XWTUI> uiClass) {
		this.uiClass = uiClass;
	}

	public IValidationRule getWhen() {
		return when;
	}

	public void setWhen(IValidationRule when) {
		this.when = when;
	}
}
