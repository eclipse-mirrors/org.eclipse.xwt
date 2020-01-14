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
package org.eclipse.xwt.tests.clr;

import java.net.URL;
import java.util.HashMap;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.IXWTLoader;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class CLRTests extends XWTTestCase {

	public void testCLR() throws Exception {
		URL url = CLR.class.getResource(CLR.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Object element = XWT.getCLR(root);
				assertTrue(element instanceof CLR);
			}
		});
	}

	public void testCLRComposite() throws Exception {
		URL url = CLR.class.getResource(CLRComposite.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Object element = XWT.getCLR(root);
				assertTrue(element instanceof CLRComposite);
			}
		});
	}

	public void testCLRNull() throws Exception {
		URL url = CLR.class.getResource(CLRNull.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		HashMap<String, Object> options = new HashMap<String, Object>();
		final CLRNull clr = new CLRNull();
		options.put(IXWTLoader.CLASS_PROPERTY, clr);
		runTest(url, options, null, new Runnable() {
			public void run() {
				Object element = XWT.getCLR(root);
				assertTrue(element == clr);
				assertEquals(clr.getCount(), 1);
			}
		});
	}
}
