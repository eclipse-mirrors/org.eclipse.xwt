/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.databinding.datacontext;

import java.net.URL;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xwt.XWT;

public class CompanyView extends Composite {

	public CompanyView(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		URL url = CompanyView.class.getResource("CompanyView.xwt");
		try {
			XWT.open(url, Factory.createCompany());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
