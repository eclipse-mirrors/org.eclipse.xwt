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
package org.eclipse.xwt.jface;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xwt.IIndexedElement;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.XWTException;

public class ComboBoxCellEditor extends org.eclipse.jface.viewers.ComboBoxCellEditor implements IIndexedElement {
	protected CellEditorHelper cellEditorHelper;

	public ComboBoxCellEditor() {
		super();
	}

	public ComboBoxCellEditor(Composite parent, String[] items, int style) {
		super(parent, items, style);
	}

	public ComboBoxCellEditor(Composite parent, String[] items) {
		super(parent, items);
	}

	@Override
	protected void doSetValue(Object value) {
		if (value != null) {
			Class<?> targetType = getTargetType();
			if (targetType != String.class) {
				IConverter converter = XWT.findConvertor(targetType, String.class);
				if (converter != null) {
					value = converter.convert(value);
				}
			}
			String[] items = getItems();
			for (int i = 0; i < items.length; i++) {
				if (items[i].equals(value)) {
					super.doSetValue(i);
					return;
				}
			}
		}
		super.doSetValue(-1);
	}

	@Override
	protected Object doGetValue() {
		Object value = super.doGetValue();
		String[] items = getItems();
		int selected = (Integer) value;
		if (selected < 0) {
			return null;
		}
		String selectedString = items[selected];
		Class<?> targetType = getTargetType();
		if (targetType != String.class) {
			IConverter converter = XWT.findConvertor(String.class, targetType);
			if (converter != null) {
				return converter.convert(value);
			}
		}
		return selectedString;
	}

	protected Class<?> getTargetType() {
		if (cellEditorHelper != null) {
			return cellEditorHelper.getTargetType();
		}
		return Object.class;
	}

	public void setIndex(Object parent, int index) {
		if (!(parent instanceof TableViewer)) {
			throw new XWTException("TableView is expected, not \"" + parent.getClass().getName() + "\"");
		}
		cellEditorHelper = new CellEditorHelper((TableViewer) parent, index);
	}
}
