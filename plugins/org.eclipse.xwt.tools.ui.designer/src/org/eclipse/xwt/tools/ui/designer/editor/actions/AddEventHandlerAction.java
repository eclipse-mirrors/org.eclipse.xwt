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

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.IEventConstants;
import org.eclipse.xwt.metadata.ModelUtils;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.window.Window;
import org.eclipse.xwt.tools.ui.designer.dialogs.NewHandlerDialog;
import org.eclipse.xwt.tools.ui.designer.editor.XWTDesigner;
import org.eclipse.xwt.tools.ui.designer.editor.event.EventHandler;
import org.eclipse.xwt.tools.ui.designer.resources.ImageShop;
import org.eclipse.xwt.tools.ui.xaml.XamlAttribute;
import org.eclipse.xwt.tools.ui.xaml.XamlElement;
import org.eclipse.xwt.tools.ui.xaml.XamlFactory;

public class AddEventHandlerAction extends Action {
	private EditPart editPart;
	private XWTDesigner designer;

	public AddEventHandlerAction(EditPart editpart, XWTDesigner designer, String eventType) {
		this.editPart = editpart;
		this.designer = designer;
		setText(eventType);
		setImageDescriptor(ImageShop.getImageDescriptor(ImageShop.IMG_LISTENER_METHOD));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		EventHandler eventHandler = designer.getEventHandler();
		if (eventHandler == null) {
			return;
		}
		XamlElement child = (XamlElement) editPart.getModel();
		// add the attribute
		
		String attributeName = ModelUtils.normalizePropertyName(getText());
		String initialValue = "on" + getText();
		String eventName = attributeName + IEventConstants.SUFFIX;
		initialValue = eventHandler.suggestDefaultName(child, initialValue);
		XamlAttribute handlerAttr = XamlFactory.eINSTANCE.createAttribute(eventName, IConstants.XWT_NAMESPACE);
		NewHandlerDialog dialog = new NewHandlerDialog(eventHandler, initialValue);
		if (dialog.open() == Window.OK) {
			String newValue = dialog.getHandlerName();
			if (newValue != "" && newValue != null) {
				handlerAttr.setValue(newValue);
				child.getAttributes().add(handlerAttr);
				eventHandler.createHandler(newValue);
			}
		}
	}
}
