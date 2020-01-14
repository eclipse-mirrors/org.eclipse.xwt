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
package org.eclipse.xwt.emf.test;

import java.net.URL;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.emf.EMFBinding;
import org.eclipse.xwt.emf.test.books.BooksFactory;

public class EMFTestCase extends XWTTestCase {
	public EMFTestCase() {
		EMFBinding.initialze();
		EPackage.Registry.INSTANCE.put("org.eclipse.xwt.emf/books.ecore",
				BooksFactory.eINSTANCE);
	}

	public void testEMFDataProvider_DataContext() {
		URL url = EMFTestCase.class
				.getResource(EMFDataProvider_DataContext.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, EMFDataProvider_DataContext.createBook(), null,
				new Runnable() {
					public void run() {
						assertText("titleText", "Harry Potter");
						assertText("authorText", "Neal Stephenson");
					}
				});
	}

	public void testEMFDataProvider_DataContext_Dynamic() {
		URL url = EMFTestCase.class
				.getResource(EMFDataProvider_DataContext_Dynamic.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, EMFDataProvider_DataContext_Dynamic.createBook(), null,
				new Runnable() {
					public void run() {
						assertText("titleText", "Harry Potter");
						assertText("authorText", "Neal Stephenson");
					}
				});
	}

	public void testEMFDataProvider_DataContext_Nested() {
		URL url = EMFTestCase.class
				.getResource(EMFDataProvider_DataContext_Nested.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, EMFDataProvider_DataContext_Nested.createBook(), null,
				new Runnable() {
					public void run() {
						assertText("titleText", "Harry Potter");
						assertText("authorText", "Neal Stephenson");
					}
				});
	}

	public void testEMFDataProvider_Type() {
		URL url = EMFTestCase.class.getResource(EMFDataProvider_Type.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		runTest(url, new Runnable() {
			public void run() {
				setText("titleText", "Harry Potter");
				setText("authorText", "Neal Stephenson");
			}
		}, new Runnable() {
			public void run() {
				assertText("titleText", "Harry Potter");
				assertText("authorText", "Neal Stephenson");
			}
		});
	}
}
