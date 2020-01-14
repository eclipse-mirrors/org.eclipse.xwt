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
package org.eclipse.xwt.pde.ui.views;

import java.io.InputStream;
import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.xwt.DefaultLoadingContext;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.databinding.BindingContext;

/**
 * 
 * @author yyang
 */
public abstract class XWTEditorPart extends EditorPart {
	protected Composite container;
	protected Object dataContext;

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setInput(input);
		setSite(site);
	}

	@Override
	public void createPartControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		container.setLayout(new FillLayout());
		container.setBackgroundMode(SWT.INHERIT_DEFAULT);
		updateContent();
	}

	public void setContent(URL file) {
		XWT.setLoadingContext(new DefaultLoadingContext(this.getClass()
				.getClassLoader()));

		for (Control child : container.getChildren()) {
			child.dispose();
		}

		try {
			XWT.load(file);
			container.layout(true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setContent(InputStream inputStream, URL base) {
		XWT.setLoadingContext(new DefaultLoadingContext(getClassLoader()));

		for (Control child : container.getChildren()) {
			child.dispose();
		}

		try {
			XWT.load(container, inputStream, base, getDataContext());
			container.layout(true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected ClassLoader getClassLoader() {
		return this.getClass().getClassLoader();
	}

	public Object getDataContext() {
		if (dataContext == null) {
			dataContext = createDataContext();
		}
		return dataContext;
	}

	/**
	 * Create the data context from IEditorInput
	 * 
	 * @return
	 */
	protected abstract Object createDataContext();

	/**
	 * update the editor content
	 */
	protected abstract void updateContent();
}
