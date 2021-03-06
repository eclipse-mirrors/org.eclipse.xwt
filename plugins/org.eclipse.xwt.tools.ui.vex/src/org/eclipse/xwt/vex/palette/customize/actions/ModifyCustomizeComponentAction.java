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
package org.eclipse.xwt.vex.palette.customize.actions;

import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.xwt.vex.palette.customize.CustomizeComponentFactory;
import org.eclipse.xwt.vex.palette.customize.InvokeType;
import org.eclipse.xwt.vex.palette.customize.dialogs.CustomizePaletteDialog;

public class ModifyCustomizeComponentAction extends Action {
	private String selectComponentName = "";
	private PaletteViewer paletteViewer;

	public ModifyCustomizeComponentAction(PaletteViewer paletteViewer, String selectComponentName) {
		super();
		setText("&Modify Selected Component");
		this.paletteViewer = paletteViewer;
		this.selectComponentName = selectComponentName;
	}

	@Override
	public void run() {
		super.run();
		// modify customize component
		// CustomizeComponentFactory customizeComponentFactory = CustomizeComponentFactory
		// .getCustomizeComponentFactory();
		Dialog customizeDialog = new CustomizePaletteDialog(InvokeType.Modify, selectComponentName, null);
		customizeDialog.open();
	}

}
