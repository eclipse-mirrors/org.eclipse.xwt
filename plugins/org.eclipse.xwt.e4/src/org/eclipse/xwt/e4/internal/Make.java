/*******************************************************************************
 * Copyright (c) 2013 Eclipse XWT Project.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Erdal Karaca - initial API and implementation
 ******************************************************************************/
package org.eclipse.xwt.e4.internal;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.xwt.e4.E4XWTUI;

public class Make {
	private IEclipseContext context;
	private Class<?> type;
	private Object made;

	public Make(Object parent) {
		IEclipseContext context = E4XWTUI.findData(IEclipseContext.class,
				parent);
		setContext(context);
	}

	public Class<?> getType() {
		return type;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}

	public IEclipseContext getContext() {
		return context;
	}

	public void setContext(IEclipseContext context) {
		this.context = context;
	}

	public Object getMade() {
		if (made == null) {
			made = ContextInjectionFactory.make(type, context);
		}

		return made;
	}

	public void setMade(Object made) {
		this.made = made;
	}
}
