/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.eclipse.e4.xwt.tests.snippet019;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Bean {
	/* package */PropertyChangeSupport changeSupport = new PropertyChangeSupport(
			this);
	private String text;
	private List<Bean> list;

	public Bean(String text) {
		this.text = text;
		list = new ArrayList<Bean>();
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}

	public String getText() {
		return text;
	}

	public void setText(String value) {
		changeSupport.firePropertyChange("text", this.text,
				this.text = value);
	}

	public List<Bean> getList() {
		if (list == null)
			return null;
		return new ArrayList<Bean>(list);
	}

	public void setList(List<Bean> list) {
		if (list != null)
			list = new ArrayList<Bean>(list);
		changeSupport.firePropertyChange("list", this.list,
				this.list = list);
	}

	public boolean hasListeners(String propertyName) {
		return changeSupport.hasListeners(propertyName);
	}
}