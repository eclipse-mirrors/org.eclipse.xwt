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
package org.eclipse.xwt.internal.utils;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class TableEditorHelper {
	public static void initEditor(final TableItem tableItem, Control editor, final int column) {
		if (editor instanceof Text) {
			final Text text = (Text) editor;
			text.setText(tableItem.getText(column));
			text.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent e) {
					tableItem.setText(column, text.getText());
				}
			});
		} else if (editor instanceof CCombo) {
			final CCombo combo = (CCombo) editor;
			combo.setText(tableItem.getText(column));
			combo.addSelectionListener(new SelectionListener() {
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					tableItem.setText(column, combo.getText());
				}

				@Override
				public void widgetSelected(SelectionEvent e) {
					tableItem.setText(column, combo.getItem(combo.getSelectionIndex()));
				}
			});
		} else if (editor instanceof Combo) {
			final Combo combo = (Combo) editor;
			combo.setText(tableItem.getText(column));
			combo.addSelectionListener(new SelectionListener() {
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					tableItem.setText(column, combo.getText());
				}

				@Override
				public void widgetSelected(SelectionEvent e) {
					tableItem.setText(column, combo.getItem(combo.getSelectionIndex()));
				}
			});
		}
	}
}
