/******************************************************************************* 
 * Copyright (c) 2006, 2015 Soyatec (http://www.soyatec.com) and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License 2.0 
 * which accompanies this distribution, and is available at 
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0 
 * 
 * Contributors: 
 * Soyatec - initial API and implementation 
 *******************************************************************************/

package org.eclipse.xwt.tests.wizard;

import java.net.URL;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xwt.XWT;

/**
 * @author
 * 
 */
public class AddressView extends Composite {
	public AddressView(Composite parent, int style) {
		super(parent, style);
	}
	
	public static void main(String[] args) {
		URL url = AddressView.class.getResource("AddressView.xwt");
		
		try {
			XWT.open(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}