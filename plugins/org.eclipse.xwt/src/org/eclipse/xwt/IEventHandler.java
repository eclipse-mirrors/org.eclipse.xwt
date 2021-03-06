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

/**
 * This class provides an open solution to manage the events. By default,
 * XWT uses Java reflection to find the method to handle an event. If the class
 * specified by <code>x:Class</code> implements this interface, this class can provide
 * the IEventInvoker for each event.
 * 
 * @author yyang
 */
public interface IEventHandler {
	IEventInvoker getEventInvoker(String name, Class<?> elementType,
			Class<?> eventType);
}
