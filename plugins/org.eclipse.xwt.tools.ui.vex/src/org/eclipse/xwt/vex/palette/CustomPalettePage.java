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
package org.eclipse.xwt.vex.palette;

import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.gef.ui.views.palette.PaletteViewerPage;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.xwt.vex.palette.actions.HideCustomizePartPaletteAction;
import org.eclipse.xwt.vex.palette.actions.HideDynamicPartPaletteAction;
import org.eclipse.xwt.vex.palette.actions.HideToolPartPaletteAction;

/**
 * @author yyang
 * 
 */
public class CustomPalettePage extends PaletteViewerPage {

	private HideToolPartPaletteAction hideToolPartPaletteAction;
	private HideDynamicPartPaletteAction hideDynamicPartPaletteAction;
	private HideCustomizePartPaletteAction hideCustomizePartPaletteAction;

	/**
	 * Constructor
	 * 
	 * @param provider
	 *            the provider used to create a PaletteViewer
	 */
	public CustomPalettePage(PaletteViewerProvider provider) {
		super(provider);
	}

	/**
	 * @return the PaletteViewer created and displayed by this page
	 */
	public PaletteViewer getPaletteViewer() {
		return viewer;
	}

	@Override
	public void setActionBars(IActionBars actionBars) {
		// TODO Auto-generated method stub
		hideToolPartPaletteAction = new HideToolPartPaletteAction();
		hideDynamicPartPaletteAction = new HideDynamicPartPaletteAction();
		hideCustomizePartPaletteAction = new HideCustomizePartPaletteAction();

		fillMenuBar(actionBars.getMenuManager());
		fillToolBar(actionBars.getToolBarManager());
	}

	private void fillMenuBar(IMenuManager manager) {
		manager.add(hideToolPartPaletteAction);
		manager.add(hideDynamicPartPaletteAction);
		manager.add(hideCustomizePartPaletteAction);
	}

	protected void fillToolBar(IToolBarManager manager) {
		manager.add(hideToolPartPaletteAction);
		manager.add(hideDynamicPartPaletteAction);
		manager.add(hideCustomizePartPaletteAction);
	}

}
