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
package org.eclipse.xwt.tests.controls.shell;

import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.tests.XWTTestCase;

public class ShellTests extends XWTTestCase {
	public void testShell_Trim() throws Exception {
		URL url = Shell_Trim.class.getResource(Shell_Trim.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Shell shell = (Shell) root;
				assertTrue((shell.getStyle() & SWT.SHELL_TRIM) == SWT.SHELL_TRIM);
			}
		});
	}

	public void testDialog_Trim() throws Exception {
		URL url = Shell_Dialog_Trim.class.getResource(Shell_Dialog_Trim.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Shell shell = (Shell) root;
				assertTrue((shell.getStyle() & SWT.DIALOG_TRIM) == SWT.DIALOG_TRIM);
			}
		});
	}
}
