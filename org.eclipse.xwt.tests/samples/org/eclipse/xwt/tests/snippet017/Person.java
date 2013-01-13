/*******************************************************************************
 * Copyright (c) 2006, 2010 The Pampered Chef, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Coconut Palm Software, Inc. - Initial API and implementation
 *     Matthew Hall - bugs 260329, 260337
 *     Yves YANG - port to XWT
 ******************************************************************************/
package org.eclipse.xwt.tests.snippet017;


public class Person extends AbstractModelObject {
	// A property...
	String name = "Donald Duck";
	Person mother;
	Person father;

	public Person(String name, Person mother, Person father) {
		this.name = name;
		this.mother = mother;
		this.father = father;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		firePropertyChange("name", oldValue, name);
	}

	public Person getMother() {
		return mother;
	}

	public void setMother(Person mother) {
		firePropertyChange("mother", this.mother, this.mother = mother);
	}

	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		firePropertyChange("father", this.father, this.father = father);
	}

	public String toString() {
		return name;
	}
}