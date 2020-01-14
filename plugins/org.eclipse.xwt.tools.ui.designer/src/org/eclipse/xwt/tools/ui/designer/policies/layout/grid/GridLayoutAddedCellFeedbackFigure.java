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
package org.eclipse.xwt.tools.ui.designer.policies.layout.grid;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.swt.SWT;

/**
 * Feedback figure to show outer line of an added cell outside the grid.
 * 
 * @since 1.2.0
 */
public class GridLayoutAddedCellFeedbackFigure extends RectangleFigure {

	public GridLayoutAddedCellFeedbackFigure() {
		super();
		setLineStyle(SWT.LINE_DASH);
		setLineWidth(2);
		setForegroundColor(ColorConstants.yellow);
		setFill(false);
	}

}
