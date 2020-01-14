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
package org.eclipse.xwt.input;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class KeyGesture {
	protected String key;
	protected String displayString;
	protected ModifierKeys modifiers;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDisplayString() {
		return displayString;
	}

	public void setDisplayString(String displayString) {
		this.displayString = displayString;
	}

	public ModifierKeys getModifiers() {
		return modifiers;
	}

	public void setModifiers(ModifierKeys modifiers) {
		this.modifiers = modifiers;
	}
}
