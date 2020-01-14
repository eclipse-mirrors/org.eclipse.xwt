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
package org.eclipse.xwt.tests.style.java;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xwt.IStyle;
import org.eclipse.xwt.XWT;

/**
 * Style is handled in Java
 * 
 * @author yyang
 */
public class GreenStyle implements IStyle {

	public void applyStyle(Object target) {
		String name = XWT.getElementName(target);
		Control control = null;
		if (target instanceof Control) {
			control = (Control) target;
		} else if (target instanceof Viewer) {
			Viewer viewer = (Viewer) target;
			control = (Control) viewer.getControl();
		}
		if (control != null) {
			control.setBackground(control.getDisplay().getSystemColor(
					SWT.COLOR_DARK_GREEN));
			control.setData("__MySignature", name);
		}
	}
}
