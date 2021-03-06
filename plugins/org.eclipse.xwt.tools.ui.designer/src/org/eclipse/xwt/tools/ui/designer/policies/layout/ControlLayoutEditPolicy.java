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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.xwt.tools.ui.designer.commands.AbstractCreateCommand;
import org.eclipse.xwt.tools.ui.designer.policies.feedback.FeedbackHelper;
import org.eclipse.xwt.tools.ui.designer.policies.feedback.FeedbackManager;
import org.eclipse.xwt.tools.ui.xaml.XamlNode;

/**
 * This class is used to create a LAYOUT_ROLE for each controls of SWT, so we can easily create or add some properties.
 * 
 * @author jliu (jin.liu@soyatec.com)
 */
public class ControlLayoutEditPolicy extends LayoutEditPolicy {
	private FeedbackManager fbm = new FeedbackManager(this);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#createChildEditPolicy(org.eclipse.gef.EditPart)
	 */
	protected EditPolicy createChildEditPolicy(EditPart child) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#showLayoutTargetFeedback(org.eclipse.gef.Request)
	 */
	protected void showLayoutTargetFeedback(Request request) {
		if (request instanceof CreateRequest) {
			FeedbackHelper.showFillFeedback(fbm, (CreateRequest) request);
		} else {
			super.showLayoutTargetFeedback(request);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#eraseLayoutTargetFeedback(org.eclipse.gef.Request)
	 */
	protected void eraseLayoutTargetFeedback(Request request) {
		fbm.eraseFeedback(request);
		super.eraseLayoutTargetFeedback(request);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
	 */
	protected Command getCreateCommand(CreateRequest request) {
		return new AbstractCreateCommand(getHost(), request) {
			protected void preExecute(XamlNode newNode, CreateRequest createRequest) {
				// Do nothing.
			}
		};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getMoveChildrenCommand(org.eclipse.gef.Request)
	 */
	protected Command getMoveChildrenCommand(Request request) {
		return null;
	}

}
