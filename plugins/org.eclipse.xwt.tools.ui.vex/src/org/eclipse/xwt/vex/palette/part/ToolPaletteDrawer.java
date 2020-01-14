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
package org.eclipse.xwt.vex.palette.part;

import org.eclipse.gef.palette.PaletteDrawer;

/**
 * 
 */
public class ToolPaletteDrawer extends PaletteDrawer {

	public ToolPaletteDrawer(String label) {
		super(label);
	}

	@Override
	public boolean acceptsType(Object type) {
		return true;
	}
}
