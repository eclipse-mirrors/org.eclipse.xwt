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

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xwt.vex.EditorMessages;
import org.eclipse.xwt.vex.palette.customize.CustomizeComponentFactory;
import org.eclipse.xwt.vex.toolpalette.ToolPalette;

/**
 * @author ZHOUBO
 * 
 */
public class ExportCustomizeComponentsAction extends Action {
	/**
	 * 
	 */
	public ExportCustomizeComponentsAction() {
		super();
		setText(EditorMessages.ExportCustomizeComponentsAction_ActionText);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		super.run();
		FileDialog saveDialog = new FileDialog(new Shell(), SWT.SAVE);
		saveDialog.setText(EditorMessages.ExportCustomizeComponentsAction_DialogText);
		String fileName = saveDialog.open();
		if (fileName != null) {
			URI uri = URI.createFileURI(fileName);

			CustomizeComponentFactory customizeComponentFactory = CustomizeComponentFactory.getCustomizeComponentFactory();
			ToolPalette customizeToolPalette = customizeComponentFactory.getCustomizeToolPalette();
			ResourceSet rs = new ResourceSetImpl();
			Resource resource = rs.createResource(uri);
			resource.getContents().add(customizeToolPalette);
			try {
				resource.save(null);
				MessageDialog.openInformation(null, EditorMessages.ExportCustomizeComponentsAction_INFORMATION, EditorMessages.ExportCustomizeComponentsAction_SUCCESS + fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
