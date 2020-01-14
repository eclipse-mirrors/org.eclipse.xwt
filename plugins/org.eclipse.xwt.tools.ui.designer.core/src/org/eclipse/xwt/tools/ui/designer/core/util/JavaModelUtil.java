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
package org.eclipse.xwt.tools.ui.designer.core.util;

/**
 * 
 * @author yyang <yves.yang@soyatec.com>
 */
public class JavaModelUtil {

	public static boolean isKindOf(Class<?> type, String typeName) {
		String name = type.getName();
		name = name.replace('$', '.');
		if (name.equals(typeName)) {
			return true;
		}
		Class<?> superType = type.getSuperclass();
		if (superType != null) {
			if (isKindOf(superType, typeName)) {
				return true;
			}
		}
		for (Class<?> interfaceType : type.getInterfaces()) {
			if (isKindOf(interfaceType, typeName)) {
				return true;
			}
		}
		return false;
	}
}
