/*******************************************************************************
 * Copyright (c) 2006, 2014 Soyatec (http://www.soyatec.com) and others.
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
package org.eclipse.xwt.ui.workbench.properties;

import org.eclipse.core.runtime.Assert;
import org.eclipse.ui.views.properties.tabbed.AbstractTabDescriptor;

public class XWTTabDescriptor extends AbstractTabDescriptor {

	private String id;
	private String label;
	private String category;

	public XWTTabDescriptor(String id, String label, String category) {
		Assert.isNotNull(id, "Tab id can not be null");
		this.id = id;
		this.category = category;
		this.label = label;
	}

	public String getCategory() {
		return category;
	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

}
