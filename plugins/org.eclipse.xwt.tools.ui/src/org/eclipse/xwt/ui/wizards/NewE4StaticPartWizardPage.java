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
package org.eclipse.xwt.ui.wizards;

public class NewE4StaticPartWizardPage extends NewUIElementWizardPage {

	public NewE4StaticPartWizardPage() {
		setTitle("New Wizard Creation");
		setDescription("This wizard creates a view part for e4 workbench.");
	}
	
	protected String getSuperClassName() {
		return "org.eclipse.xwt.ui.workbench.views.XWTStaticPart";
	}
}
