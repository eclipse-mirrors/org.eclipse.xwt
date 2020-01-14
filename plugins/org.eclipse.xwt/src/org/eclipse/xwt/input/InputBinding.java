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
public class InputBinding {
	protected KeyGesture gesture;
	protected Object commandTarget;
	protected Object commandParameter;
	protected ICommand command;

	public Object getCommandTarget() {
		return commandTarget;
	}

	public void setCommandTarget(Object commandTarget) {
		this.commandTarget = commandTarget;
	}

	public Object getCommandParameter() {
		return commandParameter;
	}

	public void setCommandParameter(Object commandParameter) {
		this.commandParameter = commandParameter;
	}

	public ICommand getCommand() {
		return command;
	}

	public void setCommand(ICommand command) {
		this.command = command;
	}

	public KeyGesture getGesture() {
		return gesture;
	}

	public void setGesture(KeyGesture gesture) {
		this.gesture = gesture;
	}
}
