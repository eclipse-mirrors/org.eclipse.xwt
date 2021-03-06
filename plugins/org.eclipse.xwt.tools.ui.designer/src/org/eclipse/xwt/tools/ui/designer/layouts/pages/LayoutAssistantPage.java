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
package org.eclipse.xwt.tools.ui.designer.layouts.pages;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.tools.ui.designer.layouts.LayoutType;
import org.eclipse.xwt.tools.ui.xaml.XamlAttribute;
import org.eclipse.xwt.tools.ui.xaml.XamlElement;
import org.eclipse.xwt.tools.ui.xaml.XamlFactory;
import org.eclipse.xwt.tools.ui.xaml.XamlNode;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public abstract class LayoutAssistantPage extends AssistantPage {

	private LayoutType layoutType;

	public LayoutAssistantPage(LayoutType layoutType) {
		this.layoutType = layoutType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.tools.ui.designer.layouts.pages.AssistantPage#createParentModel(org.soyatec.tools.designer.xaml.XamlNode)
	 */
	protected XamlElement createAssistModel(XamlNode parent) {
		if (parent == null) {
			return null;
		}
		XamlAttribute attribute = getAssistParent();
		XamlElement layoutModel = attribute.getChild(layoutType.value());
		if (layoutModel == null) {
			layoutModel = XamlFactory.eINSTANCE.createElement(layoutType.value(), IConstants.XWT_NAMESPACE);
		}
		if (attribute.eContainer() == null) {
			attribute.getChildNodes().add(layoutModel);
		}
		return layoutModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.tools.ui.designer.layouts.pages.AssistantPage#createAssistParent(org.soyatec.tools.designer.xaml.XamlNode)
	 */
	protected XamlAttribute createAssistParent(XamlNode parent) {
		XamlAttribute attribute = parent.getAttribute("layout");
		if (attribute == null) {
			attribute = XamlFactory.eINSTANCE.createAttribute("layout", IConstants.XWT_NAMESPACE);
		}
		return attribute;
	}
}
