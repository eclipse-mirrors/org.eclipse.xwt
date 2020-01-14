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
package org.eclipse.xwt.tools.ui.designer.commands;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.commands.Command;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class BindingReconnectCommand extends Command {

	private ConnectionEditPart connection;
	private NodeEditPart source;
	private NodeEditPart target;

	public BindingReconnectCommand(ConnectionEditPart connection) {
		this.connection = connection;
		setLabel("Reconnect Source");
	}

	public boolean canExecute() {
		return connection != null && (source != null || target != null);
	}

	public void execute() {
		// TODO:
	}

	public void setTarget(NodeEditPart target) {
		this.target = target;
	}

	public NodeEditPart getTarget() {
		return target;
	}

	public void setSource(NodeEditPart source) {
		this.source = source;
	}

	public NodeEditPart getSource() {
		return source;
	}
}
