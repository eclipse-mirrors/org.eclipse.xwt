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
package org.eclipse.xwt.tools.ui.palette.request;

import org.eclipse.xwt.tools.ui.palette.Entry;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gef.requests.CreationFactory;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class EntryCreationFactory implements CreationFactory {

	private Entry entry;

	/**
	 * 
	 */
	public EntryCreationFactory(Entry entry) {
		this.entry = entry;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.requests.CreationFactory#getNewObject()
	 */
	public Object getNewObject() {
		return entry;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.requests.CreationFactory#getObjectType()
	 */
	public Object getObjectType() {
		if (entry == null) {
			return null;
		}
		EClass type = entry.getType();
		if (type != null) {
			return type;
		}
		return entry.getScope();
	}

	public Entry getEntry() {
		return entry;
	}
}
