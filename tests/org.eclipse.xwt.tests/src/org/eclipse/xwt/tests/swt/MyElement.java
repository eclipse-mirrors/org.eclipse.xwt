/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.swt;

import org.eclipse.swt.widgets.Composite;

public class MyElement extends Composite {
	public static final int MY_STYLE = 0xF0000000;
	
	protected boolean myStyle = false; 
	
	public MyElement(Composite parent, int style) {
		super(parent, style);
		
		if ((style & MY_STYLE) == MY_STYLE) {
			myStyle = true;
		}
	}

	public boolean isMyStyle() {
		return myStyle;
	}

	public void setMyStyle(boolean myStyle) {
		this.myStyle = myStyle;
	}

}
