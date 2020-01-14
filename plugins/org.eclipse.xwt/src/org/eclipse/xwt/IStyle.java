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
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public interface IStyle {

	/**
	 * The element to apply the style. The argument is an instance created through XML. It can be a Widget, or others such as TableViewer.
	 * 
	 * @param target
	 */
	void applyStyle(Object target);
}
