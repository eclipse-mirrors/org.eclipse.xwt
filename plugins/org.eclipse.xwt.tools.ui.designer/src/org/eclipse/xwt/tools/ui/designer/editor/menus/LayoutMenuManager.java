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
package org.eclipse.xwt.tools.ui.designer.editor.menus;

import org.eclipse.gef.EditPart;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.xwt.tools.ui.designer.editor.actions.ChangeLayoutAction;
import org.eclipse.xwt.tools.ui.designer.layouts.LayoutType;
import org.eclipse.xwt.tools.ui.designer.layouts.LayoutsHelper;

/**
 * @author rui.ban rui.ban@soyatec.com
 */
public class LayoutMenuManager extends MenuManager {

	private EditPart editPart;

	public LayoutMenuManager(EditPart editPart, String text) {
		super(text);
		this.editPart = editPart;
		if (LayoutsHelper.canSetLayout(editPart)) {
			initMenus();
		}
	}

	private void initMenus() {
		for (LayoutType layout : LayoutsHelper.layoutsList) {
			add(new ChangeLayoutAction(editPart, layout));
		}
	}
}
