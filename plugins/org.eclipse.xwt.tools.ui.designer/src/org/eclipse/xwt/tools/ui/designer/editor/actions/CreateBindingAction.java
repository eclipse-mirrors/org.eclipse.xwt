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
package org.eclipse.xwt.tools.ui.designer.editor.actions;

import org.eclipse.gef.EditPart;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xwt.tools.ui.xaml.XamlDocument;
import org.eclipse.xwt.tools.ui.xaml.XamlElement;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class CreateBindingAction extends Action {

	private EditPart editPart;
	private Object observe;
	private String property;

	public CreateBindingAction(EditPart editPart, Object observe, String property, Image image) {
		super(property, image == null ? null : ImageDescriptor.createFromImage(image));
		this.editPart = editPart;
		this.observe = observe;
		this.property = property;
		setEnabled(observe != null && property != null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		// StructuredProperty tp = new PropertiesProvider().findProperty(observe, property);
		// ObserveInfo targetInfo = new ObserveInfo(observe, tp, ObserveType.WIDGETS);
		// EditPart root = getRoot(editPart);
		// CreateBindingDialog dialog = new CreateBindingDialog(new Shell(), targetInfo, root);
		// if (dialog.open() == Window.OK) {
		// IObserveInfo modelInfo = dialog.getBindingModel();
		// BindingInfo bindingInfo = new BindingInfo(targetInfo, modelInfo);
		// editPart.getViewer().getEditDomain().getCommandStack().execute(bindingInfo.bindWithCommand());
		// }
		System.out.println(editPart);
		System.out.println(observe);
		System.out.println(property);
		System.out.println(getRoot(editPart));
	}

	private EditPart getRoot(EditPart editPart) {
		if (editPart == null) {
			return null;
		}
		Object model = editPart.getModel();
		if (model instanceof XamlElement && ((XamlElement) model).eContainer() instanceof XamlDocument) {
			return editPart;
		}
		return getRoot(editPart.getParent());
	}
}
