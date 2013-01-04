/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.controls.button.command;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.xwt.input.RoutedCommand;

public class MessageCommand extends RoutedCommand {

	public MessageCommand() {
	}

	@Override
	public void execute(Object parameter) {
		MessageDialog.openInformation(null, "Message", "Command message");
	}
}
