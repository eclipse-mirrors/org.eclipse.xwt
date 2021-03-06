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
package org.eclipse.xwt.tools.ui.designer.editor.actions;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xwt.tools.ui.designer.databinding.ui.DataBindingWindow;
import org.eclipse.xwt.tools.ui.designer.editor.XWTDesigner;
import org.eclipse.xwt.tools.ui.designer.loader.XWTProxy;
import org.eclipse.xwt.tools.ui.designer.resources.ImageShop;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class OpenBindingDialogAction extends WorkbenchPartAction {

	public static final String ID = OpenBindingDialogAction.class.getName();

	public OpenBindingDialogAction(IWorkbenchPart part) {
		super(part);
		setId(ID);
		setText("Open Binding Dialog");
		setImageDescriptor(ImageShop.getImageDescriptor(ImageShop.IMG_BINDING));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		XWTDesigner designer = (XWTDesigner) getWorkbenchPart();
		Object root = designer.getVisualsRender().getRoot();
		if (root instanceof Widget) {
			root = XWTProxy.getModel((Widget) root);
		}
		EditPart editPart = designer.getEditPart(root);
		DataBindingWindow window = new DataBindingWindow(designer.getSite().getShell(), editPart);
		window.open();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
	 */
	protected boolean calculateEnabled() {
		return true;
	}

}
