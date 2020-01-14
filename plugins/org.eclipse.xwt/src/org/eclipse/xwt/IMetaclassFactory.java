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

import org.eclipse.xwt.metadata.IMetaclass;

/**
 * Metaclass factory provides a customizable Metaclass creation mechanism.
 * 
 * @author yyang
 * 
 */
public interface IMetaclassFactory {
	boolean isFactoryOf(Class<?> type);

	IMetaclass create(Class<?> type, IMetaclass superMetaclass, IXWTLoader xwtLoader);
}
