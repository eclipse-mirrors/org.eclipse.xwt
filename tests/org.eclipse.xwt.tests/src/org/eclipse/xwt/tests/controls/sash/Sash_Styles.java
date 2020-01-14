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
package org.eclipse.xwt.tests.controls.sash;

import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;

/**
 * @author jliu
 */
public class Sash_Styles {
	public static void main(String[] args) {
		URL url = Sash_Styles.class.getResource(Sash_Styles.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.open(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Constants */
	static final int SASH_WIDTH = 3;
	static final int SASH_LIMIT = 20;
	private Sash vSash;
	private Sash hSash;
	private Composite sashComp;
	private List list1;
	private List list2;
	private Text text;

	protected void handleVerticalMove(Event event) {
		checkInit(event);
		Rectangle rect = vSash.getParent().getClientArea();
		event.x = Math.min(Math.max(event.x, SASH_LIMIT), rect.width
				- SASH_LIMIT);
		if (event.detail != SWT.DRAG) {
			vSash.setBounds(event.x, event.y, event.width, event.height);
			layout();
		}
	}

	/**
	 * @param event
	 */
	private void checkInit(Event event) {
		if (vSash == null) {
			vSash = (Sash) XWT.findElementByName(event.widget, "vSash");
		}
		if (hSash == null) {
			hSash = (Sash) XWT.findElementByName(event.widget, "hSash");
		}
		if (sashComp == null) {
			sashComp = (Composite) XWT.findElementByName(event.widget,
					"sashComp");
		}
		if (list1 == null) {
			list1 = (List) XWT.findElementByName(event.widget, "list1");
		}
		if (list2 == null) {
			list2 = (List) XWT.findElementByName(event.widget, "list2");
		}
		if (text == null) {
			text = (Text) XWT.findElementByName(event.widget, "text");
		}
	}

	void layout() {

		Rectangle clientArea = sashComp.getClientArea();
		Rectangle hSashBounds = hSash.getBounds();
		Rectangle vSashBounds = vSash.getBounds();

		list1.setBounds(0, 0, vSashBounds.x, hSashBounds.y);
		list2.setBounds(vSashBounds.x + vSashBounds.width, 0, clientArea.width
				- (vSashBounds.x + vSashBounds.width), hSashBounds.y);
		text.setBounds(0, hSashBounds.y + hSashBounds.height, clientArea.width,
				clientArea.height - (hSashBounds.y + hSashBounds.height));

		/**
		 * If the horizontal sash has been moved then the vertical sash is
		 * either too long or too short and its size must be adjusted.
		 */
		vSashBounds.height = hSashBounds.y;
		vSash.setBounds(vSashBounds);
	}

	protected void handleHorizontalMove(Event event) {
		checkInit(event);
		Rectangle rect = vSash.getParent().getClientArea();
		event.y = Math.min(Math.max(event.y, SASH_LIMIT), rect.height
				- SASH_LIMIT);
		if (event.detail != SWT.DRAG) {
			hSash.setBounds(event.x, event.y, event.width, event.height);
			layout();
		}
	}

	protected void resized(Event event) {
		checkInit(event);
		/* Get the client area for the shell */
		Rectangle clientArea = sashComp.getClientArea();

		/*
		 * Make list 1 half the width and half the height of the tab leaving
		 * room for the sash. Place list 1 in the top left quadrant of the tab.
		 */
		Rectangle list1Bounds = new Rectangle(0, 0,
				(clientArea.width - SASH_WIDTH) / 2,
				(clientArea.height - SASH_WIDTH) / 2);
		list1.setBounds(list1Bounds);

		/*
		 * Make list 2 half the width and half the height of the tab leaving
		 * room for the sash. Place list 2 in the top right quadrant of the tab.
		 */
		list2.setBounds(list1Bounds.width + SASH_WIDTH, 0, clientArea.width
				- (list1Bounds.width + SASH_WIDTH), list1Bounds.height);

		/*
		 * Make the text area the full width and half the height of the tab
		 * leaving room for the sash. Place the text area in the bottom half of
		 * the tab.
		 */
		text.setBounds(0, list1Bounds.height + SASH_WIDTH, clientArea.width,
				clientArea.height - (list1Bounds.height + SASH_WIDTH));

		/* Position the sashes */
		vSash.setBounds(list1Bounds.width, 0, SASH_WIDTH, list1Bounds.height);
		hSash.setBounds(0, list1Bounds.height, clientArea.width, SASH_WIDTH);
	}
}
