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
package org.eclipse.xwt.tools.ui.designer.properties.editors;

import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xwt.tools.ui.designer.providers.LabelProviderFactory;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public abstract class AbstractCellEditor extends DialogCellEditor {

	public AbstractCellEditor(Composite parent) {
		super(parent);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.DialogCellEditor#updateContents(java.lang.Object)
	 */
	protected void updateContents(Object value) {
		if (value != null) {
			ILabelProvider labelProvider = LabelProviderFactory.getLabelProvider(value.getClass());
			value = labelProvider.getText(value);
		}
		super.updateContents(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.DialogCellEditor#openDialogBox(org.eclipse.swt.widgets.Control)
	 */
	protected Object openDialogBox(Control cellEditorWindow) {
		return null;
	}
}
