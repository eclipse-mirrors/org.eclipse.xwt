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
package org.eclipse.xwt.tools.ui.designer.core.editor;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public interface IVisualRenderer extends IVisualFactory {

	/**
	 * Key value of the render.
	 */
	String KEY = "org.eclipse.e4.tools.ui.designer.editor.VisualsRender";

	/**
	 * Create all visuals when the document is loaded.
	 * 
	 * @return TODO
	 */
	Result createVisuals();

	/**
	 * Return the notify component, so that the we can get an correct editpart to refresh.
	 * 
	 * @param source
	 * @return
	 */
	Result refreshVisuals(Object source);

	/**
	 * Dispose at the end.
	 */
	void dispose();

	/**
	 * Return the host class name.
	 * 
	 * @return
	 */
	String getHostClassName();

	/**
	 * Return the root component.
	 */
	Object getRoot();

	public class Result {
		public Object visuals;
		public boolean refreshed = false;

		public Result(Object visuals) {
			this.visuals = visuals;
		}

		public Result(Object visuals, boolean refreshed) {
			this(visuals);
			this.refreshed = refreshed;
		}

		public boolean isRefreshed() {
			return refreshed && visuals != null;
		}

		public static Result NONE = new Result(null, false);
	}
}
