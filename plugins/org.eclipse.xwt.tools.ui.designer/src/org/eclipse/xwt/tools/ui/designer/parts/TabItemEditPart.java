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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xwt.tools.ui.designer.core.editor.EditDomain;
import org.eclipse.xwt.tools.ui.designer.core.parts.RefreshContext;
import org.eclipse.xwt.tools.ui.designer.editor.XWTDesigner;
import org.eclipse.xwt.tools.ui.xaml.XamlNode;

/**
 * @author rui.ban rui.ban@soyatec.com
 */
public class TabItemEditPart extends ItemEditPart {

	public TabItemEditPart(Item item, XamlNode model) {
		super(item, model);
	}

	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#performRequest(org.eclipse.gef.Request)
	 */
	public void performRequest(Request request) {
		if (request.getType() == RequestConstants.REQ_OPEN) {
			Widget widget = getWidget();
			if (widget instanceof TabItem) {
				TabItem item = (TabItem) widget;
				TabFolder parent = item.getParent();
				parent.setSelection(item);
			}
			EditPart parent = getParent();
			EditDomain editDomain = EditDomain.getEditDomain(parent);
			XWTDesigner designer = (XWTDesigner) editDomain.getEditorPart();
			designer.refresh(parent, RefreshContext.ALL());
		}
	}

}
