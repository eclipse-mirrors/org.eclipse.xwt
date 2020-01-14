/*******************************************************************************
 * Copyright (c) 2006, 2009 Soyatec (http://www.soyatec.com) and others.
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
package org.eclipse.xwt.tools.ui.workbench;

import org.eclipse.xwt.XWT;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;

public class PartInitializerForm extends Composite {

	public PartInitializerForm(Composite parent, int style) {
		super(parent, style);
	}
	
	protected void onLoaded(Object sent, Event event) {
		EObject object = (EObject) XWT.getDataContext(this); 
		if (object == null) {
			return;
		}
		URI uri = object.eResource().getURI();
		System.out.println(uri.toString());
	}
}
 