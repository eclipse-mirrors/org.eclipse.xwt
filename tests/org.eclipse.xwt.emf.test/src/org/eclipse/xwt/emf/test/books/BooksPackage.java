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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.xwt.emf.test.books.BooksFactory
 * @model kind="package"
 * @generated
 */
public interface BooksPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "books";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "org.eclipse.xwt.emf/books.ecore";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "books";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	BooksPackage eINSTANCE = org.eclipse.xwt.emf.test.books.impl.BooksPackageImpl
			.init();

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.xwt.emf.test.books.impl.BookstoreImpl
	 * <em>Bookstore</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.xwt.emf.test.books.impl.BookstoreImpl
	 * @see org.eclipse.xwt.emf.test.books.impl.BooksPackageImpl#getBookstore()
	 * @generated
	 */
	int BOOKSTORE = 0;

	/**
	 * The feature id for the '<em><b>Books</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOKSTORE__BOOKS = 0;

	/**
	 * The number of structural features of the '<em>Bookstore</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOKSTORE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.xwt.emf.test.books.impl.BookImpl <em>Book</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.xwt.emf.test.books.impl.BookImpl
	 * @see org.eclipse.xwt.emf.test.books.impl.BooksPackageImpl#getBook()
	 * @generated
	 */
	int BOOK = 1;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOK__AUTHOR = 0;

	/**
	 * The feature id for the '<em><b>Price</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOK__PRICE = 1;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOK__YEAR = 2;

	/**
	 * The feature id for the '<em><b>Title</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOK__TITLE = 3;

	/**
	 * The number of structural features of the '<em>Book</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOK_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.xwt.emf.test.books.impl.TitleImpl <em>Title</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.xwt.emf.test.books.impl.TitleImpl
	 * @see org.eclipse.xwt.emf.test.books.impl.BooksPackageImpl#getTitle()
	 * @generated
	 */
	int TITLE = 2;

	/**
	 * The feature id for the '<em><b>Lan</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TITLE__LAN = 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TITLE__TEXT = 1;

	/**
	 * The number of structural features of the '<em>Title</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TITLE_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.xwt.emf.test.books.Bookstore <em>Bookstore</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Bookstore</em>'.
	 * @see org.eclipse.xwt.emf.test.books.Bookstore
	 * @generated
	 */
	EClass getBookstore();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.xwt.emf.test.books.Bookstore#getBooks
	 * <em>Books</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Books</em>'.
	 * @see org.eclipse.xwt.emf.test.books.Bookstore#getBooks()
	 * @see #getBookstore()
	 * @generated
	 */
	EReference getBookstore_Books();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.xwt.emf.test.books.Book <em>Book</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Book</em>'.
	 * @see org.eclipse.xwt.emf.test.books.Book
	 * @generated
	 */
	EClass getBook();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.xwt.emf.test.books.Book#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Title</em>'.
	 * @see org.eclipse.xwt.emf.test.books.Book#getTitle()
	 * @see #getBook()
	 * @generated
	 */
	EReference getBook_Title();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.xwt.emf.test.books.Title <em>Title</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Title</em>'.
	 * @see org.eclipse.xwt.emf.test.books.Title
	 * @generated
	 */
	EClass getTitle();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.xwt.emf.test.books.Title#getLan <em>Lan</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Lan</em>'.
	 * @see org.eclipse.xwt.emf.test.books.Title#getLan()
	 * @see #getTitle()
	 * @generated
	 */
	EAttribute getTitle_Lan();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.xwt.emf.test.books.Title#getText <em>Text</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.xwt.emf.test.books.Title#getText()
	 * @see #getTitle()
	 * @generated
	 */
	EAttribute getTitle_Text();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.xwt.emf.test.books.Book#getAuthor <em>Author</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see org.eclipse.xwt.emf.test.books.Book#getAuthor()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Author();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.xwt.emf.test.books.Book#getPrice <em>Price</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Price</em>'.
	 * @see org.eclipse.xwt.emf.test.books.Book#getPrice()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Price();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.xwt.emf.test.books.Book#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see org.eclipse.xwt.emf.test.books.Book#getYear()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Year();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BooksFactory getBooksFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.xwt.emf.test.books.impl.BookstoreImpl
		 * <em>Bookstore</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.xwt.emf.test.books.impl.BookstoreImpl
		 * @see org.eclipse.xwt.emf.test.books.impl.BooksPackageImpl#getBookstore()
		 * @generated
		 */
		EClass BOOKSTORE = eINSTANCE.getBookstore();

		/**
		 * The meta object literal for the '<em><b>Books</b></em>' containment
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BOOKSTORE__BOOKS = eINSTANCE.getBookstore_Books();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.xwt.emf.test.books.impl.BookImpl <em>Book</em>}
		 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.xwt.emf.test.books.impl.BookImpl
		 * @see org.eclipse.xwt.emf.test.books.impl.BooksPackageImpl#getBook()
		 * @generated
		 */
		EClass BOOK = eINSTANCE.getBook();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' containment
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BOOK__TITLE = eINSTANCE.getBook_Title();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.xwt.emf.test.books.impl.TitleImpl
		 * <em>Title</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.xwt.emf.test.books.impl.TitleImpl
		 * @see org.eclipse.xwt.emf.test.books.impl.BooksPackageImpl#getTitle()
		 * @generated
		 */
		EClass TITLE = eINSTANCE.getTitle();

		/**
		 * The meta object literal for the '<em><b>Lan</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TITLE__LAN = eINSTANCE.getTitle_Lan();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TITLE__TEXT = eINSTANCE.getTitle_Text();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOOK__AUTHOR = eINSTANCE.getBook_Author();

		/**
		 * The meta object literal for the '<em><b>Price</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOOK__PRICE = eINSTANCE.getBook_Price();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOOK__YEAR = eINSTANCE.getBook_Year();

	}

} // BooksPackage
