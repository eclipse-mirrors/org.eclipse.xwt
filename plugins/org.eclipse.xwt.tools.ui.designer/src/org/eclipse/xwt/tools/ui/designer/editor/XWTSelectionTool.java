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
package org.eclipse.xwt.tools.ui.designer.editor;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.tools.SelectionTool;
import org.eclipse.xwt.tools.ui.designer.parts.SashEditPart;

public class XWTSelectionTool extends SelectionTool {

	public XWTSelectionTool() {
	}

	@Override
	protected boolean updateTargetUnderMouse() {
		EditPart editPart = getTargetEditPart();
		if (editPart == null) {
			setDefaultCursor(null);
			return super.updateTargetUnderMouse();
		}
		if (editPart instanceof SashEditPart) {
			SashEditPart sashEditPart = (SashEditPart) editPart;
			setDefaultCursor(sashEditPart.getDefaultCursor());
		}
		else {
			setDefaultCursor(null);
		}
		return super.updateTargetUnderMouse();
	}
}
