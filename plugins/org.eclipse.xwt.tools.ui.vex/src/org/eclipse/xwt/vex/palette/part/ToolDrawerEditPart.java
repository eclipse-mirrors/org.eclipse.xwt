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
package org.eclipse.xwt.vex.palette.part;

import org.eclipse.draw2d.FocusEvent;
import org.eclipse.draw2d.FocusListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.internal.ui.palette.editparts.DrawerEditPart;
import org.eclipse.gef.palette.PaletteDrawer;

/**
 * 
 */
public class ToolDrawerEditPart extends DrawerEditPart {

	private int childLevel = 0;

	public ToolDrawerEditPart(PaletteDrawer drawer) {
		super(drawer);
	}

	public IFigure createFigure() {
		if (getParent() instanceof ToolDrawerEditPart) {
			ToolDrawerEditPart parent = (ToolDrawerEditPart) getParent();
			childLevel = parent.childLevel + 1;

			ToolDrawerFigure fig = new ToolDrawerFigure(getViewer().getControl(), childLevel) {

				IFigure buildTooltip() {
					return createToolTip();
				}
			};
			fig.setExpanded(getModel().isInitiallyOpen());
			fig.setPinned(getModel().isInitiallyPinned());

			fig.getCollapseToggle().addFocusListener(new FocusListener.Stub() {

				public void focusGained(FocusEvent fe) {
					getViewer().select(ToolDrawerEditPart.this);
				}
			});

			return fig;
		}
		return super.createFigure();
	}

}
