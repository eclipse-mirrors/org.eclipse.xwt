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
package org.eclipse.xwt.tools.ui.designer.editor.problems;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xwt.tools.ui.designer.core.editor.Designer;
import org.eclipse.xwt.tools.ui.designer.core.problems.DesignerProblemChecker;
import org.eclipse.xwt.tools.ui.designer.core.problems.Problem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public abstract class XWTAbstractNodeChecker extends DesignerProblemChecker {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.tools.designer.problems.IProblemChecker#doCheck()
	 */
	public List<Problem> doCheck() {
		Designer designer = getDesigner();
		if (designer == null) {
			return null;
		}
		IDocument document = designer.getDocument();
		if (document == null) {
			return null;
		}
		Document textDocument = getTextDocument(document);
		if (textDocument == null) {
			return null;
		}
		Element root = textDocument.getDocumentElement();
		if (root == null) {
			return null;
		}
		List<Problem> problems = new ArrayList<Problem>();
		checkNode(root, problems);
		return problems;
	}

	protected abstract void checkNode(Node node, List<Problem> problems);

}
