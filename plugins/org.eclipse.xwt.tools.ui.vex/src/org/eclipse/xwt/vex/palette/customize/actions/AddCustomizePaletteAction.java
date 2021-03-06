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
import org.eclipse.xwt.vex.palette.customize.InvokeType;
import org.eclipse.xwt.vex.palette.customize.dialogs.CustomizePaletteDialog;

/**
 * An action to launch the customize palette component dialog for the given palette.
 * 
 * @author BOB
 */
public class AddCustomizePaletteAction extends Action {

	private PaletteViewer paletteViewer;
	private InvokeType invokeType;
	private String selectionText;

	/**
	 * Constructor
	 * 
	 * @param palette
	 *            The Palette which has to be customized when this action is run
	 */
	public AddCustomizePaletteAction(PaletteViewer palette, String selectionText, InvokeType invokeType) {
		super();
		setText("&Add Customize Component");
		paletteViewer = palette;
		this.selectionText = selectionText;
		this.invokeType = invokeType;
	}

	/**
	 * Opens the customize palette dialog
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		Dialog customizeDialog;

		if (invokeType == InvokeType.MenuAdd) {
			customizeDialog = new CustomizePaletteDialog(InvokeType.MenuAdd, null, null);
		} else { // drad add
			customizeDialog = new CustomizePaletteDialog(InvokeType.DragAdd, null, selectionText);
		}
		customizeDialog.open();
	}

}
