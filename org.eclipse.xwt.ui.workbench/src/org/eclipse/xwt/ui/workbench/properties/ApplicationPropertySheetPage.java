/*******************************************************************************
 * Copyright (c) 2006, 2014 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.ui.workbench.properties;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class ApplicationPropertySheetPage extends TabbedPropertySheetPage {

	private EditingDomain editingDomain;

	public ApplicationPropertySheetPage(
			EditingDomain editingDomain,
			ITabbedPropertySheetPageContributor tabbedPropertySheetPageContributor) {
		this(editingDomain, tabbedPropertySheetPageContributor, true);
	}

	public ApplicationPropertySheetPage(
			EditingDomain editingDomain,
			ITabbedPropertySheetPageContributor tabbedPropertySheetPageContributor,
			boolean showTitleBar) {
		super(tabbedPropertySheetPageContributor, showTitleBar);
		this.editingDomain = editingDomain;
	}

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

}
