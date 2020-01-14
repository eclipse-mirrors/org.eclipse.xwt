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
package org.eclipse.xwt.pde.ui;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.xwt.DefaultLoadingContext;
import org.eclipse.xwt.XWT;

/**
 * Abstract application class for RCP
 * 
 * @author yyang
 *
 */
public abstract class RCPApplication implements IApplication {

	final public Object start(IApplicationContext context) throws Exception {
		Platform.endSplash();
		XWT.setLoadingContext(new DefaultLoadingContext(this.getClass()
				.getClassLoader()));
		initialize();
		try {
			URL input = getInputURL();
			XWT.open(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.currentThread().join();
		return IApplication.EXIT_OK;
	}

	abstract protected URL getInputURL();

	protected void initialize() {
	}

	public void stop() {
	}
}
