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
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.xwt.tools.ui.designer.commands.ChangeLayoutCommand;
import org.eclipse.xwt.tools.ui.designer.core.editor.EditDomain;
import org.eclipse.xwt.tools.ui.designer.layouts.LayoutType;
import org.eclipse.xwt.tools.ui.designer.layouts.LayoutsHelper;
import org.eclipse.xwt.tools.ui.designer.resources.ImageShop;

/**
 * @author rui.ban rui.ban@soyatec.com
 */
public class ChangeLayoutAction extends Action {

	private EditPart editPart;
	private LayoutType layoutType;

	/**
	 * @param editPart
	 * @param text
	 */
	public ChangeLayoutAction(EditPart editPart, LayoutType layout) {
		super(layout.value(), IAction.AS_RADIO_BUTTON);
		this.layoutType = layout;
		this.editPart = editPart;
		setImageDescriptor(ImageShop.getImageDescriptor(ImageShop.OBJ16 + layout.value() + "_obj.gif"));
		setChecked(LayoutsHelper.getLayoutType(editPart) == layout);
	}

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		if (isChecked() && editPart != null) {
			EditDomain.getEditDomain(editPart).getCommandStack().execute(new ChangeLayoutCommand(editPart, layoutType));
		}
	}

}
