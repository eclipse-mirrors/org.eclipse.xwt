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

/**
 * @author ZHOUBO
 * 
 */
public class ImportCustomizeComponentsAction extends Action {

	/**
	 * 
	 */
	public ImportCustomizeComponentsAction() {
		setText(EditorMessages.ImportCustomizeComponentsAction_ActionText);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		super.run();

		FileDialog saveDialog = new FileDialog(new Shell(), SWT.OPEN);
		saveDialog.setText(EditorMessages.ImportCustomizeComponentsAction_DialogText);
		String fileName = saveDialog.open();
		if (fileName != null) {
			try {
				URI uri = URI.createFileURI(fileName);
				ResourceSet rs = new ResourceSetImpl();
				Resource resource = rs.createResource(uri);
				resource.load(null);
				CustomizeComponentFactory customizeComponentFactory = CustomizeComponentFactory.getCustomizeComponentFactory();
				customizeComponentFactory.importCustomizeTool(resource);
			} catch (IOException e) {
				MessageDialog.openError(null, EditorMessages.ImportCustomizeComponentsAction_ERROR, EditorMessages.ImportCustomizeComponentsAction_ERROR_INFORMATION);
				e.printStackTrace();
			}
		}
	}
}
