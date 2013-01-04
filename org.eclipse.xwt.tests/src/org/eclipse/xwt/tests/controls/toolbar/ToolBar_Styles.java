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
package org.eclipse.xwt.tests.controls.toolbar;

import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.XWTMaps;

/**
 * @author jliu
 */
public class ToolBar_Styles {
	public static void main(String[] args) {

		URL url = ToolBar_Styles.class.getResource(ToolBar_Styles.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.open(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Menu menu;

	protected void handleDropDown(Event event) {
		ToolItem toolItem = (ToolItem) event.widget;
		Shell shell = toolItem.getParent().getShell();
		// Create the menu if it has not already been created
		if (menu == null) {
			// Lazy create the menu.
			ToolBar toolbar = ((ToolItem) toolItem).getParent();
			int style = toolbar.getStyle()
					& (XWTMaps.getStyle("SWT.RIGHT_TO_LEFT") | SWT.LEFT_TO_RIGHT);
			menu = new Menu(shell, style | SWT.POP_UP);
			for (int i = 0; i < 9; ++i) {
				final String text = "Drop Down " + i;
				if (text.length() != 0) {
					MenuItem menuItem = new MenuItem(menu, SWT.NONE);
					menuItem.setText(text);
				} else {
					new MenuItem(menu, SWT.SEPARATOR);
				}
			}
		}

		/**
		 * A selection event will be fired when a drop down tool item is
		 * selected in the main area and in the drop down arrow. Examine the
		 * event detail to determine where the widget was selected.
		 */
		if (event.detail == SWT.ARROW) {
			/*
			 * The drop down arrow was selected.
			 */
			// Position the menu below and vertically aligned with the the drop
			// down tool button.
			final ToolBar toolBar = toolItem.getParent();

			Point point = toolBar.toDisplay(new Point(event.x, event.y));
			menu.setLocation(point.x, point.y);
			menu.setVisible(true);
		}
	}
}
