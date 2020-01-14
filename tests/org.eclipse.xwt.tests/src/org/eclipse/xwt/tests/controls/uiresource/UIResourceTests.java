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
package org.eclipse.xwt.tests.controls.uiresource;

import java.net.URL;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.IUIResource;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class UIResourceTests extends XWTTestCase {
	public void testControlSize() throws Exception {
		URL url = UIResourceTests.class.getResource(Control_Size.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		IUIResource pattern = XWT.loadAsResource(url);
		runTest(pattern, new Runnable() {
			public void run() {
				checkLabel();
				checkButton();
			}

			public void checkLabel() {
				Object element = XWT.findElementByName(root, "targetLabel");
				assertTrue(element instanceof Label);
				Label label = (Label) element;
				Point size = label.getSize();
				assertTrue(size.x == 100 && size.y == 40);
			}

			public void checkButton() {
				Object element = XWT.findElementByName(root, "targetButton");
				assertTrue(element instanceof Button);
				Button button = (Button) element;
				Point size = button.getSize();
				assertTrue(size.x == 200 && size.y == 200);
			}
		});
		
		runTest(pattern, new Runnable() {
			public void run() {
				checkLabel();
				checkButton();
			}

			public void checkLabel() {
				Object element = XWT.findElementByName(root, "targetLabel");
				assertTrue(element instanceof Label);
				Label label = (Label) element;
				Point size = label.getSize();
				assertTrue(size.x == 100 && size.y == 40);
			}

			public void checkButton() {
				Object element = XWT.findElementByName(root, "targetButton");
				assertTrue(element instanceof Button);
				Button button = (Button) element;
				Point size = button.getSize();
				assertTrue(size.x == 200 && size.y == 200);
			}
		});
	}
}
