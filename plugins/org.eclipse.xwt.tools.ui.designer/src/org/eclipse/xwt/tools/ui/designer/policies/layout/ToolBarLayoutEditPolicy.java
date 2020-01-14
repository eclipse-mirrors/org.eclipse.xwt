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
import org.eclipse.swt.SWT;
import org.eclipse.xwt.tools.ui.designer.policies.NewNonResizeEditPolicy;
import org.eclipse.xwt.tools.ui.designer.utils.StyleHelper;
import org.eclipse.xwt.tools.ui.xaml.XamlElement;

/**
 * @author rui.ban rui.ban@soyatec.com
 */
public class ToolBarLayoutEditPolicy extends RowLayoutEditPolicy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.tools.ui.designer.policies.layout.RowLayoutEditPolicy#createChildEditPolicy(org.eclipse.gef.EditPart)
	 */
	protected EditPolicy createChildEditPolicy(EditPart child) {
		NewNonResizeEditPolicy editPolicy = new NewNonResizeEditPolicy(false);
		editPolicy.setDragAllowed(true);
		return editPolicy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.tools.ui.designer.policies.layout.RowLayoutEditPolicy#isHorizontal()
	 */
	protected boolean isHorizontal() {
		XamlElement model = (XamlElement) this.getHost().getModel();
		return StyleHelper.checkStyle(model, SWT.HORIZONTAL);
	}
}
