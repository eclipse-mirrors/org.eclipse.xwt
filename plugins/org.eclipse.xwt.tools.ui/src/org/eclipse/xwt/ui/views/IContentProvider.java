/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.ui.views;

import java.net.URL;

import org.eclipse.xwt.ILoadingContext;

public interface IContentProvider {
	/**
	 * 
	 * @return
	 */
	ILoadingContext getLoadingContext();

	/**
	 * Content URL
	 * 
	 * @return
	 */
	URL getContentURL();
}
