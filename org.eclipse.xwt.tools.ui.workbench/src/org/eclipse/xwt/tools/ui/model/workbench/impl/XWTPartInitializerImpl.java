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
package org.eclipse.xwt.tools.ui.model.workbench.impl;

import org.eclipse.xwt.tools.ui.model.workbench.WorkbenchPackage;
import org.eclipse.xwt.tools.ui.model.workbench.XWTPartInitializer;
import org.eclipse.xwt.tools.ui.palette.Entry;
import org.eclipse.xwt.tools.ui.palette.impl.InitializerImpl;
import org.eclipse.xwt.tools.ui.workbench.PartInitializerAction;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>XWT Part Initializer</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.xwt.tools.ui.model.workbench.impl.XWTPartInitializerImpl#getContentForm
 * <em>Content Form</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class XWTPartInitializerImpl extends InitializerImpl implements XWTPartInitializer {
	private PartInitializerAction action;

	/**
	 * The default value of the '{@link #getContentForm() <em>Content Form</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContentForm()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENT_FORM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContentForm() <em>Content Form</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContentForm()
	 * @generated
	 * @ordered
	 */
	protected String contentForm = CONTENT_FORM_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected XWTPartInitializerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkbenchPackage.Literals.XWT_PART_INITIALIZER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getContentForm() {
		return contentForm;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setContentForm(String newContentForm) {
		String oldContentForm = contentForm;
		contentForm = newContentForm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkbenchPackage.XWT_PART_INITIALIZER__CONTENT_FORM, oldContentForm,
					contentForm));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case WorkbenchPackage.XWT_PART_INITIALIZER__CONTENT_FORM:
			return getContentForm();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case WorkbenchPackage.XWT_PART_INITIALIZER__CONTENT_FORM:
			setContentForm((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case WorkbenchPackage.XWT_PART_INITIALIZER__CONTENT_FORM:
			setContentForm(CONTENT_FORM_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case WorkbenchPackage.XWT_PART_INITIALIZER__CONTENT_FORM:
			return CONTENT_FORM_EDEFAULT == null ? contentForm != null : !CONTENT_FORM_EDEFAULT
					.equals(contentForm);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (contentForm: ");
		result.append(contentForm);
		result.append(')');
		return result.toString();
	}

	public boolean initialize(Object element) {
		if (action == null) {
			action = new PartInitializerAction(loadClass());
		}
		return action.run(element);
	}

	protected Class<?> loadClass() {
		try {
			String contentForm = getContentForm();
			return getClass().getClassLoader().loadClass(contentForm);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xwt.tools.ui.palette.impl.InitializerImpl#parse(org.eclipse
	 * .e4.xwt.tools.ui.palette.Entry)
	 */
	@Override
	public Object parse(Entry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xwt.tools.ui.palette.impl.InitializerImpl#initialize(org
	 * .eclipse.e4.xwt.tools.ui.palette.Entry, java.lang.Object)
	 */
	@Override
	public boolean initialize(Entry entry, Object newObject) {
		// TODO Auto-generated method stub
		return false;
	}

} // XWTPartInitializerImpl
