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
package org.eclipse.xwt.tests.clrfactory;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;

/**
 * @author jliu
 */
public class CLR {
	private CLRFactory factory;

	private String args;

	public String getArgs() {
		return args;
	}

	public void setArgs(String args) {
		this.args = args;
	}

	public CLR(CLRFactory factory, String args) {
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

	public CLRFactory getFactory() {
		return factory;
	}

	public void setFactory(CLRFactory factory) {
		this.factory = factory;
	}
}
