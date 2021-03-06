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
 *     Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt;

import java.util.Map;

public interface ICLRFactory {
	/**
	 * This method is used to create a CLR instance to handle events.
	 * 
	 * @param args
	 *            null if the default CLRFactory comes from XWT.getCLRFactory()
	 *            or CLASS_FACTORY. Otherwise, it is the value x:ClassFactory
	 * @options contains structures used by XWT (ex : URL, DataContext). Keys of
	 *          this Map come from {@link IXWTLoader}.
	 * @return
	 */
	Object createCLR(String args, Map<String, Object> options);
}
