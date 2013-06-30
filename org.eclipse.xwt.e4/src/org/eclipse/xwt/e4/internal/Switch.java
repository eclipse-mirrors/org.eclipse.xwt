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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xwt.e4.E4XWTUI;

public class Switch extends Composite {
	private Object check;
	private IEclipseContext context;
	private List<Case> cases = new ArrayList<Case>();
	private E4XWTUI ui;

	public Switch(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout());

		context = E4XWTUI.findData(IEclipseContext.class, parent);
	}

	public Object getCheck() {
		return check;
	}

	public void setCheck(Object check) {
		this.check = check;

		for (Control child : getChildren()) {
			child.dispose();
		}

		Case match = null;

		for (Case uiCase : cases) {
			if (uiCase.getWhen() == null) {
				// remember default case
				match = uiCase;
				continue;
			}

			if (uiCase.getUiClass() != null && uiCase.getWhen() != null) {
				IStatus validate = uiCase.getWhen().validate(check);

				if (validate != null && validate.isOK()) {
					match = uiCase;
					// first match wins
					break;
				}
			}
		}

		// either default match or validated match will be taken
		if (match != null) {
			Class<? extends E4XWTUI> uiClass = match.getUiClass();
			IEclipseContext localContext = context.createChild(uiClass
					.getName());
			localContext.set(Composite.class, this);
			ui = ContextInjectionFactory.make(uiClass, context, localContext);
		}

		layout();
	}

	public void addCase(Case uiCase) {
		cases.add(uiCase);
	}

	public E4XWTUI getUi() {
		return ui;
	}
}
