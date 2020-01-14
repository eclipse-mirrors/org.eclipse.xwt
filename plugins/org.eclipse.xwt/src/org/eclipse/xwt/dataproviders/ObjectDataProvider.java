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
package org.eclipse.xwt.dataproviders;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.XWTException;
import org.eclipse.xwt.core.IBinding;
import org.eclipse.xwt.databinding.JFaceXWTDataBinding;
import org.eclipse.xwt.metadata.IMetaclass;
import org.eclipse.xwt.metadata.IProperty;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class ObjectDataProvider extends AbstractDataProvider implements
		IObjectDataProvider {
	static DataModelService dataModelService = new DataModelService() {

		@Override
		public Object toModelType(Object object) {
			return JFaceXWTDataBinding.toType(object);
		}

		@Override
		public Object loadModelType(String className) {
			return XWT.getLoadingContext().loadClass(className);
		}

		@Override
		public Object toModelPropertyType(Object type, String propertyName) {
			IMetaclass metaclass = XWT.getMetaclass(type);
			IProperty property = metaclass.findProperty(propertyName);

			if (property == null) {
				throw new XWTException(" Property \"" + propertyName
						+ "\" is not found in the class "
						+ metaclass.getType().getName());
			}
			return property.getType();
		}
	};

	private Object objectInstance;
	private Class<?> objectType;

	private String methodName;

	private List<Object> methodParameters;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.dataproviders.IObjectDataProvider#getMethodName()
	 */
	@Override
	public String getMethodName() {
		return methodName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xwt.dataproviders.IObjectDataProvider#getMethodParameters
	 * ()
	 */
	@Override
	public List<Object> getMethodParameters() {
		return methodParameters;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xwt.dataproviders.IObjectDataProvider#getObjectInstance()
	 */
	@Override
	public Object getObjectInstance() {
		if (objectInstance == null && objectType != null) {
			try {
				objectInstance = objectType.newInstance();
			} catch (Exception e) {
				throw new XWTException(e);
			}
		}
		return objectInstance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.dataproviders.IObjectDataProvider#getObjectType()
	 */
	@Override
	public Class<?> getObjectType() {
		if (objectType == null && objectInstance != null) {
			objectType = objectInstance.getClass();
		}
		return objectType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xwt.dataproviders.IObjectDataProvider#setMethodName(java
	 * .lang.String)
	 */
	@Override
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xwt.dataproviders.IObjectDataProvider#setMethodParameters
	 * (java.util.List)
	 */
	@Override
	public void setMethodParameters(List<Object> parameters) {
		this.methodParameters = parameters;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xwt.dataproviders.IObjectDataProvider#setObjectInstance
	 * (java.lang.Object)
	 */
	@Override
	public void setObjectInstance(Object objectImstance) {
		this.objectInstance = objectImstance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xwt.dataproviders.IObjectDataProvider#setObjectType(java
	 * .lang.Class)
	 */
	@Override
	public void setObjectType(Class<?> objectType) {
		this.objectType = objectType;
	}

	protected Object getTarget() {
		Object target = getObjectInstance();
		if (target == null) {
			return null;
		}
		Class<?> targetType = getObjectType();
		Method method = null;
		if (methodName != null) {
			List<Class<?>> paras = new ArrayList<>();
			if (methodParameters != null) {
				for (Object p : methodParameters) {
					paras.add(p.getClass());
				}
			}
			try {
				if (paras.isEmpty()) {
					method = targetType.getDeclaredMethod(methodName);
					return method.invoke(target);
				} else {
					method = targetType.getDeclaredMethod(methodName, paras
							.toArray(new Class<?>[paras.size()]));
					return method.invoke(target, methodParameters
							.toArray(new Object[methodParameters.size()]));
				}
			} catch (SecurityException e) {
			} catch (IllegalArgumentException e) {
			} catch (NoSuchMethodException e) {
			} catch (IllegalAccessException e) {
			} catch (InvocationTargetException e) {
			}
		}
		return target;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xwt.dataproviders.IDataProvider#getData(java.lang.String)
	 */
	@Override
	public Object getData(String path) {
		if (path == null) {
			return getTarget();
		}
		return getData(getTarget(), path);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xwt.dataproviders.IDataProvider#getData(java.lang.String)
	 */
	@Override
	public Object getData(Object object, String path) {
		if (object instanceof IObservableValue) {
			object = ((IObservableValue) object).getValue();
		}
		if (path == null || path.trim().length() == 0 || path.equals(".")) {
			return JFaceXWTDataBinding.getValue(object, null);
		}
		int index = path.indexOf(".");
		while (index != -1 && object != null) {
			object = JFaceXWTDataBinding.getValue(object, path.substring(0,
					index));
			path = path.substring(index + 1);
			index = path.indexOf(".");
		}
		return JFaceXWTDataBinding.getValue(object, path);
	}

	@Override
	public void setData(Object object, String path, Object value) {
		if (object instanceof IObservableValue) {
			object = ((IObservableValue) object).getValue();
		}
		int index = path.indexOf(".");
		while (index != -1 && object != null) {
			object = JFaceXWTDataBinding.getValue(object, path.substring(0,
					index));
			path = path.substring(index + 1);
			index = path.indexOf(".");
		}
		JFaceXWTDataBinding.setValue(object, path, value);
	}

	@Override
	public void setData(String path, Object value) {
		setData(getTarget(), path, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xwt.dataproviders.IDataProvider#getDataType(java.lang.
	 * String)
	 */
	@Override
	public Class<?> getDataType(String path) {
		Object target = getTarget();
		if (target == null) {
			return null;
		}
		Class<?> type = JFaceXWTDataBinding.toType(target);
		if (path == null) {
			return type;
		}
		return JFaceXWTDataBinding.getValueType(type, path);
	}

	/**
	 * check if the property is read only
	 * 
	 * @param path
	 * @return
	 */
	@Override
	public boolean isPropertyReadOnly(String path) {
		Object target = getTarget();
		if (target == null || path == null) {
			return true;
		}
		if (target instanceof IBinding) {
			target = ((IBinding) target).getValue(null);
		}
		Class<?> type = JFaceXWTDataBinding.toType(target);
		int index = path.indexOf(".");
		while (index != -1 && target != null) {
			type = JFaceXWTDataBinding.getValueType(type, path.substring(0,
					index));
			path = path.substring(index + 1);
			index = path.indexOf(".");
		}
		return JFaceXWTDataBinding.isPropertyReadOnly(type, path);
	}

	@Override
	protected IObservableValue observeValue(Object bean, String propertyName) {
		if (JFaceXWTDataBinding.isBeanSupport(bean)) {
			return BeansObservables.observeValue(XWT.getRealm(), bean,
					propertyName);
		}
		return PojoObservables.observeValue(XWT.getRealm(), bean, propertyName);
	}

	@Override
	protected IObservableList observeList(Object bean, String propertyName) {
		if (JFaceXWTDataBinding.isBeanSupport(bean)) {
			return BeansObservables.observeList(XWT.getRealm(), bean,
					propertyName);
		}
		return PojoObservables.observeList(XWT.getRealm(), bean, propertyName);
	}

	@Override
	protected IObservableSet observeSet(Object bean, String propertyName) {
		if (JFaceXWTDataBinding.isBeanSupport(bean)) {
			return BeansObservables.observeSet(XWT.getRealm(), bean,
					propertyName);
		}
		return PojoObservables.observeSet(XWT.getRealm(), bean, propertyName);
	}

	@Override
	protected IObservableList observeDetailList(IObservableValue bean,
			Object elementType, String propertyName, Object propertyType) {
		if (JFaceXWTDataBinding.isBeanSupport(bean)) {
			return BeansObservables.observeDetailList(bean, propertyName,
					(Class<?>) propertyType);
		}
		return PojoObservables.observeDetailList(bean, propertyName,
				(Class<?>) propertyType);
	}

	@Override
	protected IObservableSet observeDetailSet(IObservableValue bean,
			Object elementType, String propertyName, Object propertyType) {
		if (JFaceXWTDataBinding.isBeanSupport(bean)) {
			return BeansObservables.observeDetailSet(bean, propertyName,
					(Class<?>) propertyType);
		}
		return PojoObservables.observeDetailSet(bean, propertyName,
				(Class<?>) propertyType);
	}

	@Override
	protected IObservableValue observeDetailValue(IObservableValue master,
			Object elementType, String propertyName, Object propertyType) {
		Class<?> beanClass = (Class<?>) elementType;
		if (beanClass == null && master.getValueType() instanceof Class<?>) {
			beanClass = (Class<?>) master.getValueType();
		}
		if (JFaceXWTDataBinding.isBeanSupport(beanClass)) {
			return BeanProperties.value(beanClass, propertyName,
					(Class<?>) propertyType).observeDetail(master);
		}
		return PojoProperties.value(beanClass, propertyName,
				(Class<?>) propertyType).observeDetail(master);
	}

	@Override
	public IValueProperty createValueProperty(Object type, String propertyName) {
		if (JFaceXWTDataBinding.isBeanSupport(type)) {
			return BeanProperties.value(JFaceXWTDataBinding.toType(type),
					propertyName);
		}
		return PojoProperties.value(JFaceXWTDataBinding.toType(type),
				propertyName);
	}

	@Override
	public DataModelService getModelService() {
		return dataModelService;
	}
}
