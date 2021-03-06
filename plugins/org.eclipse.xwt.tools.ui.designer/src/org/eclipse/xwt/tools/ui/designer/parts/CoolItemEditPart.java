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

import org.eclipse.gef.EditPolicy;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.xwt.tools.ui.designer.policies.CoolItemEditPolicy;
import org.eclipse.xwt.tools.ui.xaml.XamlNode;

public class CoolItemEditPart extends ItemEditPart {

	public CoolItemEditPart(CoolItem coolItem, XamlNode model) {
		super(coolItem, model);
	}

	protected void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new CoolItemEditPolicy());
	}

}
