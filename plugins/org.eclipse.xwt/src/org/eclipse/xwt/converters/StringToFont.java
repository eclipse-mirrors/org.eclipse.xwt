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
package org.eclipse.xwt.converters;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.swt.graphics.Font;
import org.eclipse.xwt.utils.ResourceManager;

/**
 * String to Font converter
 * 
 * @author yyang
 */
public class StringToFont implements IConverter {
	public static StringToFont instance = new StringToFont();

	public Object convert(Object fromObject) {
		return ResourceManager.resources.getFont((String) fromObject);
	}

	public Object getFromType() {
		return String.class;
	}

	public Object getToType() {
		return Font.class;
	}

}
