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
package org.eclipse.xwt.internal.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.ILoadingContext;
import org.eclipse.xwt.IMetaclassFactory;
import org.eclipse.xwt.IXWTLoader;
import org.eclipse.xwt.XWTException;
import org.eclipse.xwt.internal.utils.ClassLoaderUtil;
import org.eclipse.xwt.javabean.metadata.Metaclass;
import org.eclipse.xwt.metadata.IMetaclass;

/**
 * @author yyang (yves.yang@soyatec.com)
 */
public class MetaclassManager {
	protected Map<String, IMetaclass> nameRegister = new HashMap<String, IMetaclass>();
	protected Collection<Class<?>> classRegister = new HashSet<Class<?>>();
	protected MetaclassManager parent;
	protected MetaclassService service;

	private IXWTLoader xwtLoader;

	public MetaclassManager(MetaclassService service, MetaclassManager parent,
			IXWTLoader xwtLoader) {
		this.parent = parent;
		this.service = service;
		this.xwtLoader = xwtLoader;
	}

	public Collection<IMetaclass> getAllMetaclasses() {
		return nameRegister.values();
	}

	public void register(IMetaclass metaclass) {
		Class<?> type = metaclass.getType();
		if (classRegister.contains(type)) {
			return;
		}
		String key = type.getSimpleName();
		nameRegister.put(key, metaclass);
		classRegister.add(type);
	}

	public IMetaclass register(Class<?> javaClass) {
		return register(javaClass, null);
	}

	public IMetaclass register(Class<?> javaClass, IMetaclass superMetaclass) {
		IMetaclass metaclass = getMetaclass(javaClass);
		if (metaclass != null) {
			return metaclass;
		}
		if (superMetaclass == null) {
			Class<?> superclass = javaClass.getSuperclass();
			if (superclass != null && superclass != Object.class) {
				register(superclass, null);
			}
			superMetaclass = getMetaclass(superclass);
		}
		IMetaclass thisMetaclass = createMetaclass(javaClass, superMetaclass);
		register(thisMetaclass);
		return thisMetaclass;
	}

	protected IMetaclass createMetaclass(Class<?> javaClass,
			IMetaclass superMetaclass) {
		if (service != null) {
			IMetaclassFactory factory = service.findFactory(javaClass);
			if (factory != null) {
				return factory.create(javaClass, superMetaclass, xwtLoader);
			}
		}
		boolean lazyLoading = false; // TODO Get value from preference
		return new Metaclass(javaClass, superMetaclass, lazyLoading, xwtLoader);
	}

	public IMetaclass getMetaclass(ILoadingContext context, String name,
			String namespace) {
		IMetaclass metaclass = nameRegister.get(name);
		if (metaclass != null) {
			if (namespace == null || namespace.equals(IConstants.XWT_NAMESPACE)) {
				return metaclass;
			}
			if (namespace != null
					&& namespace
							.startsWith(IConstants.XAML_CLR_NAMESPACE_PROTO)) {
				String packageName = namespace
						.substring(IConstants.XAML_CLR_NAMESPACE_PROTO.length());
				int index = packageName.indexOf('=');
				if (index != -1) {
					packageName = packageName.substring(0, index);
				}
				// if using default package(null), use only name as class name,
				// else use package.class as class name
				String className = packageName.length() == 0 ? name
						: (packageName + "." + name);
				if (metaclass.getType().getName().equals(className)) {
					return metaclass;
				}
			}
		}
		if (namespace == null
				|| !namespace.startsWith(IConstants.XAML_CLR_NAMESPACE_PROTO)) {
			return null;
		}
		String packageName = namespace
				.substring(IConstants.XAML_CLR_NAMESPACE_PROTO.length());
		int index = packageName.indexOf('=');
		if (index != -1) {
			packageName = packageName.substring(0, index);
		}
		// if using default package(null), use only name as class name, else use
		// package.class as class name
		String className = packageName.length() == 0 ? name : (packageName
				+ "." + name);
		// try {
		Class<?> type = ClassLoaderUtil.loadClass(context, className);
		if (type == null) {
			throw new XWTException("Cannot load " + className);
		}
		metaclass = register(type, null);
		// There is no need to mapping a CLR class, since the ClassLoader will
		// be changed.
		nameRegister.remove(type.getSimpleName());
		return metaclass;
	}

	public IMetaclass getMetaclass(Object object) {
		if (object instanceof Class) {
			return getMetaclass((Class<?>) object);
		} else if (object instanceof String) {
			return getMetaclass((String) object);
		}
		Class<?> type = object.getClass();
		return getMetaclass(type);
	}

	public IMetaclass getMetaclass(Class<?> type) {
		if (classRegister.contains(type)) {
			IMetaclass metaclass = nameRegister.get(type.getSimpleName());
			if (metaclass != null && metaclass.getType() == type) {
				return metaclass;
			}
		}
		if (parent != null) {
			IMetaclass metaclass = parent.getMetaclass(type);
			if (metaclass != null) {
				return metaclass;
			}
		}
		return null;
	}
}
