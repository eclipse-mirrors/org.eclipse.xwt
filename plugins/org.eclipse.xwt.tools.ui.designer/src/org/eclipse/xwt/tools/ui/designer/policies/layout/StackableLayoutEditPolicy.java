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
package org.eclipse.xwt.tools.ui.designer.policies.layout;

import org.eclipse.xwt.metadata.IMetaclass;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.swt.widgets.Item;
import org.eclipse.xwt.tools.ui.designer.commands.AttachedPropertyCreateCommand;
import org.eclipse.xwt.tools.ui.designer.commands.DefaultCreateCommand;
import org.eclipse.xwt.tools.ui.designer.editor.palette.CreateReqHelper;
import org.eclipse.xwt.tools.ui.designer.parts.StackableEditPart;
import org.eclipse.xwt.tools.ui.designer.policies.NewNonResizeEditPolicy;
import org.eclipse.xwt.tools.ui.designer.utils.XWTUtility;
import org.eclipse.xwt.tools.ui.xaml.XamlNode;

/**
 * @author jin.liu (jin.liu@soyatec.com)
 * 
 */
public class StackableLayoutEditPolicy extends LayoutEditPolicy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editpolicies.LayoutEditPolicy#createChildEditPolicy(org
	 * .eclipse.gef.EditPart)
	 */
	protected EditPolicy createChildEditPolicy(EditPart child) {
		return new NewNonResizeEditPolicy(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse
	 * .gef.requests.CreateRequest)
	 */
	protected Command getCreateCommand(CreateRequest request) {
		StackableEditPart host = (StackableEditPart) getHost();
		CreateReqHelper helper = new CreateReqHelper(request);
		XamlNode newObject = helper.getNewObject();
		if (newObject == null) {
			return null;
		}
		IMetaclass metaclass = XWTUtility.getMetaclass(newObject);
		if (metaclass == null) {
			return null;
		}
		if (Item.class.isAssignableFrom(metaclass.getType())) {
			return new DefaultCreateCommand(host, request);
		} else {
			return new AttachedPropertyCreateCommand(host.getPopItemPart(),
					request, "control");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editpolicies.LayoutEditPolicy#getMoveChildrenCommand(
	 * org.eclipse.gef.Request)
	 */
	protected Command getMoveChildrenCommand(Request request) {
		return null;
	}

}
