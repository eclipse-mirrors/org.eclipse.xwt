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

import org.eclipse.gef.EditPolicy;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Item;
import org.eclipse.xwt.tools.ui.designer.loader.XWTProxy;
import org.eclipse.xwt.tools.ui.designer.policies.layout.StackableLayoutEditPolicy;
import org.eclipse.xwt.tools.ui.xaml.XamlNode;

/**
 * @author jin.liu (jin.liu@soyatec.com)
 * 
 */
public abstract class StackableEditPart extends CompositeEditPart {

	public StackableEditPart(Composite composite, XamlNode model) {
		super(composite, model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xwt.tools.ui.designer.parts.ControlEditPart#collectExternalModels
	 * ()
	 */
	protected void collectExternalModels(List<Object> collector) {
		super.collectExternalModels(collector);
		Control popControl = getPopControl();
		if (popControl != null) {
			XamlNode model = XWTProxy.getModel(popControl);
			if (model != null) {
				collector.add(model);
			}
		}
	}

	public StackItemEditPart getPopItemPart() {
		Item popItem = getPopItem();
		if (popItem == null || popItem.isDisposed()) {
			return null;
		}
		XamlNode model = XWTProxy.getModel(popItem);
		return (StackItemEditPart) getViewer().getEditPartRegistry().get(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.xwt.tools.ui.designer.parts.CompositeEditPart#
	 * createEditPolicies()
	 */
	protected void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.LAYOUT_ROLE,
				new StackableLayoutEditPolicy());
	}

	protected abstract Control getPopControl();

	protected abstract Item getPopItem();
}
