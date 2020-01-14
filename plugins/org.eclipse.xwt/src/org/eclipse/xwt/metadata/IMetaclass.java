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
package org.eclipse.xwt.metadata;

import org.eclipse.xwt.IEventGroup;

/**
 * UI metaclass
 * 
 * @author yyang
 */
public interface IMetaclass {
	public String getName();

	public IProperty[] getProperties();

	public IMetaclass getSuperClass();

	public IEvent[] getEvents();

	public IProperty findProperty(String name);

	public void removeProperty(String name);

	public IProperty findDefaultProperty();

	public IEvent findEvent(String name);

	public Object newInstance(Object[] parameters);

	public boolean isAbstract();

	public boolean isInstance(Object object);

	public boolean isSubclassOf(IMetaclass metaclass);

	public boolean isSuperclassOf(IMetaclass metaclass);

	public boolean isAssignableFrom(IMetaclass metaclass);

	public Class<?> getType();

	public IProperty addProperty(IProperty property);

	public Class<?> getDataContextType();
	
	public void addEventGroup(IEventGroup eventGroup);
	
	public IEventGroup getEventGroup(String event);
	
	public void addInitializer(IObjectInitializer initializer);
	
	public void removeInitializer(IObjectInitializer initializer);
	
	public IObjectInitializer[] getInitializers();
	
	public void initialize(Object instance);	
}