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
package org.eclipse.xwt.tools.ui.designer.editor.text.assist;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xwt.tools.ui.designer.XWTDesignerPlugin;
import org.eclipse.xwt.tools.ui.designer.core.editor.text.assist.SelectionCompletionProposal;
import org.eclipse.xwt.tools.ui.designer.editor.XWTDesigner;

public class XWTSelectionCompletionProposal extends SelectionCompletionProposal {

	/**
	 * constructor
	 * 
	 * @param replacementString
	 * @param replacementOffset
	 * @param replacementLength
	 * @param cursorPosition
	 * @param selectionLength
	 * @param image
	 * @param displayString
	 * @param contextInformation
	 * @param additionalProposalInfo
	 */
	public XWTSelectionCompletionProposal(String replacementString, int replacementOffset, int replacementLength, int cursorPosition, int selectionLength, Image image, String displayString, IContextInformation contextInformation, String additionalProposalInfo) {
		super(replacementString, replacementOffset, replacementLength, cursorPosition, selectionLength, image, displayString, contextInformation, additionalProposalInfo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.soyatec.xaml.ve.contentassist.SelectionCompletionProposal#apply(org.eclipse.jface.text.IDocument)
	 */
	public void apply(final IDocument document) {
		XWTDesigner activeDesigner = XWTDesignerPlugin.getDefault().getActiveDesigner();
		if (activeDesigner != null) {
			activeDesigner.formatWithCompound(new Runnable() {
				public void run() {
					XWTSelectionCompletionProposal.super.apply(document);
				}
			});
		} else {
			super.apply(document);
		}
	}
}
