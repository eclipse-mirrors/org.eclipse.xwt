/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.       *
 * All rights reserved. This program and the accompanying materials            *
 * are made available under the terms of the Eclipse Public License v1.0       *
 * which accompanies this distribution, and is available at                    *
 * http://www.eclipse.org/legal/epl-v10.html                                   *
 *                                                                             *  
 * Contributors:                                                               *        
 *     Soyatec - initial API and implementation                                *
 *******************************************************************************/
package org.eclipse.xwt.tests.databinding.dataprovider.custom;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class DynamicObject {
	protected Map<String, Object> properties = new HashMap<String, Object>();

	public Object getProperty(String name) {
		return getProperty(name, null);
	}

	public Object getProperty(String name, Object defaultValue) {
		Object value = properties.get(name);
		if (value == null) {
			value = defaultValue;
		}
		return value;
	}

	public void setProperty(String name, Object value) {
		properties.put(name, value);
	}
}
