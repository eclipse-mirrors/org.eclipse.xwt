/*******************************************************************************
 * Copyright (c) 2006, 2013 Eclipse XWT Team
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *     Erdal Karaca - heuristic method for determination of model type
 *******************************************************************************/
package org.eclipse.xwt.emf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xwt.IDataProvider.DataModelService;
import org.eclipse.xwt.XWTException;

public class EMFDataModelService implements DataModelService {
	private static Map<Object, EClassifier> lookupTable = Collections
			.synchronizedMap(new HashMap<Object, EClassifier>());

	public Object toModelType(Object data) {
		return EMFHelper.toType(data);
	}

	public Object loadModelType(String className) {
		return determineModelType(className);
	}

	public static Object determineModelType(String className) {
		EClassifier ret = lookupTable.get(className);

		if (ret != null) {
			return ret;
		}

		Registry reg = EPackage.Registry.INSTANCE;
		List<String> paks = new ArrayList<String>(reg.keySet());

		for (String uri : paks) {
			EPackage pak = reg.getEPackage(uri);

			for (EClassifier ec : pak.getEClassifiers()) {
				boolean found = ec.getInstanceClass().getName()
						.equals(className);
				if (found) {
					lookupTable.put(className, ec);
					return ec;
				}
			}
		}

		return null;
	}

	public static Object determineModelType(Class<?> clazz) {
		EClassifier ret = lookupTable.get(clazz);

		if (ret != null) {
			return ret;
		}

		Registry reg = EPackage.Registry.INSTANCE;
		List<String> paks = new ArrayList<String>(reg.keySet());

		for (String uri : paks) {
			EPackage pak = reg.getEPackage(uri);

			for (EClassifier ec : pak.getEClassifiers()) {
				boolean found = ec.getInstanceClass() == clazz;
				if (found) {
					lookupTable.put(clazz, ec);
					return ec;
				}
			}
		}

		return null;
	}

	public Object toModelPropertyType(Object object, String propertyName) {
		EClass type = null;
		if (object instanceof EClass) {
			type = (EClass) object;
		} else if (object instanceof EObject) {
			type = ((EObject) object).eClass();
		} else if (object instanceof Class<?>) {
			type = (EClass) determineModelType((Class<?>) object);
		}

		if (type == null) {
			throw new XWTException(" Type for\"" + propertyName
					+ "\" is not found ");
		}
		EStructuralFeature structuralFeature = type
				.getEStructuralFeature(propertyName);

		if (structuralFeature == null) {
			throw new XWTException(" Property \"" + propertyName
					+ "\" is not found in the class " + type.getName());
		}
		if (((EStructuralFeature.Internal) structuralFeature).isFeatureMap()) {
			return Map.class;
		} else if (structuralFeature.isMany()) {
			return Collection.class;
		} else {
			return structuralFeature.getEType();
		}
	}
}