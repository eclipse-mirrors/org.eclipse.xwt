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
package org.eclipse.xwt.tools.ui.designer.policies;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.xwt.tools.ui.designer.commands.BindingCreateCommand;
import org.eclipse.xwt.tools.ui.designer.commands.BindingReconnectCommand;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class GraphicalNodeEditPolicyImpl extends org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
	 */
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		BindingCreateCommand startCommand = (BindingCreateCommand) request.getStartCommand();
		EditPart source = request.getSourceEditPart();
		EditPart target = request.getTargetEditPart();
		if (target == null || source == null || source == target || target == source.getParent()) {
			return null;
		}
		return startCommand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCreateCommand(org.eclipse.gef.requests.CreateConnectionRequest)
	 */
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		BindingCreateCommand command = new BindingCreateCommand(request);
		request.setStartCommand(command);
		return command;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
	 */
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		NodeEditPart source = (NodeEditPart) getHost();
		ConnectionEditPart connectionEditPart = request.getConnectionEditPart();
		BindingReconnectCommand command = new BindingReconnectCommand(connectionEditPart);
		command.setSource(source);
		return command;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
	 */
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		NodeEditPart target = (NodeEditPart) request.getTarget();
		ConnectionEditPart connectionEditPart = request.getConnectionEditPart();
		BindingReconnectCommand command = new BindingReconnectCommand(connectionEditPart);
		command.setTarget(target);
		return command;
	}

}
