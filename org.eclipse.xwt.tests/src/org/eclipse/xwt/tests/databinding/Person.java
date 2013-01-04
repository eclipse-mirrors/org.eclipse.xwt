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

public class Person extends BeanObject {
	private String name = "toto";
	private int age = 10;
	private boolean maried = true;
	private Country nationality = Country.FR;
	private Address address;

	public void setMaried(boolean maried) {
		boolean oldValue = this.maried;
		this.maried = maried;
		changeSupport.firePropertyChange("maried", oldValue, maried);
	}

	public Country getNationality() {
		return nationality;
	}

	public boolean isMaried() {
		return maried;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		int oldValue = this.age;
		this.age = age;
		changeSupport.firePropertyChange("age", oldValue, age);
	}

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		Address oldValue = this.address;
		this.address = address;
		changeSupport.firePropertyChange("address", oldValue, address);
	}

}
