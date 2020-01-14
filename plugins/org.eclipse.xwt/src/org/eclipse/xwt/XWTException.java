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

public class XWTException extends RuntimeException {
	/**
	 * Copyright (c) 2006, 2010 Soyatec
	 */
	private static final long serialVersionUID = 7568262060419780948L;

	public XWTException(String message, Throwable cause) {
		super(message, cause);
	}

	public XWTException(String message) {
		super(message);
	}

	public XWTException(Throwable cause) {
		super(cause);
	}

	public XWTException() {
	}
}
