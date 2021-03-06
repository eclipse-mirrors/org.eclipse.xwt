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
package org.eclipse.xwt.animation;

import org.eclipse.xwt.XWT;
import org.eclipse.xwt.XWTException;
import org.eclipse.xwt.animation.internal.ITimeline;
import org.eclipse.xwt.animation.internal.PathPropertyAccessor;
import org.eclipse.xwt.internal.utils.UserData;
import org.eclipse.xwt.metadata.IMetaclass;
import org.eclipse.xwt.metadata.IProperty;

public abstract class AnimationTimeline extends Timeline {
	private boolean isDestinationDefault;
	private String targetName;
	private String targetProperty;

	private Object initValue;
	private Object cacheValue;

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public String getTargetProperty() {
		return targetProperty;
	}

	public void setTargetProperty(String targetProperty) {
		this.targetProperty = targetProperty;
	}

	/**
	 * Getter of the property <tt>IsDestinationDefault</tt>
	 * 
	 * @return Returns the isDestinationDefault.
	 * @uml.property name="IsDestinationDefault"
	 */
	public boolean getIsDestinationDefault() {
		return isDestinationDefault;
	}

	/**
	 * Setter of the property <tt>IsDestinationDefault</tt>
	 * 
	 * @param IsDestinationDefaultProperty
	 *            The isDestinationDefault to set.
	 * @uml.property name="IsDestinationDefault"
	 */
	public void setIsDestinationDefault(boolean isDestinationDefault) {
		this.isDestinationDefault = isDestinationDefault;
	}

	protected void setCacheValue(Object cacheValue) {
		this.cacheValue = cacheValue;
	}

	protected Object getCacheValue() {
		return cacheValue;
	}

	protected Object getInitValue() {
		return initValue;
	}

	protected void initialize(Object target) {
		initValue = getCurrentValue(target);
		cacheValue = initValue;
	}
	
	protected void endFinalize(Object target) {
		if (getFillBehavior() == FillBehavior.Stop) {
			Object element = findTarget(target);
			IMetaclass metaclass = XWT.getMetaclass(element);
			IProperty property = metaclass.findProperty(getTargetProperty());
			if (property == null) {
				throw new XWTException("Property \"" + getTargetProperty()
						+ "\" is not found in " + metaclass.getType().getName());
			}
			try {
				property.setValue(element, initValue);
			} catch (Exception e) {
				throw new XWTException(e);
			}
		}
	}
	
	protected Object getCurrentValue(Object target) {
		Object element = findTarget(target);
		IMetaclass metaclass = XWT.getMetaclass(element);
		
		String targetProperty = getTargetProperty();
		int index = targetProperty.lastIndexOf('.');
		if (index != -1) {
			String lastNodePath = targetProperty.substring(0, index);
			String lastNodeName = targetProperty.substring(index + 1);
			PathPropertyAccessor<?> accessor = new PathPropertyAccessor(lastNodePath);
			return accessor.get(element, lastNodeName);
		}
		else {
			IProperty property = metaclass.findProperty(getTargetProperty());
			if (property == null) {
				throw new XWTException("Property \"" + getTargetProperty()
						+ "\" is not found in " + metaclass.getType().getName());
			}
			try {
				return property.getValue(element);
			} catch (Exception e) {
				throw new XWTException(e);
			}			
		}
	}

	@Override
	protected Object findTarget(Object target) {
		String targetName = getTargetName();
		if (targetName == null) {
			return target;
		}
		Object newTarget = UserData.findElementByName(target, targetName);
		if (newTarget == null) {
			throw new XWTException("Name element " + targetName
					+ " is not found in animation.");
		}
		return super.findTarget(newTarget);
	}

	protected void update(ITimeline timeline) {
	}
}
