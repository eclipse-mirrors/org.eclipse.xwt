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
package org.eclipse.xwt.tools.ui.designer.core.model;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IEditorPart;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;

/**
 * @author bo.zhou
 * @author jliu
 */
public interface IModelBuilder extends IModelNotify {

	/**
	 * Load model from given designer.
	 */
	public boolean doLoad(IEditorPart designer, IProgressMonitor monitor);

	/**
	 * Return loaded {@link XamlDocument};
	 */
	public EObject getDiagram();

	public void doSave(IProgressMonitor monitor);

	public EObject getModel(Object textNode);

	public IDOMNode getTextNode(Object model);

	public void dispose();
}
