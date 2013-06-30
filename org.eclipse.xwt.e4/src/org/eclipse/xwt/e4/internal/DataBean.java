/*******************************************************************************
 * Copyright (c) 2013 Eclipse XWT Project.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Erdal Karaca - initial API and implementation
 ******************************************************************************/
package org.eclipse.xwt.e4.internal;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DataBean {
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(
			this);

	private Object input;

	public DataBean() {
	}

	public DataBean(Object data) {
		input = data;
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		this.changeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		this.changeSupport.removePropertyChangeListener(propertyName, listener);
	}

	public Object getInput() {
		return input;
	}

	public void setInput(Object newInput) {
		Object oldInput = this.input;
		this.input = newInput;
		changeSupport.firePropertyChange("input", oldInput, newInput);
	}
}
