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
package org.eclipse.xwt.tools.ui.designer.utils;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.tools.ui.designer.layouts.LayoutType;
import org.eclipse.xwt.tools.ui.designer.layouts.LayoutsHelper;
import org.eclipse.xwt.tools.ui.designer.parts.CompositeEditPart;
import org.eclipse.xwt.tools.ui.xaml.XamlAttribute;
import org.eclipse.xwt.tools.ui.xaml.XamlElement;
import org.eclipse.xwt.tools.ui.xaml.XamlFactory;
import org.eclipse.xwt.tools.ui.xaml.tools.XamlCreateTools;

public class CoolBarInitSize {
	private XamlElement element;

	public CoolBarInitSize(XamlElement element) {
		// TODO Auto-generated constructor stub
		this.element = element;
	}

	public void AddLayoutAttribute(CompositeEditPart editPart) {
		LayoutType type = LayoutsHelper.getLayoutType(editPart);
		switch (type) {
		case GridLayout:
			GridLayoutAttribute();
			break;
		case FillLayout:
			return;
		case RowLayout:
			RowLayoutLayoutAttribute();
			break;
		case StackLayout:
		case FormLayout:
		default:
			NullLayoutAttribute();

		}
	}

	public void GridLayoutAttribute() {
		// layoutData
		if (element.getAttribute("layoutData") == null) {
			XamlAttribute attr = XamlFactory.eINSTANCE.createXamlAttribute();
			attr.setName("layoutData");
			XamlElement newelement = XamlFactory.eINSTANCE.createXamlElement();
			newelement.setName("GridData");
			XamlCreateTools.addAttribute(newelement, "widthHint", IConstants.XWT_NAMESPACE, "50");
			XamlCreateTools.addAttribute(newelement, "heightHint", IConstants.XWT_NAMESPACE, "25");
			attr.getChildNodes().add(element);
			element.getAttributes().add(attr);
		}

	}

	public void RowLayoutLayoutAttribute() {
		if (element.getAttribute("layoutData") == null) {
			XamlAttribute attr = XamlFactory.eINSTANCE.createXamlAttribute();
			attr.setName("layoutData");
			XamlElement newelement = XamlFactory.eINSTANCE.createXamlElement();
			newelement.setName("RowData");
			XamlCreateTools.addAttribute(newelement, "width", IConstants.XWT_NAMESPACE, "50");
			XamlCreateTools.addAttribute(newelement, "height", IConstants.XWT_NAMESPACE, "25");
			attr.getChildNodes().add(newelement);
			element.getAttributes().add(attr);
		}
	}

	public void NullLayoutAttribute() {
	}
}
