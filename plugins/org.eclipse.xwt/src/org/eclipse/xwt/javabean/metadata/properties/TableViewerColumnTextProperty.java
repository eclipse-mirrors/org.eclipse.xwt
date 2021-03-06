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
package org.eclipse.xwt.javabean.metadata.properties;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.TableColumn;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class TableViewerColumnTextProperty extends AbstractProperty {

	public TableViewerColumnTextProperty() {
		super(PropertiesConstants.PROPERTY_TEXT, String.class);
	}

	@Override
	public Object getValue(Object target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		return null;
	}

	@Override
	public void setValue(Object target, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		TableViewerColumn tableViewerColumn = (TableViewerColumn) target;
		TableColumn tableColumn = tableViewerColumn.getColumn();
		String text = (String) value;
		tableColumn.setText(text);
	}
}
