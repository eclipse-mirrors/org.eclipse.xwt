/*******************************************************************************
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 *******************************************************************************/
package org.eclipse.xwt.internal.xml;

import java.net.URL;


/**
 * A cache of reusable XML elements previously parsed from specific {@code URL}s. Implementations may selectively
 * cache content, for example caching only elements for <tt>platform:/resource</tt> or OSGi bundle URLs because
 * others such as HTTP URLs reference potentially changeable resources.
 */
public interface IElementCache {

	/** An implementation of the protocol that doesn't actually cache anything. */
	IElementCache NULL = new IElementCache() {

		public Element getElement(URL url) {
			return null;
		}

		public void cache(URL url, Element element) {
			// Pass
		}
	};

	/**
	 * Obtains the previously cached element parsed from the given {@code url}.
	 * 
	 * @param url
	 *        the URL of an XWT resource
	 * 
	 * @return the previously parsed contents of the resource, or {@code null} if the cache has nothing for this {@code url}
	 */
	Element getElement(URL url);

	/**
	 * Adds an {@code element} parsed from the resource indicated by the given {@code url}.
	 * 
	 * @param url
	 *        the URL of an XWT resource that was parsed
	 * @param element
	 *        the element that was parsed from it
	 */
	void cache(URL url, Element element);
}
