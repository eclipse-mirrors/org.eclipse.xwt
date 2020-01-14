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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.xwt.tools.ui.designer.core.editor.outline.TreeItemEditPart;
import org.eclipse.xwt.tools.ui.xaml.XamlDocument;
import org.eclipse.xwt.tools.ui.xaml.XamlElement;

/**
 * @author Jin Liu(jin.liu@soyatec.com)
 */
public class TreeEditPartFactory implements EditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof XamlDocument) {
			XamlElement rootElement = ((XamlDocument) model).getRootElement();
			return createEditPart(context, rootElement);
		}
		return new TreeEditPart(model);
	}

	private class TreeEditPart extends TreeItemEditPart {

		public TreeEditPart(Object model) {
			super(model, new OutlineContentProvider(),
					new OutlineLabelProvider());
		}

		protected void createEditPolicies() {
			super.createEditPolicies();
		}
	}
}
