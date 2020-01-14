/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.css.tests.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.css.CSSStyle;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class StyleOpen implements IObjectActionDelegate {
	protected IFile file;

	/**
	 * Constructor for Action1.
	 */
	public StyleOpen() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader(
					StyleOpen.class.getClassLoader());
			XWT.addDefaultStyle(new CSSStyle(StyleOpen.class
					.getResource("style.css")));
			if (file != null) {
				DisplayUtil.open(file);
			}
		} finally {
			Thread.currentThread().setContextClassLoader(classLoader);
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		file = null;
		if (selection.isEmpty()) {
			return;
		}
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		file = (IFile) structuredSelection.getFirstElement();
	}
}
