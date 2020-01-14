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
package org.eclipse.xwt.tools.ui.designer.databinding;

import org.eclipse.xwt.databinding.BindingMode;
import org.eclipse.xwt.internal.core.UpdateSourceTrigger;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public interface IBindingInfo {

	IObservable getTarget();

	Property getTargetProperty();

	IObservable getModel();

	Property getModelProperty();

	String getElementName();

	/**
	 * The URL of a IConverter,
	 */
	String getConverter();

	/**
	 * One of {@link BindingMode}, <code>TwoWay</code>, <code>OneWay</code>, <code>OneTime</code>;
	 */
	BindingMode getBindingMode();

	/**
	 * One of {@link UpdateSourceTrigger}, <code>Default</code>, <code>PropertyChanged</code>, <code>LostFocus</code>;
	 */
	UpdateSourceTrigger getTriggerMode();

}
