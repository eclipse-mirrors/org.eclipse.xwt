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

import org.eclipse.xwt.IConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.xwt.tools.ui.xaml.XamlAttribute;
import org.eclipse.xwt.tools.ui.xaml.XamlDocument;
import org.eclipse.xwt.tools.ui.xaml.XamlElement;
import org.eclipse.xwt.tools.ui.xaml.XamlNode;

/**
 * @author jliu jin.liu@soyatec.com
 */
public class AddNewChildCommand extends Command {
	private XamlNode parent;
	private XamlNode child;
	private int index;

	public AddNewChildCommand(XamlNode parent, XamlNode child) {
		this(parent, child, -1);
	}

	public AddNewChildCommand(XamlNode parent, XamlNode child, int index) {
		this.parent = parent;
		this.child = child;
		this.index = index;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		return parent != null && child != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		if (child instanceof XamlElement) {
			XamlElement element = (XamlElement) child;
			if (index >= 0 && index < parent.getChildNodes().size()) {
				parent.getChildNodes().add(index, element);
			} else {
				parent.getChildNodes().add(element);
			}
		} else if (child instanceof XamlAttribute) {
			XamlAttribute attr = (XamlAttribute) child;
			String name = attr.getName();
			String prefix = attr.getPrefix();
			XamlDocument ownerDocument = parent.getOwnerDocument();
			String namespace = IConstants.XWT_NAMESPACE;
			if (ownerDocument != null) {
				namespace = ownerDocument.getDeclaredNamespace(prefix);
			}
			XamlAttribute oldAttr = parent.getAttribute(name, namespace);
			if (oldAttr != null) {
				parent.getAttributes().remove(oldAttr);
			}
			parent.getAttributes().add((XamlAttribute) child);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	public boolean canUndo() {
		return parent != null && child != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		if (child instanceof XamlElement) {
			parent.getChildNodes().remove(child);
		} else if (child instanceof XamlAttribute) {
			parent.getAttributes().remove(child);
		}
	}

	public int getIndex() {
		return index;
	}
	
	public XamlNode getParent() {
		return parent;
	}

	public XamlNode getChild() {
		return child;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
