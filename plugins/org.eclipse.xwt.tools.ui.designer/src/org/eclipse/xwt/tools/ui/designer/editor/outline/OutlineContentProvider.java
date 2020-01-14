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
package org.eclipse.xwt.tools.ui.designer.editor.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.xwt.tools.ui.xaml.XamlDocument;
import org.eclipse.xwt.tools.ui.xaml.XamlElement;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class OutlineContentProvider implements ITreeContentProvider {

	private static final Object[] EMPTY = new Object[0];

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public void dispose() {

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof XamlElement) {
			return ((XamlElement) parentElement).getChildNodes().toArray(
					new XamlElement[0]);
		} else if (parentElement instanceof XamlDocument) {
			XamlElement root = ((XamlDocument) parentElement).getRootElement();
			if (root != null) {
				return new Object[] { root };
			}
		}
		return EMPTY;
	}

	public Object getParent(Object element) {
		if (element instanceof EObject) {
			return ((EObject) element).eContainer();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}
}
