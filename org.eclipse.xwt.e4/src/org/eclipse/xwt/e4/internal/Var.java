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

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.contexts.RunAndTrack;
import org.eclipse.xwt.e4.E4XWTUI;

public class Var {
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(
			this);

	private IEclipseContext context;
	private String varName;
	private Object value;

	public Var(Object parent) {
		context = E4XWTUI.findData(IEclipseContext.class, parent);
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(final String name) {
		this.varName = name;

		final Boolean[] track = new Boolean[1];
		track[0] = true;
		context.runAndTrack(new RunAndTrack() {
			@Override
			public boolean changed(IEclipseContext context) {
				if (!track[0] || Var.this.context == null) {
					return false;
				}

				Object newValue = context.get(name);
				Object oldValue = value;
				value = newValue;
				changeSupport.firePropertyChange("value", oldValue, newValue);
				return true;
			}
		});
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		this.changeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		this.changeSupport.removePropertyChangeListener(propertyName, listener);
	}
}
