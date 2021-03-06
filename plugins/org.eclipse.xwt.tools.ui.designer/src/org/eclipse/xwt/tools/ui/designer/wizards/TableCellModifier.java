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
package org.eclipse.xwt.tools.ui.designer.wizards;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.xwt.tools.ui.designer.wizards.models.TextValueEntry;
import org.eclipse.xwt.tools.ui.designer.wizards.pages.ExternalizeStringsWizardPage;

/**
 * @author xrchen (xiaoru.chen@soyatec.com)
 */
public class TableCellModifier implements ICellModifier {

	public boolean canModify(Object element, String property) {
		if (property.equals(ExternalizeStringsWizardPage.KEY_COLUMN_ID)) {
			return true;
		} else if (property
				.equals(ExternalizeStringsWizardPage.VALUE_COLUMN_ID)) {
			return true;
		}
		return false;
	}

	public Object getValue(Object element, String property) {
		if (property.equals(ExternalizeStringsWizardPage.KEY_COLUMN_ID)) {
			if (element instanceof TextValueEntry) {
				return ((TextValueEntry) element).getKey();
			}
		} else if (property
				.equals(ExternalizeStringsWizardPage.VALUE_COLUMN_ID)) {
			if (element instanceof TextValueEntry) {
				return ((TextValueEntry) element).getValue();
			}
		}
		return null;
	}

	public void modify(Object element, String property, Object value) {
		// Null indicates that the validator rejected the value.
		if (value == null)
			return;
		if (element instanceof TableItem) {
			element = ((TableItem) element).getData();
		}
		String text = ((String) value).trim();
		if (property.equals(ExternalizeStringsWizardPage.KEY_COLUMN_ID)) {
			((TextValueEntry) element).setKey(text);
		}

	}

}
