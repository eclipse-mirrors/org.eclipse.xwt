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
package org.eclipse.xwt.tools.ui.designer.editor.sash;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.xwt.tools.ui.designer.commands.InsertCreateCommand;
import org.eclipse.xwt.tools.ui.xaml.XamlNode;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class SashFormInsertCreateCommand extends InsertCreateCommand {

	public SashFormInsertCreateCommand(EditPart parent, EditPart reference,
			CreateRequest createRequest, int index) {
		super(parent, reference, createRequest, index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xwt.tools.ui.designer.commands.AbstractCreationCommand
	 * #createCreateCommand(org.soyatec.tools.designer.xaml.XamlNode,
	 * org.soyatec.tools.designer.xaml.XamlNode)
	 */
	protected Command createCreateCommand(XamlNode parent, XamlNode child) {
		return new AddSashFormChildCommands(getParent(), child, getIndex());
	}
}
