/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.databinding;

import org.eclipse.xwt.IValueConverter;

public class MyConverter implements IValueConverter {

	public Object convertBack(Object value) {
		throw new UnsupportedOperationException();
	}

	public Object convert(Object fromObject) {
		return "-> " + fromObject;
	}

	public Object getFromType() {
		return String.class;
	}

	public Object getToType() {
		return String.class;
	}

}
