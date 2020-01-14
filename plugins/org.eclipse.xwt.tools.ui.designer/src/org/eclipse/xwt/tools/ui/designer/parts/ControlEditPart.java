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
import org.eclipse.xwt.metadata.IProperty;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xwt.tools.ui.designer.core.visuals.IVisualInfo;
import org.eclipse.xwt.tools.ui.designer.core.visuals.swt.ControlInfo;
import org.eclipse.xwt.tools.ui.designer.loader.XWTProxy;
import org.eclipse.xwt.tools.ui.designer.parts.direct.ElementCellEditLocator;
import org.eclipse.xwt.tools.ui.designer.parts.direct.ElementDirectEditManager;
import org.eclipse.xwt.tools.ui.designer.policies.ElementDirectEditPolicy;
import org.eclipse.xwt.tools.ui.designer.policies.layout.ControlLayoutEditPolicy;
import org.eclipse.xwt.tools.ui.designer.utils.XWTUtility;
import org.eclipse.xwt.tools.ui.xaml.XamlNode;

/**
 * @author jliu jin.liu@soyatec.com
 */
public class ControlEditPart extends WidgetEditPart {

	protected DirectEditManager manager;

	public ControlEditPart(Control control, XamlNode model) {
		super(control, model);
	}

	public void performRequest(Request request) {
		// Fixed bug: 0000860: the datatime should not have the attribute "text".
		IProperty property = XWTUtility.getProperty(getCastModel(), "text");

		if (request.getType() == RequestConstants.REQ_OPEN && property != null) {
			if (manager == null) {
				IFigure figure = getFigure();
				manager = new ElementDirectEditManager(this, TextCellEditor.class, new ElementCellEditLocator(figure),
						figure);
			}
			manager.show();
		}
		super.performRequest(request);
	}

	/**
	 * @see org.soyatec.xaml.ve.editor.editparts.ElementGraphicalEditPart#getVisualInfo()
	 */
	public IVisualInfo createVisualInfo() {
		return new ControlInfo(getWidget(), isRoot());
	}

	/*
	 * (non-Javadoc)
	 * @see org.soyatec.xaml.ve.xwt.editparts.WidgetEditPart#collectExternalModels()
	 */
	protected void collectExternalModels(List<Object> collector) {
		super.collectExternalModels(collector);
		Control control = (Control) getWidget();
		if (control != null && !control.isDisposed()) {
			Menu menu = control.getMenu();
			if (menu != null) {
				Object data = XWTProxy.getModel(menu);
				if (data != null) {
					collector.add(data);
				}
			}
		}
	}

	public boolean isRightToLeft() {
		Widget widget = getWidget();
		if (widget == null || widget.isDisposed()) {
			return false;
		}
		return ((widget.getStyle() & SWT.RIGHT_TO_LEFT) != 0);
	}

	/*
	 * (non-Javadoc)
	 * @see org.soyatec.xaml.ve.editor.editparts.GraphicalNodeEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new ElementDirectEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ControlLayoutEditPolicy());
		super.createEditPolicies();
	}
}
