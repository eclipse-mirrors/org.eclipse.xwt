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

import java.net.URL;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.xwt.DefaultLoadingContext;
import org.eclipse.xwt.ILoadingContext;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.emf.EMFBinding;

public class XWTSection extends AbstractPropertySection {
	private ILoadingContext loadingContext = new DefaultLoadingContext(
			getClass().getClassLoader());

	private URL sectionURL;

	private Composite self;

	public XWTSection(URL sectionURL) {
		this.sectionURL = sectionURL;
	}

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		self = new Composite(parent, SWT.NONE);

		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		self.setLayout(layout);

		layout = new GridLayout(1, false);
		layout.verticalSpacing = 5;
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		parent.setLayout(layout);

		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		self.setLayoutData(data);

		self.setBackground(parent.getBackground());
		self.setBackgroundMode(SWT.INHERIT_DEFAULT);
	}

	@Override
	public void refresh() {
		if (self == null || self.isDisposed()) {
			dispose();
			return;
		}
		for (Control child : self.getChildren()) {
			child.dispose();
		}
		Object source = getDataObject();
		if (source == null) {
			return;
		}
		if (sectionURL != null) {
			createSection(self, sectionURL, source);
		}
		layout(self);
	}

	private Object getDataObject() {
		IStructuredSelection selection = getSelection();
		return selection.getFirstElement();
	}

	private Control createSection(Composite parent, URL xwtFile, Object source) {
		EMFBinding.initialze();
		ILoadingContext xwtContext = XWT.getLoadingContext();
		XWT.setLoadingContext(loadingContext);

		Control control = null;
		try {
			control = (Control) XWT.load(parent, xwtFile, source);

			if (control != null) {
				control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
						true));
			}
		} catch (Exception ex) {
			Label label = new Label(parent, SWT.NONE);
			label.setText("An error occured in the property view. The file " + xwtFile + " could not be loaded"); //$NON-NLS-1$ //$NON-NLS-2$
			ex.printStackTrace();
		}
		// layout(parent);

		XWT.setLoadingContext(xwtContext);

		return control;
	}

	private void layout(Composite parent) {
		parent.getParent().getParent().layout();
		parent.getParent().layout();
		parent.layout();
	}

	@Override
	public void dispose() {
		if (self != null) {
			self.dispose();
		}
		super.dispose();
	}

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		if (selection == getSelection()) {
			return;
		}
		super.setInput(part, selection);
	}

	@Override
	public IStructuredSelection getSelection() {
		return (IStructuredSelection) super.getSelection();
	}
}
