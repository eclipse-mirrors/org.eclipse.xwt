package org.eclipse.xwt.tests.wizard;

import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public class WizarsLuncher {

	public static void main(String[] args) {
        Composite parent = new Shell();
        MyWizard wizard = new MyWizard();
	    WizardDialog wizardDialog = new WizardDialog(parent.getShell(), wizard);
	    wizardDialog.open() ;
	  }	
}