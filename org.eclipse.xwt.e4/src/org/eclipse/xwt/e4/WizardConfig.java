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

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.widgets.Shell;

public class WizardConfig {
	private E4XWTWizard wizard;

	public WizardConfig(IEclipseContext parentContext) {
		wizard = new E4XWTWizard(parentContext);
	}

	public WizardConfig onFinish(Object object) {
		wizard.setFinishHandler(object);
		return this;
	}

	public WizardConfig setTitle(String title) {
		wizard.setWindowTitle(title);
		return this;
	}

	public WizardConfig addPage(PageConfig pageConfig) {
		IWizardPage page = wizard.createNewPage(pageConfig.getUiClass()
				.getName(), pageConfig.getUiClass());
		page.setDescription(pageConfig.getDescription());
		return this;
	}

	public WizardConfig bind(String key, Object value) {
		wizard.getContext().set(key, value);
		return this;
	}

	public <T> WizardConfig bind(Class<T> type, T t) {
		wizard.getContext().set(type, t);
		return this;
	}

	public boolean show(Shell activeShell) {
		return wizard.show(activeShell);
	}

	@SuppressWarnings("unchecked")
	public <T> T getResult() {
		return (T) wizard.getFinishResult();
	}

	public static class PageConfig {
		private Class<? extends E4XWTUI> uiClass;
		private String description;

		public PageConfig(Class<? extends E4XWTUI> uiClass) {
			this.uiClass = uiClass;
		}

		public String getDescription() {
			return description;
		}

		public PageConfig setDescription(String description) {
			this.description = description;
			return this;
		}

		public Class<? extends E4XWTUI> getUiClass() {
			return uiClass;
		}
	}
}
