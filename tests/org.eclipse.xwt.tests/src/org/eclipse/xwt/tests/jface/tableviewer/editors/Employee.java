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
package org.eclipse.xwt.tests.jface.tableviewer.editors;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Employee {
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(
			this);

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(propertyName, listener);
	}

	protected String name;
	protected int age;

	protected Sex sex;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		int oldValue = this.age;
		this.age = age;
		changeSupport.firePropertyChange("Age", oldValue, age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldValue = name;
		this.name = name;
		changeSupport.firePropertyChange("Name", oldValue, name);
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		Sex oldValue = this.sex;
		this.sex = sex;
		changeSupport.firePropertyChange("Name", oldValue, name);
	}
}
