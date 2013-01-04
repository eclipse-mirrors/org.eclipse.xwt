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
package org.eclipse.xwt.tests.view;

import org.eclipse.xwt.XWT;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Company company = new Company();
		Person person = new Person();
		person.setFirstName("Luc");
		person.setLastName("GAMEL");
		company.setName("Soyatec");
		company.setManager(person);

		try {
			XWT.open(Main.class.getResource("CompanyView.xwt"), company);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
