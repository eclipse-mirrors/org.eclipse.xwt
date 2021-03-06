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

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.ForwardedRequest;
import org.eclipse.xwt.tools.ui.designer.commands.DeleteCommand;
import org.eclipse.xwt.tools.ui.designer.commands.InsertCreateCommand;

public class MenuLayoutEditPolicy extends FlowLayoutEditPolicy {

	protected Command createMoveChildCommand(EditPart child, EditPart after) {
		return null;
	}

	protected EditPolicy createChildEditPolicy(EditPart child) {
		return new NewNonResizeEditPolicy(false);
	}/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.tools.ui.designer.policies.layout.RowLayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
	 */

	protected Command getCreateCommand(CreateRequest request) {
		return new InsertCreateCommand(getHost(), getInsertionReference(request), request);
	}

	protected boolean isHorizontal() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy#createAddCommand(org.eclipse.gef.EditPart, org.eclipse.gef.EditPart)
	 */
	protected Command createAddCommand(EditPart child, EditPart after) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getDeleteDependantCommand(org.eclipse.gef.Request)
	 */
	protected Command getDeleteDependantCommand(Request request) {
		EditPart sender = ((ForwardedRequest) request).getSender();
		List<EditPart> deleteObjects = Collections.singletonList(sender);
		if (deleteObjects == null || deleteObjects.isEmpty()) {
			return null;
		}
		return new DeleteCommand(deleteObjects);
	}

}
