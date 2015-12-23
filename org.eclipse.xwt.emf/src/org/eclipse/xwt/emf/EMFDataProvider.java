/*******************************************************************************
 * Copyright (c) 2006, 2013 Eclipse XWT Project.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *     Erdal Karaca - bugs fixes, enhancements
 *******************************************************************************/
package org.eclipse.xwt.emf;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.core.internal.databinding.observable.masterdetail.DetailObservableValue;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.EObjectObservableValue;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.XWTException;
import org.eclipse.xwt.dataproviders.AbstractDataProvider;
import org.eclipse.xwt.internal.core.UpdateSourceTrigger;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class EMFDataProvider extends AbstractDataProvider {
	private DataModelService dataModelService;

	private URI typeURI;
	private URI objectURI;

	private ResourceSet resourceSet;

	private String featureName;
	private Object objectInstance;

	public EMFDataProvider(DataModelService dataModelService) {
		this.dataModelService = dataModelService;
	}

	public EMFDataProvider() {
	}

	@Override
	protected IObservableValue observeDetailValue(IObservableValue bean,
			Object ownerType, String propertyName, Object propertyType) {
		EClass type = null;
		if (ownerType instanceof EClass) {
			type = (EClass) ownerType;
		} else if (ownerType instanceof Class<?>) {
			type = (EClass) getModelService().loadModelType(
					((Class<?>) ownerType).getName());
		}

		if (type == null) {
			type = (EClass) getModelService().toModelType(bean);
		}
		EStructuralFeature feature = EMFHelper.findFeature(type, propertyName);
		if (feature == null) {
			throw new XWTException(propertyName + " feature is not found in "
					+ EMFHelper.getQualifiedName(type));
		}
		return EMFObservables
				.observeDetailValue(bean.getRealm(), bean, feature);
	}

	@Override
	protected IObservableValue observeValue(Object bean, String propertyName) {
		EClass type = (EClass) getModelService().toModelType(bean);
		EStructuralFeature feature = EMFHelper.findFeature(type, propertyName);
		if (feature == null) {
			throw new XWTException(propertyName + " feature is not found in "
					+ EMFHelper.getQualifiedName(type));
		}
		return XWTEMFObservables.observeValue(XWT.getRealm(), (EObject) bean,
				feature);
	}

	@Override
	protected IObservableList observeDetailList(IObservableValue bean,
			Object elementType, String propertyName, Object propertyType) {
		EClass type = (EClass) elementType;
		EStructuralFeature feature = EMFHelper.findFeature(type, propertyName);
		IObservableList observeDetailList = EMFObservables.observeDetailList(
				XWT.getRealm(), bean, feature);
		return observeDetailList;
	}

	@Override
	protected IObservableSet observeDetailSet(IObservableValue bean,
			Object elementType, String propertyName, Object propertyType) {
		// TODO
		throw new UnsupportedOperationException("not yet implemented");
	}

	@Override
	protected IObservableList observeList(Object bean, String propertyName) {
		if (bean instanceof EObject) {
			EObject owner = (EObject) bean;
			EStructuralFeature feature = EMFHelper.findFeature(owner.eClass(), propertyName);
			if (feature != null) {
				return EMFObservables.observeList(XWT.getRealm(), owner,
						feature);
			}
		}
		return null;
	}

	@Override
	protected IObservableSet observeSet(Object bean, String propertyName) {
		// TODO
		throw new UnsupportedOperationException("not yet implemented");
	}

	public IValueProperty observeValueProperty(Object valueType, String path,
			UpdateSourceTrigger updateSourceTrigger) {
		EClass type = null;
		if (valueType instanceof EClass) {
			type = (EClass) valueType;
		} else if (valueType instanceof EObject) {
			EObject object = (EObject) valueType;
			type = object.eClass();
		} else {
			throw new IllegalStateException();
		}
		EStructuralFeature feature = EMFHelper.findFeature(type, path);
		if (feature == null) {
			throw new XWTException(path + " feature is not found in "
					+ EMFHelper.getQualifiedName(type));
		}
		return EMFProperties.value(feature);
	}

	public URI getObjectURI() {
		return objectURI;
	}

	public void setObjectURI(URI objectURI) {
		this.objectURI = objectURI;
	}

	public URI getTypeURI() {
		return typeURI;
	}

	public void setTypeURI(URI typeURI) {
		this.typeURI = typeURI;
	}

	public Object getObjectInstance() {
		if (objectInstance == null) {
			if (objectURI != null) {
				objectInstance = getResourceSet().getEObject(objectURI, true);
			} else if (typeURI != null) {
				EClass eClass = (EClass) getResourceSet().getEObject(typeURI,
						true);
				objectInstance = eClass.getEPackage().getEFactoryInstance()
						.create(eClass);
			}
		}
		return objectInstance;
	}

	protected ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

	protected void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	public void setObjectInstance(Object eObject) {
		this.objectInstance = eObject;
	}

	public Object getTarget() {
		Object instance = getObjectInstance();
		if (instance instanceof EObject) {
			EObject eObj = (EObject) instance;
			if (eObj != null && featureName != null) {
				return EMFBinding.getEObject(eObj, featureName);
			}
			return eObj;
		}
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.IDataProvider#getData(java.lang.String)
	 */
	public Object getData(String path) {
		Object instance = getTarget();
		if (!(instance instanceof EObject)) {
			if (path == null || path.length() == 0 || path.equals(".")) {
				return instance;
			}
			throw new IllegalStateException();
		}
		EObject eObj = (EObject) instance;
		if (path == null || ".".equals(path)) {
			return eObj;
		}
		if (eObj != null) {
			String featureName = path;
			int index = path.lastIndexOf(".");
			if (index != -1) {
				String parent = path.substring(0, index);
				eObj = (EObject) getData(eObj, parent);
				featureName = path.substring(index + 1);
			}
			EStructuralFeature feature = EMFHelper.findFeature(eObj.eClass(), featureName);
			if (feature != null) {
				return eObj.eGet(feature);
			}
		}
		return null;
	}

	public boolean isPropertyReadOnly(String path) {
		EClassifier classifier = getCurrentType();
		if (classifier instanceof EClass && path != null) {
			EStructuralFeature feature = EMFHelper.findFeature((EClass)classifier, path);
			if (feature != null) {
				return !feature.isChangeable();
			}
		}
		return true;
	}

	protected EClassifier getCurrentType() {
		Object instance = getTarget();
		EClassifier eObj = null;
		if (instance instanceof EObjectObservableValue) {
			EObjectObservableValue observableValue = (EObjectObservableValue) instance;
			EStructuralFeature valueType = (EStructuralFeature) observableValue
					.getValueType();
			EClassifier classifier = valueType.getEType();
			if (classifier instanceof EClass || classifier instanceof EDataType) {
				eObj = classifier;
			} else {
				return null;
			}
		} else if (instance instanceof EClass) {
			eObj = (EClass) instance;
		} else if (instance instanceof EObject) {
			EObject object = (EObject) instance;
			eObj = object.eClass();
		} else if (instance instanceof DetailObservableValue) {
			EObject eObject = (EObject) ((DetailObservableValue) instance)
					.getValueType();
			eObj = eObject.eClass();
		} else {
			if (typeURI != null) {
				EObject element = getResourceSet().getEObject(typeURI, true);
				if (element instanceof EClass) {
					eObj = (EClass) element;
				}
			}
		}
		if (eObj == null) {
			throw new IllegalStateException();
		}

		return eObj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.IDataProvider#getDataType(java.lang.String)
	 */
	public Object getDataType(String path) {
		EClassifier classifier = getCurrentType();
		if (path == null || path.trim().length() == 0 || path.equals(".")) {
			if (classifier instanceof EDataType) {
				return classifier.getInstanceClass();
			}
			return classifier;
		}
		if (classifier instanceof EClass) {
			String featureName = path;
			EStructuralFeature feature = EMFHelper.findFeature((EClass)classifier, featureName);
			if (feature != null) {
				return feature.getEType();
			}
		}

		return classifier;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public String getFeatureName() {
		return featureName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.IDataProvider#getData(java.lang.Object,
	 * java.lang.String)
	 */
	public Object getData(Object target, String path) {
		if (target instanceof EObject) {
			if (path == null || ".".equals(path)) {
				return target;
			}
			return EMFBinding.getEObject((EObject) target, path);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.IDataProvider#setData(java.lang.String,
	 * java.lang.Object)
	 */
	public void setData(String path, Object value) {
		setData(getTarget(), path, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.IDataProvider#setData(java.lang.Object,
	 * java.lang.String, java.lang.Object)
	 */
	public void setData(Object target, String path, Object value) {
		if (target instanceof EObject) {
			EObject eObj = (EObject) target;
			String featureName = path;
			int index = path.lastIndexOf(".");
			if (index != -1) {
				String parent = path.substring(0, index);
				eObj = EMFBinding.getEObject(eObj, parent);
				featureName = path.substring(index + 1);
			}
			EStructuralFeature feature = EMFHelper.findFeature(eObj.eClass(), featureName);
			if (feature != null) {
				eObj.eSet(feature, value);
			}
		}
	}

	protected DataModelService createDataModelService() {
		return new EMFDataModelService();
	}

	public DataModelService getModelService() {
		if (dataModelService == null) {
			dataModelService = createDataModelService();
		}
		return dataModelService;
	}

	public IValueProperty createValueProperty(Object type, String fullPath) {
		if (type == null || fullPath == null) {
			return null;
		}
		EClass eClass = null;
		if (type instanceof EReference) {
			EReference ref = (EReference) type;
			eClass = ref.getEReferenceType();
		} else if (type instanceof EClass) {
			eClass = (EClass) type;
		} else if (type instanceof EObject) {
			eClass = ((EObject) type).eClass();
		}

		if (eClass == null) {
			return null;
		}
		EStructuralFeature feature = EMFHelper.findFeature(eClass, fullPath);
		if (feature != null) {
			return EMFProperties.value(feature);
		}
		return null;
	}
}
