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
package org.eclipse.xwt.tests.controls.shell;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;

/**
 * @author jliu
 */
public class Shell_Styles {

	private static List<Shell> shells = new ArrayList<Shell>();

	public static void main(String[] args) {
		URL url = Shell_Styles.class.getResource(Shell_Styles.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.open(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void createShell(Event event) {
		Button button = (Button) event.widget;
		Composite parent = button.getParent();
		Control[] children = parent.getChildren();
		int style = 0;
		for (Control control : children) {
			if (control instanceof Group) {
				Group grp = (Group) control;
				String text = grp.getText();
				if ("Decoration Styles".equals(text)
						|| "Modal Styles".equals(text)) {
					style |= createStyle(grp);
				}
			}
		}
		Shell shell = new Shell(style);
		shell.open();
		shells.add(shell);
	}

	/**
	 * @param grp
	 */
	private int createStyle(Group grp) {
		int style = 0;
		Control[] children = grp.getChildren();
		for (Control control : children) {
			if (control instanceof Button) {
				Button btn = (Button) control;
				String str = btn.getText();
				if (!btn.getSelection()) {
					continue;
				} else if ("SWT.NO_TRIM".equals(str)) {
					style |= SWT.NO_TRIM;
				} else if ("SWT.SHELL_TRIM".equals(str)) {
					style |= SWT.SHELL_TRIM;
				} else if ("SWT.DIALOG_TRIM".equals(str)) {
					style |= SWT.DIALOG_TRIM;
				} else if ("SWT.CLOSE".equals(str)) {
					style |= SWT.CLOSE;
				} else if ("SWT.MIN".equals(str)) {
					style |= SWT.MIN;
				} else if ("SWT.MAX".equals(str)) {
					style |= SWT.MAX;
				} else if ("SWT.RESIZE".equals(str)) {
					style |= SWT.RESIZE;
				} else if ("SWT.TOOL".equals(str)) {
					style |= SWT.TOOL;
				} else if ("SWT.TITLE".equals(str)) {
					style |= SWT.TITLE;
				} else if ("SWT.BORDER".equals(str)) {
					style |= SWT.BORDER;
				} else if ("SWT.ON_TOP".equals(str)) {
					style |= SWT.ON_TOP;
				} else if ("SWT.MODELESS".equals(str)) {
					style |= SWT.MODELESS;
				} else if ("SWT.PRIMARY_MODAL".equals(str)) {
					style |= SWT.PRIMARY_MODAL;
				} else if ("SWT.APPLICATION_MODAL".equals(str)) {
					style |= SWT.APPLICATION_MODAL;
				} else if ("SWT.SYSTEM_MODAL".equals(str)) {
					style |= SWT.SYSTEM_MODAL;
				}
			}
		}
		return style;
	}

	protected void closeAllShells(Event event) {
		if (shells.isEmpty()) {
			return;
		}
		for (Shell shell : shells) {
			shell.dispose();
		}
	}
}
