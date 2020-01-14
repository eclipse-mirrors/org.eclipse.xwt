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
package org.eclipse.xwt.tools.ui.designer.editor.model;

/**
 * @author Jin Liu(jin.liu@soyatec.com)
 */
public class Synchronizer {
	public static enum EventType {
		Free, LoadingEvent, SourceEvent, ModelEvent
	}

	private EventType eventType = EventType.Free;

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public EventType getEventType() {
		return eventType;
	}

	public boolean isFree() {
		return eventType == null || eventType == EventType.Free;
	}

	public void setFree() {
		setEventType(EventType.Free);
	}
}
