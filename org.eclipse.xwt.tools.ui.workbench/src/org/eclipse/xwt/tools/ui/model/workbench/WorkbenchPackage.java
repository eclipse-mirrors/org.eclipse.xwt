/*******************************************************************************
 * Copyright (c) 2006, 2009 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tools.ui.model.workbench;

import org.eclipse.xwt.tools.ui.palette.PalettePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.xwt.tools.ui.model.workbench.WorkbenchFactory
 * @model kind="package"
 * @generated
 */
public interface WorkbenchPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "workbench";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/e4/xwt/workbench/desiger";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "wb";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WorkbenchPackage eINSTANCE = org.eclipse.xwt.tools.ui.model.workbench.impl.WorkbenchPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xwt.tools.ui.model.workbench.impl.XWTPartInitializerImpl <em>XWT Part Initializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xwt.tools.ui.model.workbench.impl.XWTPartInitializerImpl
	 * @see org.eclipse.xwt.tools.ui.model.workbench.impl.WorkbenchPackageImpl#getXWTPartInitializer()
	 * @generated
	 */
	int XWT_PART_INITIALIZER = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XWT_PART_INITIALIZER__ID = PalettePackage.INITIALIZER__ID;

	/**
	 * The feature id for the '<em><b>Content Form</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XWT_PART_INITIALIZER__CONTENT_FORM = PalettePackage.INITIALIZER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XWT Part Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XWT_PART_INITIALIZER_FEATURE_COUNT = PalettePackage.INITIALIZER_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.eclipse.xwt.tools.ui.model.workbench.XWTPartInitializer <em>XWT Part Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XWT Part Initializer</em>'.
	 * @see org.eclipse.xwt.tools.ui.model.workbench.XWTPartInitializer
	 * @generated
	 */
	EClass getXWTPartInitializer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xwt.tools.ui.model.workbench.XWTPartInitializer#getContentForm <em>Content Form</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content Form</em>'.
	 * @see org.eclipse.xwt.tools.ui.model.workbench.XWTPartInitializer#getContentForm()
	 * @see #getXWTPartInitializer()
	 * @generated
	 */
	EAttribute getXWTPartInitializer_ContentForm();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WorkbenchFactory getWorkbenchFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.xwt.tools.ui.model.workbench.impl.XWTPartInitializerImpl <em>XWT Part Initializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xwt.tools.ui.model.workbench.impl.XWTPartInitializerImpl
		 * @see org.eclipse.xwt.tools.ui.model.workbench.impl.WorkbenchPackageImpl#getXWTPartInitializer()
		 * @generated
		 */
		EClass XWT_PART_INITIALIZER = eINSTANCE.getXWTPartInitializer();

		/**
		 * The meta object literal for the '<em><b>Content Form</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XWT_PART_INITIALIZER__CONTENT_FORM = eINSTANCE.getXWTPartInitializer_ContentForm();

	}

} //WorkbenchPackage
