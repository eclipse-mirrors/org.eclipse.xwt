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
package org.eclipse.xwt.ui.workbench.views;

import org.eclipse.xwt.ui.workbench.IStaticPart;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public abstract class XWTPartSwitcher extends XWTStaticPart {

	protected void refresh() {
		IStaticPart switcher = getCurrentPart();
		switchPart(switcher);
	}

	protected abstract IStaticPart getCurrentPart();

	public void switchPart(IStaticPart part) {
		refresh(part.getURL(), part.getDataContext(), part.getClassLoader());
	}
}
