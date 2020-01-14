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
package org.eclipse.xwt.tests.databinding.dataprovider.custom;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.xwt.XWTException;
import org.eclipse.xwt.databinding.XWTObservableValue;
import org.eclipse.xwt.dataproviders.AbstractDataProvider;
import org.eclipse.xwt.internal.core.UpdateSourceTrigger;

/**
 * An sample a custom data provider
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class CustomDataProvider extends AbstractDataProvider {
	static DataModelService dataModelService = new DataModelService() {
		@Override
		public Object toModelType(Object data) {
			return null;
		}

		@Override
		public Object loadModelType(String className) {
			return null;
		}

		@Override
		public Object toModelPropertyType(Object object, String propertyName) {
			return null;
		}
	};

	protected Class<?> objectType;
	protected DynamicObject object;

	@Override
	public Object getData(String path) {
		if (path == null) {
			return this;
		}
		return getData(getObjectInstance(), path);
	}

	@Override
	public Object getData(Object object, String path) {
		assert object instanceof DynamicObject;
		return ((DynamicObject) object).getProperty(path);
	}

	@Override
	public void setData(String path, Object value) {
		setData(getObjectInstance(), path, value);
	}

	@Override
	public void setData(Object object, String path, Object value) {
		assert object instanceof DynamicObject;
		((DynamicObject) object).setProperty(path, value);
	}

	public IValueProperty observeValueProperty(Object valueType, String path,
			UpdateSourceTrigger updateSourceTrigger) {
		return new MyValueProperty();
	}

	@Override
	public IObservableValue observeValue(Object bean,
			final String propertyName) {
		Object target = getObjectInstance();
		if (target != null) {
			return new XWTObservableValue(target.getClass(), target,
					propertyName) {
				@Override
				protected void doSetApprovedValue(Object value) {
					CustomDataProvider.this.getObjectInstance().setProperty(
							propertyName, value);
				}

				@Override
				protected Object doGetValue() {
					return CustomDataProvider.this.getData(propertyName);
				}
			};
		}
		return null;
	}

	@Override
	public IObservableValue observeDetailValue(IObservableValue bean,
			Object ownerType, String propertyName, Object propertyType) {
		return null;
	}

	@Override
	public Class<?> getDataType(String path) {
		return String.class;
	}

	public void setObjectType(Class<?> objectType) {
		this.objectType = objectType;
	}

	public Class<?> getObjectType() {
		return objectType;
	}

	public void setObjectInstance(DynamicObject objectInstance) {
		object = objectInstance;
	}

	public DynamicObject getObjectInstance() {
		if (object == null && objectType != null) {
			try {
				object = (DynamicObject) objectType.newInstance();
			} catch (Exception e) {
				throw new XWTException(e);
			}
		}
		return object;
	}

	@Override
	public DataModelService getModelService() {
		return dataModelService;
	}
}
