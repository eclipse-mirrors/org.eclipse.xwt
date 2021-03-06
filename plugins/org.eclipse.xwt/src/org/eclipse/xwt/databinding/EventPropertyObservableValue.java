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
package org.eclipse.xwt.databinding;

import org.eclipse.xwt.IObservableValueListener;
import org.eclipse.xwt.internal.core.IEventController;
import org.eclipse.xwt.internal.utils.LoggerManager;
import org.eclipse.xwt.internal.utils.ObservableValueManager;
import org.eclipse.xwt.internal.utils.UserData;
import org.eclipse.xwt.javabean.metadata.properties.EventProperty;
import org.eclipse.xwt.metadata.IEvent;

public class EventPropertyObservableValue extends XWTObservableValue {
	private EventProperty property;
		
	public EventPropertyObservableValue(Object observed, EventProperty property) {
		super(Boolean.class, observed, property.getName());
		this.property = property;
		IEventController controller = UserData.findEventController(observed);
		if (controller == null) {
			controller = UserData.updateEventController(observed);
		}
		IEvent event = property.getEvent();

		IObservableValueListener manager = UserData.getObservableValueManager(observed);
		if (manager == null) {
			manager = new ObservableValueManager(observed);
			UserData.setObservableValueManager(observed, manager);
		}
		try {
			controller.setEvent(event, UserData.getWidget(observed), manager, property, IObservableValueListener.class.getDeclaredMethod("changeValueHandle", Object.class, org.eclipse.swt.widgets.Event.class));
			manager.registerValue(property, this);
		} catch (Exception e) {
			LoggerManager.log(e);
			return;
		}
	}

	@Override
	protected void doSetApprovedValue(Object value) {
		UserData.setLocalData(getObserved(), property.getName(), value);		
	}

	protected Object doGetValue() {
		return UserData.getLocalData(getObserved(), property.getName());
	}
}
