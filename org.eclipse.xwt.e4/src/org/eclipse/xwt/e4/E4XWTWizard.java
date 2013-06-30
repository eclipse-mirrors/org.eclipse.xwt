/*******************************************************************************
 * Copyright (c) 2013 Eclipse XWT Project.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Erdal Karaca - initial API and implementation
 ******************************************************************************/
package org.eclipse.xwt.e4;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class E4XWTWizard extends Wizard {
	private IEclipseContext context;
	private Object finishHandler;
	private Object finishResult;

	public E4XWTWizard(IEclipseContext parentContext) {
		super();
		context = parentContext.createChild(this.getClass().getName());
		context.set(IWizard.class, this);
	}

	@Override
	public boolean performFinish() {
		if (finishHandler == null) {
			return true;
		}

		finishResult = ContextInjectionFactory.invoke(finishHandler,
				Execute.class, context);
		return finishResult instanceof Boolean ? (Boolean) finishResult : true;
	}

	public IWizardPage createNewPage(String pageName,
			Class<? extends E4XWTUI> uiClass) {
		E4XWTWizardPage page = new E4XWTWizardPage(pageName, context, uiClass);
		addPage(page);
		return page;
	}

	public boolean show(Shell shell) {
		WizardDialog dialog = new WizardDialog(shell == null ? Display
				.getDefault().getActiveShell() : shell, this) {
			@Override
			protected void configureShell(Shell newShell) {
				super.configureShell(newShell);
				newShell.setSize(Math.min(640, newShell.getSize().x),
						Math.min(480, newShell.getSize().y));
			}
		};

		return dialog.open() == WizardDialog.OK;
	}

	public IEclipseContext getContext() {
		return context;
	}

	public void setFinishHandler(Object finishHandler) {
		this.finishHandler = finishHandler;
		ContextInjectionFactory.inject(finishHandler, context);
	}

	public Object getFinishResult() {
		return finishResult;
	}

	public static class E4XWTWizardPage extends WizardPage {
		private IEclipseContext context;
		private Class<? extends E4XWTUI> uiClass;

		protected E4XWTWizardPage(String pageName,
				IEclipseContext parentContext, Class<? extends E4XWTUI> uiClass) {
			super(pageName);
			this.uiClass = uiClass;
			context = parentContext.createChild(pageName);
			context.set(IWizardPage.class, this);
		}

		@Override
		public void createControl(Composite parent) {
			Composite container = new Composite(parent, SWT.None);
			container.setLayout(new FillLayout());
			context.set(Composite.class, container);
			ContextInjectionFactory.make(uiClass, context);
			setControl(container);
		}

		@Override
		public boolean isPageComplete() {
			return super.isPageComplete();
		}

		public IEclipseContext getContext() {
			return context;
		}
	}
}
