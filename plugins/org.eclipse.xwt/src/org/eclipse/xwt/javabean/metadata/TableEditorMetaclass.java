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
package org.eclipse.xwt.javabean.metadata;

import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xwt.IXWTLoader;
import org.eclipse.xwt.internal.utils.UserData;
import org.eclipse.xwt.metadata.IMetaclass;

public class TableEditorMetaclass extends Metaclass {

	public TableEditorMetaclass(IMetaclass superClass,IXWTLoader xwtLoader) {
		super(TableEditor.class, superClass,xwtLoader);
	}

	/**
	 * @see org.eclipse.xwt.javabean.metadata.Metaclass#newInstance(java.lang.
	 *      Object[])
	 */
	@Override
	public Object newInstance(Object[] parameters) {
		Object widget = parameters[0];
		if (parameters.length == 0 || !(widget instanceof Widget)) {
			throw new IllegalStateException("Table parent is missing.");
		}
		Table table = null;
		if (widget instanceof Table) {
			table = (Table) widget;
		} else {
			table = (Table) UserData.findParent((Widget) widget, Table.class);
		}
		if (table == null) {
			throw new IllegalStateException("Table parent is missing.");
		}
		return super.newInstance(new Object[] { table });
	}
}
