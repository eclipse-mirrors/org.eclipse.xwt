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
package org.eclipse.xwt.tests.wizard;

public class Address extends BeanObject {
	private String street = "Place de France";
	private String city = "Paris";
	
	public Address() {
     
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		String oldValue = this.street;
		this.street = street;
		changeSupport.firePropertyChange("street", oldValue, street);
	}
	
	public void setCity(String city) {
		String oldValue = this.city;
		this.city = city;
		changeSupport.firePropertyChange("city", oldValue, city);
	}

	public String getCity() {
		return city;
	}

}
