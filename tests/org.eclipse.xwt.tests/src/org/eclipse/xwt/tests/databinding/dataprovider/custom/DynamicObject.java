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
package org.eclipse.xwt.tests.databinding.dataprovider.custom;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class DynamicObject {
	protected Map<String, Object> properties = new HashMap<>();

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
