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
package org.eclipse.xwt.tools.ui.designer.commands;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.requests.CreateRequest;

public class CoolBarInsertCreateCommand extends InsertCreateCommand {

	public CoolBarInsertCreateCommand(EditPart parent, EditPart after, CreateRequest createRequest) {
		super(parent, after, createRequest);
	}

	public boolean canExecute() {
		Class<?> s = (Class<?>) helper.getCreateType();
		return parent != null && getParentModel() != null && s.getCanonicalName().equals("org.eclipse.swt.widgets.CoolItem");
	}
}
