
/******************************************************************************* 
 * Copyright (c) 2006, 2015 Soyatec (http://www.soyatec.com) and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Soyatec - initial API and implementation 
 *******************************************************************************/

package org.eclipse.xwt.tests.wizard;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xwt.ui.workbench.wizard.XWTWizardPage;

/**
 * @author El-Amine Ouraiba (amine.ouraiba@soyatec.com)
 */

public class CompanyWizardPage  extends XWTWizardPage {

	protected CompanyWizardPage(String pageName, String title,
			ImageDescriptor titleImage, Object dataContext) {
		super(pageName, title, titleImage, dataContext);
	}

	protected URL getContentURL() {
		URL url = CompanyWizardPage.class.getResource("CompanyView.xwt");
		return url;
	}

	public boolean canFlipToNextPage() {
		return isPageComplete() && getNextPage() != null;
	}

}