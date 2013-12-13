/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
