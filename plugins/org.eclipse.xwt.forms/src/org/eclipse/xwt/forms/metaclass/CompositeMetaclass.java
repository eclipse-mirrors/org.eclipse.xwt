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
 *     Soyatec and Erdal Karaca - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.forms.metaclass;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * 
 * @author Erdal Karaca <erdal.karaca.de@googlemail.com>
 * @author yves.yang (yves.yang@soyatec.com)
 */
public class CompositeMetaclass extends AbstractFormMetaclass {
	public CompositeMetaclass() {
		super(Composite.class);
	}

	@Override
	protected Control doCreateControl(FormToolkit tk, Composite parent,
			int style) {
		boolean separator = (style & SWT.SEPARATOR) != 0;
		return separator ? tk.createCompositeSeparator(parent) : tk
				.createComposite(parent, style);
	}
}
