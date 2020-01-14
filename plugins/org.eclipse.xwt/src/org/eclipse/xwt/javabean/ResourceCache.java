/*****************************************************************************
 * Copyright (c) 2017 EclipseSource and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  EclipseSource - Initial API and implementation: Bug 521931
 *
 *****************************************************************************/
package org.eclipse.xwt.javabean;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.xwt.metadata.IMetaclass;

/**
 * <p>
 * Default implementation of {@link IResourceCache}. This implementation stores
 * the URL for each resource. The mapping is based on the
 * {@link IMetaclass#getType() metaclass' type}, i.e. if two instances of
 * {@link IMetaclass} have the same type (according to
 * {@link Class#equals(Object)}), they will share the same cache.
 * </p>
 * <p>
 * Cached URLs may be null (Typically when the resource doesn't exist).
 * </p>
 * 
 * <p>
 * This class also provides a {@link #getInstance() singleton} instance, which
 * is the default shared cache for XWT applications.
 * </p>
 */
public class ResourceCache implements IResourceCache {

	/**
	 * @return The default (and shared) {@link IResourceCache} for storing User
	 *         control resources URLs
	 */
	public static IResourceCache getInstance() {
		return instance;
	}

	@Override
	public boolean hasCached(IMetaclass metaclass, String resourcePath) {
		return getTypeCache(metaclass).containsKey(resourcePath);
	}

	@Override
	public URL getCachedResource(IMetaclass metaclass, String resourcePath) {
		return getTypeCache(metaclass).get(resourcePath);
	}

	@Override
	public void cacheResource(IMetaclass metaclass, String resourcePath, URL resource) {
		getTypeCache(metaclass).put(resourcePath, resource);
	}

	private Map<String, URL> getTypeCache(IMetaclass metaclass) {
		Class<?> type = metaclass.getType();
		if (!resourceCache.containsKey(type)) {
			resourceCache.put(type, new HashMap<String, URL>());
		}
		return resourceCache.get(type);
	}

	private static IResourceCache instance = new ResourceCache();

	private Map<Class<?>, Map<String, URL>> resourceCache = new HashMap<Class<?>, Map<String, URL>>();

}
