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
package org.eclipse.xwt.ui.editor;

import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;
import org.eclipse.wst.xml.ui.internal.taginfo.XMLTagInfoHoverProcessor;

public class XWTDocumentationTextHover extends XMLTagInfoHoverProcessor {

	public XWTDocumentationTextHover() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String computeTagAttNameHelp(IDOMNode xmlnode, IDOMNode parentNode, IStructuredDocumentRegion flatNode, ITextRegion region) {
		// TODO Auto-generated method stub
		return super.computeTagAttNameHelp(xmlnode, parentNode, flatNode, region);
	}

	@Override
	protected String computeTagAttValueHelp(IDOMNode xmlnode, IDOMNode parentNode, IStructuredDocumentRegion flatNode, ITextRegion region) {
		// TODO Auto-generated method stub
		return super.computeTagAttValueHelp(xmlnode, parentNode, flatNode, region);
	}

	@Override
	protected String computeTagNameHelp(IDOMNode xmlnode, IDOMNode parentNode, IStructuredDocumentRegion flatNode, ITextRegion region) {
		// TODO Auto-generated method stub
		return super.computeTagNameHelp(xmlnode, parentNode, flatNode, region);
	}
}
