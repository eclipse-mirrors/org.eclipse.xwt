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
package org.eclipse.xwt.emf.test.books;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Bookstore</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.xwt.emf.test.books.Bookstore#getBooks <em>Books
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.xwt.emf.test.books.BooksPackage#getBookstore()
 * @model
 * @generated
 */
public interface Bookstore extends EObject {
	/**
	 * Returns the value of the '<em><b>Books</b></em>' containment reference
	 * list. The list nameMap are of type
	 * {@link org.eclipse.xwt.emf.test.books.Book}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Books</em>' containment reference list.
	 * @see org.eclipse.xwt.emf.test.books.BooksPackage#getBookstore_Books()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Book> getBooks();

} // Bookstore
