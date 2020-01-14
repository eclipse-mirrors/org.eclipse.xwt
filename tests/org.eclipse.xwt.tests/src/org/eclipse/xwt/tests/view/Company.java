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
package org.eclipse.xwt.tests.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Company {
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
	protected Person manager = new Person();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldValue = name;
		this.name = name;
		changeSupport.firePropertyChange("name", oldValue, name);
	}

	public Person getManager() {
		return manager;
	}

	public void setManager(Person manager) {
		Person oldValue = this.manager;
		this.manager = manager;
		changeSupport.firePropertyChange("manager", oldValue, manager);
	}
}
