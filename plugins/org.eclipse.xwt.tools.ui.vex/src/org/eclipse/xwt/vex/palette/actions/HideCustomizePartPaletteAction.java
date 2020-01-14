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
package org.eclipse.xwt.vex.palette.actions;

import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xwt.vex.Activator;
import org.eclipse.xwt.vex.VEXEditor;
import org.eclipse.xwt.vex.palette.CustomPalettePage;
import org.eclipse.xwt.vex.palette.part.CustomizePaletteViewer;
import org.eclipse.xwt.vex.palette.part.DynamicPaletteViewer;
import org.eclipse.xwt.vex.swt.CustomSashForm;

public class HideCustomizePartPaletteAction extends Action {

	private PaletteViewer paletteViewer;
	private CustomizePaletteViewer customizePaletteViewer;
	private DynamicPaletteViewer dynamicPaletteViewer;
	private CustomSashForm sashFormMain;
	private CustomSashForm dynamicAndCustomizeSashForm;
	private Composite customizeComposite;

	public HideCustomizePartPaletteAction() {
		super("Hide/Show Customize Tools.", AS_CHECK_BOX);
		setToolTipText("Hide Customize Tools.");
		setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/full/obj16/hide1.gif"));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Object editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editor instanceof VEXEditor) {
			paletteViewer = ((CustomPalettePage) ((VEXEditor) editor).getVEXEditorPalettePage()).getPaletteViewer();
		}

		Object mainForm = paletteViewer.getProperty("SashFormMain");
		if (mainForm instanceof CustomSashForm) {
			sashFormMain = (CustomSashForm) mainForm;
		}

		Object objectDynamicPalette = paletteViewer.getProperty("Dynamic_PaletteViewer");
		if (objectDynamicPalette instanceof DynamicPaletteViewer) {
			dynamicPaletteViewer = (DynamicPaletteViewer) objectDynamicPalette;
		}

		Object objectCustomizePalette = paletteViewer.getProperty("Customize_PaletteViewer");
		if (objectCustomizePalette instanceof CustomizePaletteViewer) {
			customizePaletteViewer = (CustomizePaletteViewer) objectCustomizePalette;
		}

		Object customizeSashForm = customizePaletteViewer.getProperty("DynamicAndCustomizeSashForm");
		if (customizeSashForm instanceof CustomSashForm) {
			dynamicAndCustomizeSashForm = (CustomSashForm) customizeSashForm;
		}

		Object composite = customizePaletteViewer.getProperty("CustomizeComposite");
		if (composite instanceof Composite) {
			customizeComposite = (Composite) composite;
		}

		if (isChecked()) {
			customizePaletteViewer.setVisible(false);
			customizeComposite.setVisible(false);
			dynamicAndCustomizeSashForm.setWeights((new int[] { 1, 0 }));
			if ((customizePaletteViewer.isVisible() == false) && (dynamicPaletteViewer.isVisible() == false)) {
				dynamicAndCustomizeSashForm.setVisible(false);
				sashFormMain.setWeights(new int[] { 1, 0 });
			}
			setToolTipText("Show Customize Tools.");
		} else {
			customizeComposite.setVisible(true);
			customizePaletteViewer.setVisible(true);
			dynamicAndCustomizeSashForm.setVisible(true);
			dynamicAndCustomizeSashForm.setWeights((new int[] { 1, 1 }));
			sashFormMain.setWeights(new int[] { 2, 1 });
			setToolTipText("Hide Customize Tools.");
		}
	}

}
