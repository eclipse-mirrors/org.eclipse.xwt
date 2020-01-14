/*******************************************************************************
 * Copyright (c) 2006, 2009 Soyatec (http://www.soyatec.com) and others.
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
package org.eclipse.xwt.tools.ui.workbench;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.xwt.jface.XWTTitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * @author yyang <yves.yang@soyatec.com>
 */
public class PartInitializerAction {
	private Class<?> cls;

	public PartInitializerAction(Class<?> cls) {
		this.cls = cls;
	}

	public boolean run(Object element) {
		if (!(element instanceof MPart)) {
			return false;
		}
		XWTTitleAreaDialog dialog = new XWTTitleAreaDialog(getCurrentShell(),
				cls, element);
		return (dialog.open() == Window.OK);
	}

	protected Shell getCurrentShell() {
		Display display = Display.getCurrent();
		if (display == null) {
			display = Display.getDefault();
		}
		Shell shell = Display.getDefault().getActiveShell();
		if (shell != null) {
			return shell;
		}
		IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		if (workbenchWindow != null) {
			return workbenchWindow.getShell();
		}
		return null;
	}
}
