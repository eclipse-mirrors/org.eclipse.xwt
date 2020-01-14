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
package org.eclipse.xwt.tests.clrfactory;

import java.util.Map;

import org.eclipse.xwt.ICLRFactory;

/**
 * @author jliu
 */
public class CLRFadeFactory implements ICLRFactory {
	public static ICLRFactory INSTANCE = new CLRFadeFactory();
	
	public Object createCLR(String args, Map<String, Object> options) {
		return new CLRFade(this, args);
	}
}
