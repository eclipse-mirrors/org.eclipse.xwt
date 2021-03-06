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

import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.xwt.internal.xml.Element;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class TableColumnEditorProperty extends AbstractProperty {

	public TableColumnEditorProperty() {
		super(PropertiesConstants.PROPERTY_EDITOR, Element.class);
	}

	public Object getValue(Object target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		TableColumn tableColumn = (TableColumn) target;
		return tableColumn.getData(PropertiesConstants.DATA_DEFINED_EDITOR);
	}

	public void setValue(Object target, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
		TableColumn tableColumn = (TableColumn) target;
		tableColumn.setData(PropertiesConstants.DATA_DEFINED_EDITOR, value);
	}

}
