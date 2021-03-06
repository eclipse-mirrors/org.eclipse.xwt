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
package org.eclipse.xwt.vex.templates;

import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.templates.DocumentTemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;

public abstract class VEXDocumentTemplateContext extends DocumentTemplateContext {
	static final String XMLNS = "xmlns";

	protected String defaultNamespace = null;

	protected HashMap<String, String> ns2Prefix = new HashMap<String, String>();
	protected HashSet<String> assemblies = new HashSet<String>();

	public VEXDocumentTemplateContext(TemplateContextType type, IDocument document, int offset, int length) {
		super(type, document, offset, length);
	}

	public VEXDocumentTemplateContext(TemplateContextType type, IDocument document, Position position) {
		super(type, document, position);
	}
}
