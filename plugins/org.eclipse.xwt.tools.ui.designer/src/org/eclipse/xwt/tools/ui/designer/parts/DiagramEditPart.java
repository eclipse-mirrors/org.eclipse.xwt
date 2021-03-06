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
package org.eclipse.xwt.tools.ui.designer.parts;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.EditPolicy;
import org.eclipse.xwt.tools.ui.designer.core.parts.AbstractDiagramEditPart;
import org.eclipse.xwt.tools.ui.designer.policies.layout.LayoutEditPolicyFactory;
import org.eclipse.xwt.tools.ui.xaml.XamlDocument;

/**
 * @author jliu jin.liu@soyatec.com
 */
public class DiagramEditPart extends AbstractDiagramEditPart {

	public DiagramEditPart(XamlDocument document) {
		super(document);
	}

	/**
	 * @see org.AbstractDiagramEditPart.xaml.ve.editor.editparts.DiagramGraphicalEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		removeEditPolicy(EditPolicy.LAYOUT_ROLE);
		installEditPolicy(EditPolicy.LAYOUT_ROLE, LayoutEditPolicyFactory.NULL_LAYOUT);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
	protected List getModelChildren() {
		XamlDocument model = (XamlDocument) getModel();
		if (model.getRootElement() != null) {
			return Collections.singletonList(model.getRootElement());
		}
		return super.getModelChildren();
	}

	public String toString() {
		return "";
	}
}
