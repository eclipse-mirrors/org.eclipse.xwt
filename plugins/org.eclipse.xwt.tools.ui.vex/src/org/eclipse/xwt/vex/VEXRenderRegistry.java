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
package org.eclipse.xwt.vex;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.widgets.Composite;

public class VEXRenderRegistry {

	public static final String EXTENSION_ID = "org.eclipse.xwt.vex.render";

	private VEXRenderRegistry() {
	}

	public static VEXRenderer getRender(Composite container) {
		VEXRenderer render = getRender();
		if (render != null && render instanceof AbstractVEXRenderer) {
			((AbstractVEXRenderer) render).setContainer(container);
		}
		return render;
	}

	public static VEXRenderer getRender() {
		IConfigurationElement[] configElem = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
		if (configElem != null && configElem.length > 0) {
			try {
				return (VEXRenderer) configElem[0].createExecutableExtension("class");
			} catch (CoreException e) {
				return null;
			}
		}
		return null;
	}
}
