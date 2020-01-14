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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.xwt.tools.ui.designer.loader.XWTProxy;
import org.eclipse.xwt.tools.ui.designer.policies.ExpandBarEditPolicy;
import org.eclipse.xwt.tools.ui.xaml.XamlNode;

/**
 * @author yahong.song@soyatec.com
 */
public class ExpandBarEditPart extends CompositeEditPart {

	public ExpandBarEditPart(ExpandBar expandBar, XamlNode model) {
		super(expandBar, model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.tools.ui.designer.parts.ControlEditPart#CollectExternalModels()
	 */
	protected void collectExternalModels(List<Object> collector) {
		ExpandBar expandBar = (ExpandBar) getWidget();
		if (expandBar != null && !expandBar.isDisposed()) {
			Control[] children = expandBar.getChildren();
			for (Control control : children) {
				Object data = XWTProxy.getModel(control);
				if (data != null) {
					collector.add(data);
				}
			}
		}
	}

	protected void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ExpandBarEditPolicy());
	}
}
