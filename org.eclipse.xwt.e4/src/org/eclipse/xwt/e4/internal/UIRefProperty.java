/*******************************************************************************
 * Copyright (c) 2013 Eclipse XWT Project.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Erdal Karaca - initial API and implementation
 ******************************************************************************/
package org.eclipse.xwt.e4.internal;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xwt.e4.E4XWTUI;
import org.eclipse.xwt.javabean.metadata.properties.AbstractProperty;
import org.eclipse.xwt.metadata.DefaultLoadingType;
import org.eclipse.xwt.metadata.IProperty;
import org.eclipse.xwt.metadata.IValueLoading;

public class UIRefProperty extends AbstractProperty {
	public UIRefProperty() {
		super("UiRef", Class.class, new DefaultLoadingType(
				IValueLoading.PostChildren, new IProperty[0]));
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setValue(Object target, Object value)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SecurityException, NoSuchFieldException {
		IEclipseContext context = E4XWTUI.findData(IEclipseContext.class,
				target);
		Class<? extends E4XWTUI> uiClass = (Class<? extends E4XWTUI>) value;

		IEclipseContext localContext = context.createChild(uiClass.getName());
		localContext.set(Composite.class, (Composite) target);
		ContextInjectionFactory.make(uiClass, context, localContext);
	}

	@Override
	public Object getValue(Object target) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			SecurityException, NoSuchFieldException {
		return null;
	}
}
