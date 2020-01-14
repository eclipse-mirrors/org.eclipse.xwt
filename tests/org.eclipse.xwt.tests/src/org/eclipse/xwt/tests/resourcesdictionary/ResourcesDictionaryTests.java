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
package org.eclipse.xwt.tests.resourcesdictionary;

import java.net.URL;
import java.util.Map;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class ResourcesDictionaryTests extends XWTTestCase {

	public void testFindResource() throws Exception {
		URL url = ResourcesDictionaryTests.class.getResource(Container.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Object element1 = XWT.findResource(root, "myDBC1");
				assertTrue(element1 instanceof MyData);
				Object element2 = XWT.findResource(root, "myDBC2");
				assertTrue(element2 instanceof MyData);
			}
		});
	}

	public void testGetResources() throws Exception {
		URL url = ResourcesDictionaryTests.class.getResource(Container.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Map<String, Object> dictionary = XWT.getResources(root);
				assertEquals(2, dictionary.size());
			}
		});
	}
}
