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
package org.eclipse.xwt.tests.wizard;

public class Person extends BeanObject {
	private String name = "toto";
	private String email = "toto@soyatec.com";
	private int age = 30;
	private boolean maried = false;
	private Address address;

	public Person() {
		address = new Address();
	}
	
	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		changeSupport.firePropertyChange("name", oldValue, name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setEmail(String email) {
		String oldValue = this.email;
		this.email = email;
		changeSupport.firePropertyChange("email", oldValue, email);
	}
	
	
	
	public String getEmail() {
		return email;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		int oldValue = this.age;
		this.age = age;
		changeSupport.firePropertyChange("age", oldValue, age);
	}
	
	public void setMaried(boolean maried) {
		boolean oldValue = this.maried;
		this.maried = maried;
		changeSupport.firePropertyChange("maried", oldValue, maried);
	}

	public boolean isMaried() {
		return maried;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		Address oldValue = this.address;
		this.address = address;
		changeSupport.firePropertyChange("address", oldValue, address);
	}

}
