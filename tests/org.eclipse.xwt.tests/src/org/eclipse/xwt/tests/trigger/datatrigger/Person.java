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
package org.eclipse.xwt.tests.trigger.datatrigger;

public class Person {
	private String name = "toto";
	private int age = 10;

	private boolean maried = true;

	private Country nationality = Country.FR;
	private Address address;

	public Country getNationality() {
		return nationality;
	}

	public boolean isMaried() {
		return maried;
	}

	public void setMaried(boolean maried) {
		this.maried = maried;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person() {
		address = new Address();
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
