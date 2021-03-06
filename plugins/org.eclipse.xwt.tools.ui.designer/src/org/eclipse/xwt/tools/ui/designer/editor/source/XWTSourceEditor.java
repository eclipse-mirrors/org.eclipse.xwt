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
package org.eclipse.xwt.tools.ui.designer.editor.source;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.eclipse.xwt.tools.ui.designer.core.ceditor.ISourcePage;
import org.eclipse.xwt.tools.ui.designer.model.XamlDocumentProvider;
import org.eclipse.xwt.tools.ui.xaml.XamlDocument;

/**
 * @author Jin Liu(jin.liu@soyatec.com)
 */
public class XWTSourceEditor extends StructuredTextEditor implements
		ISourcePage {

	private XamlDocument document;

	public String getPageName() {
		return "Source";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xwt.tools.ui.designer.core.editor.ISourcePage#isEnabled()
	 */
	public boolean isEnabledFor(IEditorPart editorPart) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xwt.tools.ui.designer.core.editor.ISourcePage#
	 * configureSourcePage(org.eclipse.ui.IEditorPart)
	 */
	public void configureSourcePage(IEditorPart editorPart) {
		setEditorPart(editorPart);
		initializeDocument();
	}

	private void initializeDocument() {
		IEditorInput editorInput = getEditorInput();
		if (editorInput instanceof IFileEditorInput) {
			IFile file = ((IFileEditorInput) editorInput).getFile();
			document = XamlDocumentProvider.getDocument(file);
		}
		if (document != null) {
			connect();
		}
	}

	private void connect() {

	}

}
