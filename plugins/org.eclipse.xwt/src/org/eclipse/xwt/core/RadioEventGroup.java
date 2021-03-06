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
package org.eclipse.xwt.core;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.xwt.IEventConstants;
import org.eclipse.xwt.IObservableValueListener;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.internal.core.IEventController;
import org.eclipse.xwt.internal.utils.LoggerManager;
import org.eclipse.xwt.internal.utils.UserData;
import org.eclipse.xwt.javabean.metadata.properties.EventProperty;
import org.eclipse.xwt.metadata.IEvent;
import org.eclipse.xwt.metadata.IMetaclass;
import org.eclipse.xwt.metadata.IProperty;

public class RadioEventGroup extends AbstractEventGroup {

	public RadioEventGroup(String... names) {
		super(names);
	}

	public void fireEvent(IObservableValueListener manager, IProperty property) {
		Object host = manager.getHost();
		IMetaclass metaclass = XWT.getMetaclass(host); 

		EventProperty reaisedEventProperty = (EventProperty) property;
		String raisedName = reaisedEventProperty.getEvent().getName();
		for (String name : getEventNames()) {
			if (name.equalsIgnoreCase(raisedName)) {
				continue;
			}
			String eventPropertyName = IEventConstants.getEventPropertyName(name);
			IProperty eventProperty = metaclass.findProperty(eventPropertyName);

			IObservableValue value = manager.getValue(eventProperty);
			if (value != null) {
				value.setValue(false);
			}
		}
	}

	public void registerEvent(IObservableValueListener manager,
			IProperty property) {
		Object host = manager.getHost();
		IEventController controller = UserData.findEventController(host);
		if (controller == null) {
			controller = UserData.updateEventController(host);
		}
		IMetaclass metaclass = XWT.getMetaclass(host); 

		EventProperty reaisedEventProperty = (EventProperty) property;
		String raisedName = reaisedEventProperty.getEvent().getName();
		for (String name : getEventNames()) {
			if (name.equalsIgnoreCase(raisedName)) {
				continue;
			}
			String eventPropertyName = IEventConstants.getEventPropertyName(name);
			String eventName = IEventConstants.getEventName(name);
			IEvent event = metaclass.findEvent(eventName);
			IProperty eventProperty = metaclass.findProperty(eventPropertyName);
			
			try {
				controller.setEvent(event, UserData.getWidget(host), manager, eventProperty, IObservableValueListener.class.getDeclaredMethod("changeValueHandle", Object.class, org.eclipse.swt.widgets.Event.class));
			} catch (Exception e) {
				LoggerManager.log(e);
				return;
			}
		}
	}
}
