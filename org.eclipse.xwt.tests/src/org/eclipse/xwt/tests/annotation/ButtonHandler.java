/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.annotation;

import org.eclipse.swt.widgets.Button;
import org.eclipse.xwt.annotation.UI;

/**
 * 
 * @author yyang
 */
public class ButtonHandler {
	public static ButtonHandler instance;

	@UI 
	private Button myButton;

	public ButtonHandler() {
		if (instance == null) {
			instance = this;
		}
		else {
			throw new IllegalStateException();
		}
	}
}
