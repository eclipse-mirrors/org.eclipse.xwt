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
package org.eclipse.xwt.tests.clrfactory;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;

/**
 * @author jliu
 */
public class CLRFade {
	private CLRFadeFactory factory;

	private String args;

	public String getArgs() {
		return args;
	}

	public void setArgs(String args) {
		this.args = args;
	}

	public CLRFade(CLRFadeFactory factory, String args) {
		this.args = args;
		this.factory = factory;
	}
	
	public void select(Button sender, Event event) {
		if (args == null) {
			sender.setText("");			
		}
		else {
			sender.setText(args);			
		}
		sender.setData("CLR", this);
	}

	public CLRFadeFactory getFactory() {
		return factory;
	}

	public void setFactory(CLRFadeFactory factory) {
		this.factory = factory;
	}
}
