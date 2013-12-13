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
package org.eclipse.xwt.tools.ui.designer.providers;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.xwt.tools.ui.designer.wizards.models.TextValueModel;

/**
 * @author xrchen (xiaoru.chen@soyatec.com)
 */
public class ExternalizeStringContentProvider implements IStructuredContentProvider {

	private TextValueModel model;

	public Object[] getElements(Object inputElement) {
		this.model = (TextValueModel) inputElement;
		return model.elements();
	}

	public void dispose() {

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

}
