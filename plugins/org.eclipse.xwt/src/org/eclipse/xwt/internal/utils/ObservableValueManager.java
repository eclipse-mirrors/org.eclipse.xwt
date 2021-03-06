/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.internal.utils;

import java.util.HashMap;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xwt.IEventGroup;
import org.eclipse.xwt.IObservableValueListener;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.javabean.metadata.properties.EventProperty;
import org.eclipse.xwt.metadata.IMetaclass;
import org.eclipse.xwt.metadata.IProperty;
import org.eclipse.xwt.metadata.ModelUtils;

public class ObservableValueManager implements IObservableValueListener {
	protected HashMap<String, IObservableValue> map;
	protected Object host;
	
	public ObservableValueManager(Object host) {
		this.host = host;
	}
	
	public Object getHost() {
		return host;
	}
	
	public void changeValueHandle(Object object, Event event){
		// TODO the cast is not clean. 
		EventProperty property = (EventProperty) object;
		IObservableValue value = map.get(property.getName());
		if (value != null) {
			Boolean oldValue = (Boolean) value.getValue();
			if (oldValue == null) {
				oldValue = false;
			}
			value.setValue(!oldValue);
		}
		
		IMetaclass metaclass = XWT.getMetaclass(host);
		
		// TODO this conversion should be simplied
		String eventName = ModelUtils.normalizePropertyName(property.getEvent().getName());
		IEventGroup eventGroup = metaclass.getEventGroup(eventName);
		if (eventGroup != null) {
			eventGroup.fireEvent(this, property);
		}
	}
	
	public void registerValue(IProperty property, IObservableValue observableValue) {
		if (map == null) {
			map = new HashMap<String, IObservableValue>();
		}
		map.put(property.getName(), observableValue);
		
		IMetaclass metaclass = XWT.getMetaclass(host);
		// TODO it is not clean. 
		EventProperty eventProperty  = (EventProperty) property;
		
		// TODO this conversion should be simplied
		String eventName = ModelUtils.normalizePropertyName(eventProperty.getEvent().getName());		
		IEventGroup eventGroup = metaclass.getEventGroup(eventName);
		if (eventGroup != null) {
			eventGroup.registerEvent(this, property);
		}
	}
	
	public IObservableValue getValue(IProperty property) {
		if (map == null) {
			return null;
		}
		return map.get(property.getName());
	}
}
