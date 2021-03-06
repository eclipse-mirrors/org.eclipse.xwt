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
package org.eclipse.xwt.tools.ui.designer.parts;

import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.swt.widgets.Item;
import org.eclipse.xwt.tools.ui.xaml.XamlNode;

/**
 * @author jin.liu (jin.liu@soyatec.com)
 * 
 */
public abstract class StackItemEditPart extends ItemEditPart {

	public StackItemEditPart(Item item, XamlNode model) {
		super(item, model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editparts.AbstractEditPart#performRequest(org.eclipse
	 * .gef.Request)
	 */
	public void performRequest(Request req) {
		if (req.getType() == RequestConstants.REQ_OPEN) {
			popItem();
		}
		super.performRequest(req);
	}
	
	protected abstract void popItem();
}
