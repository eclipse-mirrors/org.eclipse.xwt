/*******************************************************************************
 * Copyright (c) 2013 Eclipse XWT Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Erdal Karaca - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.emf.test.masterdetail;

import java.net.URL;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.emf.EMFBinding;
import org.eclipse.xwt.emf.test.books.Book;
import org.eclipse.xwt.emf.test.books.BooksFactory;
import org.eclipse.xwt.emf.test.books.Bookstore;
import org.eclipse.xwt.emf.test.books.Title;

public class EMFDataProvider_MasterDetail {
	public static void main(String[] args) {
		EMFBinding.initialze();
		URL url = EMFDataProvider_MasterDetail.class
				.getResource(EMFDataProvider_MasterDetail.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.open(url, createBookstore());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Bookstore createBookstore() {
		Bookstore bookstore = BooksFactory.eINSTANCE.createBookstore();

		for (int i = 0; i < 10; i++) {
			Book book = BooksFactory.eINSTANCE.createBook();
			Title title = BooksFactory.eINSTANCE.createTitle();
			title.setText("Book " + i);
			book.setTitle(title);
			book.setPrice(Math.random() * 100);
			book.setAuthor("Author " + i);
			bookstore.getBooks().add(book);
		}

		return bookstore;
	}
}
