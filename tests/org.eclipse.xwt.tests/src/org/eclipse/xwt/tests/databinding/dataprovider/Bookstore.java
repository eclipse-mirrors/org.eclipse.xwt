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
package org.eclipse.xwt.tests.databinding.dataprovider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class Bookstore {

	private List<Book> books = new ArrayList<>();

	/**
	 * 
	 */
	public Bookstore() {
		Book b = new Book();
		b.setTitle(new Title("en", "Everyday Italian"));
		b.setYear(2005);
		b.setPrice(30.00f);
		ArrayList<String> authors = new ArrayList<>();
		authors.add("Giada De Laurentiis");
		b.authors = authors;
		books.add(b);

		b = new Book();
		b.setTitle(new Title("en", "Harry Potter"));
		b.setYear(2005);
		b.setPrice(29.99f);
		authors = new ArrayList<>();
		authors.add("Neal Stephenson");
		b.authors = authors;
		books.add(b);

		b = new Book();
		b.setTitle(new Title("en", "Learning XML"));
		b.setYear(2003);
		b.setPrice(39.95f);
		authors = new ArrayList<>();
		authors.add("Erik T. Ray");
		b.authors = authors;
		books.add(b);
	}

	public Book getFirstBook() {
		return books.get(0);
	}

	public List<Book> getAll() {
		return books;
	}

	public Book getBook(String title) {
		for (Book b : books) {
			if (title.equals(b.getTitle().getText())) {
				return b;
			}
		}
		return null;
	}
}
