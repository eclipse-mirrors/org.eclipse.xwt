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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Title</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.xwt.emf.test.books.Title#getLan <em>Lan</em>}</li>
 * <li>{@link org.eclipse.xwt.emf.test.books.Title#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.xwt.emf.test.books.BooksPackage#getTitle()
 * @model
 * @generated
 */
public interface Title extends EObject {
	/**
	 * Returns the value of the '<em><b>Lan</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lan</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Lan</em>' attribute.
	 * @see #setLan(String)
	 * @see org.eclipse.xwt.emf.test.books.BooksPackage#getTitle_Lan()
	 * @model
	 * @generated
	 */
	String getLan();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.xwt.emf.test.books.Title#getLan <em>Lan</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Lan</em>' attribute.
	 * @see #getLan()
	 * @generated
	 */
	void setLan(String value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.eclipse.xwt.emf.test.books.BooksPackage#getTitle_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.xwt.emf.test.books.Title#getText <em>Text</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

} // Title
