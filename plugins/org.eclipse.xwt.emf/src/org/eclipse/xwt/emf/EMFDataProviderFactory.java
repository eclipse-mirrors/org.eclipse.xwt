/*******************************************************************************
 * Copyright (c) 2006, 2013 Eclipse XWT Project.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *     Erdal Karaca - bugs fixes, enhancements
 *******************************************************************************/
package org.eclipse.xwt.emf;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EObjectObservableList;
import org.eclipse.emf.databinding.EObjectObservableMap;
import org.eclipse.emf.databinding.EObjectObservableValue;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xwt.IDataProvider;
import org.eclipse.xwt.IDataProviderFactory;

/**
 * @author yyang (yves.yang@soyatec.com)
 */
public class EMFDataProviderFactory implements IDataProviderFactory {
	public static final String EMF_DATA_PROVIDER_FACTORY = "EMF.DataProvider.Factory";

	public IDataProvider create(Object dataContext) {
		if (dataContext instanceof EObject) {
			EMFDataProvider dataProvider = createEMFDataProvider();
			dataProvider.setObjectInstance(dataContext);
			return dataProvider;
		} else if (dataContext instanceof EClassifier) {
			EClassifier classifier = (EClassifier) dataContext;
			EMFDataProvider dataProvider = createEMFDataProvider();
			dataProvider.setTypeURI(EcoreUtil.getURI(classifier));
			return dataProvider;
		} else if (dataContext instanceof EObjectObservableValue
				|| dataContext instanceof EObjectObservableList
				|| dataContext instanceof EObjectObservableMap) {
			EMFDataProvider dataProvider = createEMFDataProvider();
			dataProvider.setObjectInstance(dataContext);
			return dataProvider;
		} else if (dataContext instanceof Class<?>) {
			Class<?> classType = (Class<?>) dataContext;
			EClassifier classifier = (EClassifier) EMFDataModelService
					.determineModelType(classType);
			EMFDataProvider dataProvider = createEMFDataProvider();
			dataProvider.setTypeURI(EcoreUtil.getURI(classifier));
			return dataProvider;
		} else if (dataContext instanceof IObservableValue) {
			Object valueType = ((IObservableValue) dataContext).getValueType();
			if (valueType instanceof EObject) {
				EMFDataProvider dataProvider = createEMFDataProvider();
				dataProvider.setObjectInstance(dataContext);
				return dataProvider;
			}
		} else if (dataContext instanceof IObservableList) {
			EMFDataProvider dataProvider = createEMFDataProvider();
			dataProvider.setObjectInstance(dataContext);
			return dataProvider;
		}

		return null;
	}

	protected EMFDataProvider createEMFDataProvider() {
		return new EMFDataProvider();
	}

	public Class<?> getType() {
		return EObject.class;
	}
}
