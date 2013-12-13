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
package org.eclipse.xwt.tools.ui.designer.layouts.control;

public class FieldEditorEvent {

	public FieldEditor editor;
	public String field;
	public String oldValue;
	public String newVlaue;

	public boolean doit = false;

	public FieldEditorEvent(FieldEditor editor, String field, String oldValue, String newValue) {
		this.editor = editor;
		this.field = field;
		this.oldValue = oldValue;
		this.newVlaue = newValue;
	}
}
