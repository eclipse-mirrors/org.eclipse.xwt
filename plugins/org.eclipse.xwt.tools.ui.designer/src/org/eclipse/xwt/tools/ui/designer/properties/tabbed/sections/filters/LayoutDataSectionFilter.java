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
package org.eclipse.xwt.tools.ui.designer.properties.tabbed.sections.filters;

import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.xwt.tools.ui.designer.layouts.LayoutDataType;
import org.eclipse.xwt.tools.ui.designer.layouts.LayoutsHelper;
import org.eclipse.xwt.tools.ui.designer.layouts.pages.AssistancePageFactory;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class LayoutDataSectionFilter implements IFilter {
	public boolean select(Object toTest) {
		if (toTest instanceof EditPart) {
			LayoutDataType layoutDataType = LayoutsHelper
					.getLayoutDataType((EditPart) toTest);
			return AssistancePageFactory.isSupport(layoutDataType);
		}
		return false;
	}

}
