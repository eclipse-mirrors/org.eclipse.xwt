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
package org.eclipse.xwt.tools.ui.palette.page.editparts;

import org.eclipse.draw2d.FocusEvent;
import org.eclipse.draw2d.FocusListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.xwt.tools.ui.palette.page.editparts.figures.PaletteDrawerFigure;
import org.eclipse.gef.internal.ui.palette.editparts.DrawerEditPart;
import org.eclipse.gef.palette.PaletteDrawer;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
@SuppressWarnings("restriction")
public class PaletteDrawerEditPart extends DrawerEditPart {

	/**
	 * @param drawer
	 */
	public PaletteDrawerEditPart(PaletteDrawer drawer) {
		super(drawer);
	}

	public IFigure createFigure() {
		if (getParent() instanceof PaletteDrawerEditPart) {
			PaletteDrawerFigure fig = new PaletteDrawerFigure(getViewer().getControl());
			fig.setExpanded(getModel().isInitiallyOpen());
			fig.setPinned(getModel().isInitiallyPinned());
			fig.getCollapseToggle().addFocusListener(new FocusListener.Stub() {
				public void focusGained(FocusEvent fe) {
					getViewer().select(PaletteDrawerEditPart.this);
				}
			});
			return fig;
		}
		return super.createFigure();
	}
}
