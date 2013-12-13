/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tools.ui.designer.properties.tabbed.sections;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class BackgroundSection extends ColorSection {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.tools.ui.designer.properties.tabbed.sections.ColorSection#defaultColor()
	 */
	protected String defaultColor() {
		return "SWT.COLOR_WIDGET_BACKGROUND";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.tools.ui.designer.properties.tabbed.sections.AbstractAttributeSection#getAttributeName()
	 */
	protected String getAttributeName() {
		return "background";
	}

}
