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
package org.eclipse.xwt.javabean.metadata;

import org.eclipse.xwt.metadata.IEvent;

/**
 * @author jliu
 */
public class TypedEvent implements IEvent {

	private String name;
	private int eventType;

	/**
	 * SWT event type.
	 */
	public TypedEvent(String name, int eventType) {
		this.name = name;
		this.eventType = eventType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.core.metadata.IBehavior#getName()
	 */
	public String getName() {
		return name;
	}

	public int getEventType() {
		return eventType;
	}

	public void setName(String name) {
		this.name = name;
	}

}
