/*******************************************************************************
 * Copyright (c) 2006, 2013 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *     Erdal Karaca - refactored to use base class
 *******************************************************************************/
package org.eclipse.xwt.snippets;

import java.net.URL;
import java.util.logging.Logger;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;

public class XWTSnippet {
	protected Logger log = Logger.getLogger(this.getClass().getName());
	private Object root;

	protected URL doGetUrl() {
		Class<?> clazz = this.getClass();
		return clazz.getResource(clazz.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
	}

	public Object load() {
		if (root != null) {
			throw new IllegalStateException("This snippet has already been loaded.");
		}

		URL url = doGetUrl();

		try {
			root = XWT.load(url);
		} catch (Exception e) {
			log.severe(e.getMessage());
		}

		return root;
	}
	
	public void open() {
		URL url = doGetUrl();

		try {
			XWT.open(url);
		} catch (Exception e) {
			log.severe(e.getMessage());
		}
	}

	public Object getRoot() {
		return root;
	}
}
