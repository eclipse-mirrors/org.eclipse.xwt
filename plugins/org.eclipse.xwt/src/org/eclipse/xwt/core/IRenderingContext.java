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
package org.eclipse.xwt.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.xwt.ILoadingContext;

/**
 * @author yyang
 * @version 1.0
 */
public interface IRenderingContext {
	public String getNamespace();

	public URL getResourcePath();

	public InputStream openStream(String path) throws IOException;

	public String getEncoding();

	public Object getProperty(String name);

	public void setProperty(String name, Object value);

	public ILoadingContext getLoadingContext();
}
