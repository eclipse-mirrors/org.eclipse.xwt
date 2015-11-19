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
package org.eclipse.xwt.tests.databinding.pojo.attribute;

public class Company {
	private String NAME = "Soyatec";

	public void setNAME(String value) {
		this.NAME = value;
	}

	public String getNAME() {
		return NAME;
	}
}
