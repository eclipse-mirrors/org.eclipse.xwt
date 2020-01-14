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
package org.eclipse.xwt.tools.ui.designer.core.editor.outline;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author Jin Liu(jin.liu@soyatec.com)
 */
public class TreeEditPart extends AbstractTreeEditPart {

	private final ILabelProvider labelProvider;

	public TreeEditPart(Object model) {
		this(model, null);
	}

	public TreeEditPart(Object model, ILabelProvider labelProvider) {
		super(model);
		this.labelProvider = labelProvider;
	}

	protected String getText() {
		if (labelProvider != null) {
			return labelProvider.getText(getModel());
		}
		return super.getText();
	}

	protected Image getImage() {
		if (labelProvider != null) {
			return labelProvider.getImage(getModel());
		}
		return super.getImage();
	}

	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.TREE_CONTAINER_ROLE,
				new TreeItemEditPolicy());
	}
}
