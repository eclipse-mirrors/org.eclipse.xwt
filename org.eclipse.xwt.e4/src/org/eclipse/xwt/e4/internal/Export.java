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

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.xwt.e4.E4XWTUI;

public class Export {
	private Object parent;
	private Object value;
	private String varName;
	private int level = 0;
	private Class<?> make;

	private IEclipseContext ctx;

	public Export(Object parent) {
		this.parent = parent;
		ctx = E4XWTUI.findData(IEclipseContext.class, parent);
	}

	public void setCtx(IEclipseContext ctx) {
		this.ctx = ctx;
	}

	public IEclipseContext getCtx() {
		return ctx;
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setValue(Object value) {
		this.value = value;
		exportValue();
	}

	private void exportValue() {
		IEclipseContext ctx = this.ctx;

		int l = level == -1 ? Integer.MAX_VALUE : level;

		while (l-- > 0) {
			IEclipseContext parent = ctx.getParent();

			if (parent == null) {
				break;
			}

			ctx = parent;
		}

		if (value == null && make != null) {
			value = ContextInjectionFactory.make(make, ctx);
		}

		ctx.set(varName, value);
	}

	public Object getValue() {
		return value;
	}

	public Object getParent() {
		return parent;
	}

	public Class<?> getMake() {
		return make;
	}

	public void setMake(Class<?> make) {
		this.make = make;
	}
}
