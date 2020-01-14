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

import org.eclipse.xwt.emf.test.books.Book;
import org.eclipse.xwt.emf.test.books.BooksFactory;
import org.eclipse.xwt.emf.test.books.Bookstore;
import org.eclipse.xwt.emf.test.books.Title;

public class MyBooks {

	private Bookstore bookstore;
	private Book harryPotter;

	public Book getBook() {
		if (harryPotter == null) {
			harryPotter = BooksFactory.eINSTANCE.createBook();
			Title title = BooksFactory.eINSTANCE.createTitle();
			title.setLan("en");
			title.setText("Harry Potter");
			harryPotter.setTitle(title);
			harryPotter.setAuthor("Neal Stephenson");
			harryPotter.setPrice(29.99);
			harryPotter.setYear(2005);
		}
		return harryPotter;
	}

	public Bookstore getBookstore() {
		if (bookstore == null) {
			bookstore = BooksFactory.eINSTANCE.createBookstore();
			bookstore.getBooks().add(getBook());
		}
		return bookstore;
	}
}
