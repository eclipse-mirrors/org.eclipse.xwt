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
package org.eclipse.xwt.internal.core;

/**
 * <p>
 * Default
 * </p>
 * <p>
 * The default UpdateSourceTrigger value of the binding target property. The
 * default value for most dependency properties is PropertyChanged, while the
 * Text property has a default value of LostFocus.
 * </p>
 * <p>
 * A programmatic way to determine the default UpdateSourceTrigger value of a
 * dependency property is to get the property metadata of the property using
 * GetMetadata and then check the value of the DefaultUpdateSourceTrigger
 * property.
 * </p>
 * <p/>
 * <p>
 * PropertyChanged
 * </p>
 * <p>
 * Updates the binding source immediately whenever the binding target property
 * changes.
 * </p>
 * <p/>
 * <p>
 * LostFocus
 * </p>
 * <p>
 * Updates the binding source whenever the binding target element loses focus.
 * </p>
 * 
 * @author yyang
 * 
 */
public enum UpdateSourceTrigger {
	Default, PropertyChanged, LostFocus;
}
