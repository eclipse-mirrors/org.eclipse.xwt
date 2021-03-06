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

import java.util.EventListener;

/**
 * @author jliu jin.liu@soyatec.com
 */
public interface IGridListener extends EventListener {
	/**
	 * Grid Height has changed.
	 */
	public void gridHeightChanged(int gridHeight, int oldGridHeight);

	/**
	 * Grid Width has changed.
	 */
	public void gridWidthChanged(int gridWidth, int oldGridWidth);

	/**
	 * Grid Margin has changed.
	 */
	public void gridMarginChanged(int gridMargin, int oldGridMargin);

	/**
	 * Grid Visibility has changed.
	 */
	public void gridVisibilityChanged(boolean isShowing);
}
