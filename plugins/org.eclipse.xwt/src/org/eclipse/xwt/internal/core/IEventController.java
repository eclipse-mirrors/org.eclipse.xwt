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
package org.eclipse.xwt.internal.core;

import java.lang.reflect.Method;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xwt.IEventInvoker;
import org.eclipse.xwt.metadata.IEvent;

public interface IEventController {

	boolean hasEvent(Object receiver, IEvent event);

	void addEvent(int eventType, String name, IEvent event,
			Widget control, Object receiver, Object arg, Method method);

	void addEvent(int eventType, String name, IEvent event,
			Widget control, Object arg, IEventInvoker eventInvoker);

	void setEvent(IEvent event, Widget control,
			Object receiver, Object arg, Method method);

	void setEvent(IEvent event, Widget control,
			Object arg, IEventInvoker eventInvoker);

	void handleEvent(Event e);
}