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
package org.eclipse.xwt.emf.test.modelmix;

import org.eclipse.emf.ecore.EObject;

public class Author {
	private String name;
	private EObject content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EObject getContent() {
		return content;
	}

	public void setContent(EObject content) {
		this.content = content;
	}
}
