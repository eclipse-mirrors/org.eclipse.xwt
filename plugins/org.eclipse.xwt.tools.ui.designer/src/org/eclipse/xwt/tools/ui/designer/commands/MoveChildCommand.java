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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.xwt.tools.ui.xaml.XamlElement;
import org.eclipse.xwt.tools.ui.xaml.XamlNode;

/**
 * 
 * @author jin.liu (jin.liu@soyatec.com)
 * 
 */
public class MoveChildCommand extends Command {

	private EditPart child;
	private EditPart after;

	int oldPosition = -1;
	int newPosition = -1;
	private XamlNode parentNode;

	public MoveChildCommand(EditPart child, EditPart after) {
		super("Move Child Command");
		this.child = child;
		this.after = after;
	}

	public boolean canExecute() {
		if (child == null || child == after) {
			return false;
		}
		if (after != null) {
			Object model = after.getModel();
			if (model instanceof XamlNode) {
				EObject eContainer = ((XamlNode) model).eContainer();
				if (eContainer instanceof XamlNode) {
					parentNode = (XamlNode) eContainer;
				}
			}
		}
		if (parentNode == null) {
			Object model = child.getModel();
			if (model instanceof XamlNode) {
				EObject eContainer = ((XamlNode) model).eContainer();
				if (eContainer instanceof XamlNode) {
					parentNode = (XamlNode) eContainer;
				}
			}
		}
		if (parentNode == null) {
			return false;
		}
		oldPosition = parentNode.getChildNodes().indexOf(child.getModel());
		if (after != null) {
			newPosition = parentNode.getChildNodes().indexOf(after.getModel());
		} else {
			newPosition = parentNode.getChildNodes().size() - 1;
		}
		if (newPosition > oldPosition) {
			newPosition--;
		}
		return newPosition != -1 && oldPosition != -1
				&& oldPosition != newPosition;
	}

	public void execute() {
		EList<XamlElement> children = parentNode.getChildNodes();
		children.move(newPosition, oldPosition);
	}

	public boolean canUndo() {
		return parentNode != null && newPosition != -1 && oldPosition != -1
				&& newPosition != oldPosition;
	}

	public void undo() {
		parentNode.getChildNodes().move(oldPosition, newPosition);
	}
}
