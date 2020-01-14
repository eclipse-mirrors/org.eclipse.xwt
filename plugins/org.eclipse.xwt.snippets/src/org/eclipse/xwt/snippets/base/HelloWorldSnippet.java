/*******************************************************************************
 * Copyright (c) 2006, 2013 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *     Erdal Karaca - refactored to use base class
 *******************************************************************************/
package org.eclipse.xwt.snippets.base;

import org.eclipse.xwt.snippets.XWTSnippet;

public class HelloWorldSnippet extends XWTSnippet {
	public static void main(String[] args) {
		new HelloWorldSnippet().open();
	}
}
