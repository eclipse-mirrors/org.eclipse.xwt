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
package org.eclipse.xwt.tools.ui.designer.loader;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.ILoadingContext;
import org.eclipse.xwt.tools.ui.xaml.XamlNode;

public class XWTClassLoaderUtil extends org.eclipse.xwt.internal.utils.ClassLoaderUtil {

	static public Object loadStaticMember(ILoadingContext loadingContext, XamlNode element) {
		String name = element.getName();
		String namespace = element.getNamespace();
		Object value = doLoadMember(loadingContext, name, namespace);
		if (value != null) {
			return value;
		}
		String content = element.getValue();
		if (content == null) {
			XamlNode member = element.getAttribute(IConstants.XWT_NAMESPACE, IConstants.XAML_X_STATIC_MEMBER);
			if (member == null) {
				member = element;
			}
			if (member != null) {
				content = member.getValue();
				if (content == null) {
					for (XamlNode documentObject : member.getChildNodes()) {
						String ns = documentObject.getNamespace();
						String n = documentObject.getName();
						return doLoadMember(loadingContext, n, ns);
					}
				}
			}
		} else {
			if (IConstants.XAML_X_STATIC.equals(name) && IConstants.XWT_X_NAMESPACE.equals(namespace)) {
				namespace = IConstants.XWT_NAMESPACE;
				return doLoadMember(loadingContext, content, namespace);
			}
		}
		// TODO
		return null;
	}
}
