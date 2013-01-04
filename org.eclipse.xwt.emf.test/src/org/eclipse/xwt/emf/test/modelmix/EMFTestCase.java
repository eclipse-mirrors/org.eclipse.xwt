/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.emf.test.modelmix;

import java.net.URL;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.emf.test.XWTTestCase;

public class EMFTestCase extends XWTTestCase {
	public void testEMFDataProvider_DataContext() {
		URL url = EMFTestCase.class
				.getResource(POJO_EMF_DataContext.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, POJO_EMF_DataContext.createAuthor(), null,
				new Runnable() {
					public void run() {
						assertText("titleText", "Harry Potter");
						assertText("authorText", "Neal Stephenson");
					}
				});
	}

	public void testEMFDataProvider_Path() {
		URL url = EMFTestCase.class
				.getResource(POJO_EMF_Path.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, POJO_EMF_Path.createAuthor(), null,
				new Runnable() {
					public void run() {
						assertText("titleText", "Harry Potter");
						assertText("authorText", "Neal Stephenson");
					}
				});
	}
}
