/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.databinding.others;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * @author jliu jin.liu@soyatec.com
 */
public class DataFactory {

	private boolean visible = true;
	private boolean enabled = true;
	private String text = "text";
	private Color background = Display.getCurrent().getSystemColor(
			SWT.COLOR_DARK_GRAY);
	private Color foreground = Display.getCurrent().getSystemColor(
			SWT.COLOR_DARK_RED);

	/**
	 * @param visible
	 *            the visible to set
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param background
	 *            the background to set
	 */
	public void setBackground(Color background) {
		this.background = background;
	}

	/**
	 * @return the background
	 */
	public Color getBackground() {
		return background;
	}

	/**
	 * @param foreground
	 *            the foreground to set
	 */
	public void setForeground(Color foreground) {
		this.foreground = foreground;
	}

	/**
	 * @return the foreground
	 */
	public Color getForeground() {
		return foreground;
	}
}
