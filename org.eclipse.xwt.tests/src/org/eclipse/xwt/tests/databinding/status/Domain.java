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

import org.eclipse.xwt.tests.BaseBean;

public class Domain extends BaseBean {

	private String valueOne = "1";
	private String valueTwo = "2";

	public String getValueOne() {
		return valueOne;
	}

	public void setValueOne(String valueOne) {
		String oldValue = this.valueOne;
		this.valueOne = valueOne;
		changeSupport.firePropertyChange("valueOne", oldValue, this.valueOne);
	}

	public String getValueTwo() {
		return valueTwo;
	}

	public void setValueTwo(String valueTwo) {
		String oldValue = this.valueTwo;
		this.valueTwo = valueTwo;
		changeSupport.firePropertyChange("valueTwo", oldValue, this.valueTwo);
	}
}
