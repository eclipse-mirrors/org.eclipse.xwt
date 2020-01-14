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
package org.eclipse.xwt.tools.ui.designer.properties.tabbed.sections;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class ForegroundSection extends ColorSection {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.tools.ui.designer.properties.tabbed.sections.AbstractAttributeSection#getAttributeName()
	 */
	protected String getAttributeName() {
		return "foreground";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.tools.ui.designer.properties.tabbed.sections.ColorSection#defaultColor()
	 */
	protected String defaultColor() {
		return "SWT.COLOR_WIDGET_FOREGROUND";
	}
}
