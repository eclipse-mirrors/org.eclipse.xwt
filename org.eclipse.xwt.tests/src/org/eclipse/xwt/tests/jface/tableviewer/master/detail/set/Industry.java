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
package org.eclipse.xwt.tests.jface.tableviewer.master.detail.set;

import java.util.Set;

/**
 * 
 * @author yyang
 */
public class Industry {
	protected String name;
	protected Set<Company> members;

	public Set<Company> getMembers() {
		return members;
	}

	public void setMembers(Set<Company> members) {
		this.members = members;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
