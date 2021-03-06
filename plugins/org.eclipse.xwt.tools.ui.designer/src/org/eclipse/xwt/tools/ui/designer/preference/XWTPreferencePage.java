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
package org.eclipse.xwt.tools.ui.designer.preference;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.xwt.tools.ui.designer.layouts.LayoutType;

public class XWTPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public XWTPreferencePage() {
		super(GRID);
		this.setPreferenceStore(Preferences.getPreferenceStore());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 */
	protected void createFieldEditors() {
		Composite parent = getFieldEditorParent();
		addField(new BooleanFieldEditor(Preferences.PROMPT_DURING_CREATION, Preferences.PROMPT_DURING_CREATION, parent));

		String[][] layouts = new String[][] { { LayoutType.NullLayout.value(), LayoutType.NullLayout.value() }, { LayoutType.FillLayout.value(), LayoutType.FillLayout.value() }, { LayoutType.GridLayout.value(), LayoutType.GridLayout.value() }, { LayoutType.RowLayout.value(), LayoutType.RowLayout.value() } };
		addField(new ComboFieldEditor(Preferences.DEFAULT_LAYOUT, Preferences.DEFAULT_LAYOUT, layouts, parent));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {

	}
}
