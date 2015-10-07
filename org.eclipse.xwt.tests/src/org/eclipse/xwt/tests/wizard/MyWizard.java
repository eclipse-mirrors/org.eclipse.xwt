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

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;


/**
 * @author El-Amine Ouraiba (amine.ouraiba@soyatec.com)
 */

public class MyWizard extends Wizard implements INewWizard {

	public PersonWizardPage pagePerson;
	public CompanyWizardPage pageCompany;
	
	 Person dataContextPerson = new Person();
	 Company dataContextCompany = new Company();
	
	public MyWizard() {
		super();
		setNeedsProgressMonitor(true);
		dataContextCompany.setManager(dataContextPerson);
	}

	public String getWindowTitle() {
		return "Company Wizard";
	}

	@Override
	public void addPages() {
		
		pagePerson = new PersonWizardPage("Person Page", "Enter information about Person", null, dataContextPerson);
		addPage(pagePerson);
		
		pageCompany = new CompanyWizardPage("Company Page",	"Enter information about Company", null, dataContextCompany);
		addPage(pageCompany);
		
	}

	@Override
	public boolean performFinish() {
        return true;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
	}

	public boolean canFinish(){
		if (this.getContainer().getCurrentPage() == pagePerson) 
			return false;
		if (pageCompany.isPageComplete()) return true;
		return false; 
	}
}