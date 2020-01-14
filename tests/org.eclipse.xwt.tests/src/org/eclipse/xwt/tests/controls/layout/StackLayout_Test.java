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
package org.eclipse.xwt.tests.controls.layout;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;

public class StackLayout_Test {
	public static void main(String[] args) {

		URL url = StackLayout_Test.class.getResource(StackLayout_Test.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.open(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Group findGroup(Widget widget) {
		if (widget == null) {
			return null;
		}
		if (widget instanceof Composite) {
			Composite composite = (Composite) widget;
			for (Control child : composite.getChildren()) {
				if (child instanceof Group
						&& (("layout".equals(((Group) child).getText())))) {
					return ((Group) child);
				}
			}
			return findGroup(composite.getParent());
		} else if (widget instanceof Control) {
			return findGroup(((Control) widget).getParent());
		}
		return null;
	}

	private static Group layoutGrp;
	private static Control current;
	private static List<Control> controls = new ArrayList<Control>();

	protected void updateStackAbove(Event event) {
		Button widget = (Button) event.widget;
		layoutGrp = findGroup(widget);
		if (layoutGrp != null) {
			if (controls.isEmpty()) {
				controls.addAll(Arrays.asList(layoutGrp.getChildren()));
			}
			StackLayout layout = (StackLayout) layoutGrp.getLayout();
			if (current == null) {
				current = controls.get(controls.size() - 1);
			} else {
				int index = controls.indexOf(current);
				if (index > 0) {
					current = controls.get(index - 1);
				}
			}
			layout.topControl = current;
			Label label = findLabel(widget);
			if (label != null) {
				label.setText(((Button) current).getText());
			}
			layout(layoutGrp);
		}
	}

	private Label findLabel(Button widget) {
		Control[] children = widget.getParent().getChildren();
		for (Control control : children) {
			if (control instanceof Label) {
				return ((Label) control);
			}
		}
		return null;
	}

	protected void updateStackBelow(Event event) {
		Button widget = (Button) event.widget;
		layoutGrp = findGroup(widget);
		if (layoutGrp != null) {
			if (controls.isEmpty()) {
				controls.addAll(Arrays.asList(layoutGrp.getChildren()));
			}
			StackLayout layout = (StackLayout) layoutGrp.getLayout();
			if (current == null) {
				current = controls.get(0);
			} else {
				int index = controls.indexOf(current);
				if (index < controls.size() - 1) {
					current = controls.get(index + 1);
				}
			}
			layout.topControl = current;
			Label label = findLabel(widget);
			if (label != null) {
				label.setText(((Button) current).getText());
			}
			layout(layoutGrp);
		}
	}

	private void layout(Composite composite) {
		if (composite != null) {
			composite.layout(true, true);
			layout(composite.getParent());
		}
	}

	protected void updateMarginWidth(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			StackLayout layout = (StackLayout) layGroup.getLayout();
			layout.marginWidth = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updateMarginHeight(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			StackLayout layout = (StackLayout) layGroup.getLayout();
			layout.marginHeight = widget.getSelection();
			layout(layGroup);
		}
	}
}
