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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.xwt.tools.ui.designer.commands.DeleteCommand;
import org.eclipse.xwt.tools.ui.designer.core.parts.VisualEditPart;
import org.eclipse.xwt.tools.ui.designer.core.policies.DefaultComponentEditPolicy;
import org.eclipse.xwt.tools.ui.xaml.XamlNode;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class ComponentEditPolicy extends DefaultComponentEditPolicy {

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.ComponentEditPolicy#getDeleteCommand(org.eclipse.gef.requests.GroupRequest)
	 */
	protected Command getDeleteCommand(GroupRequest request) {
		List editParts = request.getEditParts();
		if (!editParts.isEmpty()) {
			List<XamlNode> deleteItems = new ArrayList<XamlNode>();
			for (Iterator iterator = editParts.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				if (object instanceof VisualEditPart) {
					VisualEditPart part = (VisualEditPart) object;
					deleteItems.add((XamlNode) part.getCastModel());
				}
			}
			if (!deleteItems.isEmpty()) {
				return new DeleteCommand(deleteItems);
			}
		}
		return super.getDeleteCommand(request);
	}
}
