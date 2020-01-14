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

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.xwt.tools.ui.designer.core.figures.ContentPaneFigure;
import org.eclipse.xwt.tools.ui.designer.parts.figures.MenuFigure;
import org.eclipse.xwt.tools.ui.designer.policies.ExpandableEditPolicy;
import org.eclipse.xwt.tools.ui.designer.policies.MenuLayoutEditPolicy;
import org.eclipse.xwt.tools.ui.designer.policies.NewNonResizeEditPolicy;
import org.eclipse.xwt.tools.ui.designer.policies.PolicyConstants;
import org.eclipse.xwt.tools.ui.xaml.XamlNode;

public class MenuEditPart extends WidgetEditPart {

	public MenuEditPart(Menu menu, XamlNode model) {
		super(menu, model);
	}

	protected void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new MenuLayoutEditPolicy());
		installEditPolicy(PolicyConstants.EXPANDABLE_EDITPOLICY,
				new ExpandableEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				new NewNonResizeEditPolicy(false));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.soyatec.xaml.ve.editor.editparts.GraphicalNodeEditPart#createFigure()
	 */
	protected IFigure createFigure() {
		ContentPaneFigure figure = new ContentPaneFigure();
		figure.setContentPane(new MenuFigure(this));
		return figure;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xwt.tools.ui.designer.parts.WidgetEditPart#getModelChildren
	 * ()
	 */
	protected List getModelChildren() {
		return super.getModelChildren();
	}

}
