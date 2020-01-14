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
package org.eclipse.xwt.internal.databinding.menuitem;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.swt.widgets.MenuItem;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class MenuItemSelectionObservableValue extends AbstractMenuItemObservableValue {

	public MenuItemSelectionObservableValue(MenuItem menuItem) {
		super(menuItem);
	}

	public MenuItemSelectionObservableValue(Realm realm, MenuItem menuItem) {
		super(realm, menuItem);
	}

	@Override
	protected Object doGetValue() {
		return getMenuItem().getSelection();
	}

	@Override
	public Object getValueType() {
		return Boolean.class;
	}

	@Override
	protected void doSetValue(Object value) {
		getMenuItem().setSelection((Boolean) value);
	}
}
