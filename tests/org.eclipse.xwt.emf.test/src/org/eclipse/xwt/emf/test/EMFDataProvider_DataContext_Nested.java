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
package org.eclipse.xwt.emf.test;

import java.net.URL;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.emf.EMFBinding;
import org.eclipse.xwt.emf.test.books.Book;
import org.eclipse.xwt.emf.test.books.BooksFactory;
import org.eclipse.xwt.emf.test.books.Title;

/**
 * @author yyang (yves.yang@soyatec.com)
 */
public class EMFDataProvider_DataContext_Nested {
	public static void main(String[] args) {
		EMFBinding.initialze();
		URL url = EMFDataProvider_DataContext_Nested.class
				.getResource(EMFDataProvider_DataContext_Nested.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.open(url, createBook());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static Book createBook() {
		Book harryPotter = BooksFactory.eINSTANCE.createBook();
		Title title = BooksFactory.eINSTANCE.createTitle();
		title.setLan("en");
		title.setText("Harry Potter");
		harryPotter.setTitle(title);
		harryPotter.setAuthor("Neal Stephenson");
		harryPotter.setPrice(29.99);
		harryPotter.setYear(2005);

		return harryPotter;
	}
}
