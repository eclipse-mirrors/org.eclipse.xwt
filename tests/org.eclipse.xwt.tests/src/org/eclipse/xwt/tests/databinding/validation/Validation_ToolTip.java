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
 *     Soyatec & hceylan - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.databinding.validation;

import java.net.URL;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.internal.core.Binding;

public class Validation_ToolTip {
	public static void main(String[] args) {

		URL url = Validation_ToolTip.class.getResource(Validation_ToolTip.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			
			final Display display = new Display();
			
			XWT.open(url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
