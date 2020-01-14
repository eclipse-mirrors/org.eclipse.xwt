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
package org.eclipse.xwt;

import org.eclipse.xwt.metadata.IProperty;

/**
 * This class manages the coordination between events' state
 * 
 * @author yyang
 */
public interface IEventGroup {
	String[] getEventNames();

	/**
	 * Fire the event to update other when an event occurs
	 * 
	 * @param object
	 * @param property
	 */
	void fireEvent(IObservableValueListener manager, IProperty property);

	/**
	 * Register the event
	 * 
	 * @param manager
	 * @param property
	 */
	void registerEvent(IObservableValueListener manager, IProperty property);
}
