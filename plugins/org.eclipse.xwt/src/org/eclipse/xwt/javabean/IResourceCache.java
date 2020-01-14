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

import org.eclipse.xwt.metadata.IMetaclass;

/**
 * A Cache to store results of calls to {@link Class#getResource(String)}.
 * The main usage is to speed-up access to User Controls
 */
public interface IResourceCache {

	/**
	 * Tests whether this cache contains a value for the given resource. Note that
	 * the cache may contain a "null" value (if cacheResource(x, y, null) was
	 * called), in which case "hasCached(x, y)" will return {@link Boolean#TRUE
	 * true}.
	 * 
	 * @param metaclass
	 * @param resourcePath
	 * @return true if a value was cached for the (metaclass, resourcePath) pair,
	 *         false otherwise.
	 */
	boolean hasCached(IMetaclass metaclass, String resourcePath);

	/**
	 * Returns the (potentially null) cached URL for this resource. Note: this
	 * method doesn't may return null in two distinct cases:
	 * <ul>
	 * <li>The resource was never cached</li>
	 * <li>The "null" value was cached</li>
	 * </ul>
	 * 
	 * To distinguish between "null" and "unknown" values, use
	 * {@link #hasCached(IMetaclass, String)}
	 * 
	 * @param metaclass
	 * @param resourcePath
	 * @return
	 */
	URL getCachedResource(IMetaclass metaclass, String resourcePath);

	/**
	 * Adds the specified (potentially null) resource to the cache.
	 * 
	 * @param metaclass
	 * @param resourcePath
	 * @param resource
	 */
	void cacheResource(IMetaclass metaclass, String resourcePath, URL resource);
}
