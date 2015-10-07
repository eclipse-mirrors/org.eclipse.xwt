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

public class Company extends BeanObject {
	private String name = "Soyatec";
	private Person manager = new Person();

	public Person getManager() {
		return manager;
	}

	public void setManager(Person manager) {
		Person oldValue = this.manager;
		this.manager = manager;
		changeSupport.firePropertyChange("manager", oldValue, manager);
	}

	public Company() {
		manager.setName("Julien");
	}

	public void setName(String value) {
		String oldValue = this.name;
		this.name = value;
		changeSupport.firePropertyChange("name", oldValue, value);
	}

	public String getName() {
		return name;
	}
}
