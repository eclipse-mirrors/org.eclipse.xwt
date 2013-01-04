/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.databinding;

public class Address extends BeanObject {
	private String city = "Paris";

	public void setCity(String city) {
		String oldValue = this.city;
		this.city = city;
		changeSupport.firePropertyChange("city", oldValue, city);
	}

	public String getCity() {
		return city;
	}
}
