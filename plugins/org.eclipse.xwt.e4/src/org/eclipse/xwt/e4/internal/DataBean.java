/*******************************************************************************
 * Copyright (c) 2013 Eclipse XWT Project.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
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
