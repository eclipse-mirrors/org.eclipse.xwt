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
package org.eclipse.xwt.tests.controls.tooltip;

import java.lang.reflect.Method;
import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.XWTMaps;

/**
 * @author jliu
 */
public class ToolTip_Styles {

	private Button button;
	private static ToolTip toolTip;
	private static Tray tray;
	private static TrayItem trayItem;

	public static void main(String[] args) {

		URL url = ToolTip_Styles.class.getResource(ToolTip_Styles.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.open(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void clear(Event event) {
		if (toolTip != null && !toolTip.isDisposed()) {
			toolTip.setVisible(false);
			toolTip.dispose();
		}
		if (trayItem != null && !trayItem.isDisposed()) {
			trayItem.dispose();
		}
	}

	protected void showTooltip(Event event) {
		clear(event);
		button = (Button) event.widget;
		int style = 0;
		String text = "Tooltip Text";
		String message = "ToolTip Messages";
		boolean autoHide = false;
		boolean showInTray = false;

		// 1. Style
		Group stypesGroup = findGroup("groupStyles");
		if (stypesGroup != null) {
			style = createStyle(stypesGroup);
		}
		// 2. Display Mode
		Group displayGrp = findGroup("displayMode");
		if (displayGrp != null) {
			Control[] children = displayGrp.getChildren();
			for (Control control : children) {
				if (control instanceof Button) {
					Button btn = (Button) control;
					if ("AutoHide".equals(btn.getText())) {
						autoHide = btn.getSelection();
					} else if ("Show In Tray".equals(btn.getText())) {
						showInTray = btn.getSelection();
					}
				}
			}
		}
		// 3. Text
		Group textGroup = findGroup("groupText");
		if (textGroup != null) {
			Control[] children = textGroup.getChildren();
			for (Control control : children) {
				if (control instanceof Text) {
					text = ((Text) control).getText();
				}
			}
		}
		// 3. Message
		Group messageGrp = findGroup("groupMessage");
		if (messageGrp != null) {
			Control[] children = messageGrp.getChildren();
			for (Control control : children) {
				if (control instanceof Text) {
					message = ((Text) control).getText();
				}
			}
		}
		if (toolTip != null) {
			toolTip.dispose();
		}
		toolTip = new ToolTip(button.getShell(), style);
		toolTip.setText(text);
		toolTip.setMessage(message);
		toolTip.setAutoHide(autoHide);

		if (showInTray) {
			if (tray == null) {
				tray = displayGetSystemTray(button.getDisplay());
			}
			if (trayItem != null) {
				trayItem.dispose();
			}
			trayItem = new TrayItem(tray, SWT.NONE);
			trayItem.setToolTip(toolTip);
		}
		toolTip.setVisible(true);
	}

	/**
	 * @param stypesGroup
	 * @return
	 */
	private int createStyle(Group stypesGroup) {
		int style = 0;
		Control[] children = stypesGroup.getChildren();
		for (Control control : children) {
			if (control instanceof Button) {
				Button btn = (Button) control;
				if (!btn.getSelection()) {
					continue;
				}
				String text = btn.getText();
				if ("SWT.BALLOON".equals(text)) {
					style |= XWTMaps.getStyle("SWT.BALLOON");
				} else if ("SWT.ICON_INFORMATION".equals(text)) {
					style |= SWT.ICON_INFORMATION;
				} else if ("SWT.ICON_ERROR".equals(text)) {
					style |= SWT.ICON_ERROR;
				} else if ("SWT.ICON_WARNING".equals(text)) {
					style |= SWT.ICON_WARNING;
				}
			}
		}
		return style;
	}

	private Group findGroup(String grpName) {
		if (button == null) {
			return null;
		}
		return (Group) XWT.findElementByName(button, grpName);
	}

	private Tray displayGetSystemTray(Display display) {
		if(SWT.getPlatform()!="rap") {
			try {
				Method m = Display.class.getDeclaredMethod("getSystemTray");
				return (Tray)m.invoke(display);
			} catch (Exception e) {
				assert false;
			}
		}
		return null;
	}

}
