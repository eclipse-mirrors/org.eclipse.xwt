/******************************************************************************* 
 * Copyright (c) 2006, 2015 Soyatec (http://www.soyatec.com) and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Soyatec - initial API and implementation 
 *******************************************************************************/

package org.eclipse.xwt.tests.databinding.datetime;

import java.net.URL;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xwt.XWT;


/**
 * @author El-Amine Ouraiba( amine.ouraiba@soyatec.com)
 * 
 */
public class TestClassView extends Composite {
	static Person person = new Person();
	
	public TestClassView(Composite parent, int style) {
		super(parent, style);
	}

	
	public static void main(String[] args) {
		URL url = TestClassView.class
				.getResource("TestClassView.xwt");
		try {
		
			XWT.open(url, person);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}