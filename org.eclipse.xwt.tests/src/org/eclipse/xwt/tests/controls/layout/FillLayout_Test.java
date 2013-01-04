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
package org.eclipse.xwt.tests.controls.layout;

import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;

public class FillLayout_Test {
	public static void main(String[] args) {

		URL url = FillLayout_Test.class.getResource(FillLayout_Test.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.open(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Group findGroup(Widget widget) {
		if (widget instanceof Control) {
			Control control = (Control) widget;
			Composite parent = control.getParent();
			for (Control child : parent.getChildren()) {
				if (child instanceof Group
						&& (("layout".equals(((Group) child).getText())))) {
					return ((Group) child);
				}
			}
			return findGroup(parent.getParent());
		}
		return null;
	}

	private void layout(Composite composite) {
		if (composite != null) {
			composite.layout(true, true);
			layout(composite.getParent());
		}
	}

	protected void updateTypeHorizontal(Event event) {
		Button widget = (Button) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			FillLayout layout = (FillLayout) layGroup.getLayout();
			layout.type = SWT.HORIZONTAL;
			layout(layGroup);
		}
	}

	protected void updateTypeVertical(Event event) {
		Button widget = (Button) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			FillLayout layout = (FillLayout) layGroup.getLayout();
			layout.type = SWT.VERTICAL;
			layout(layGroup);
		}
	}

	protected void updateMarginWidth(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			FillLayout layout = (FillLayout) layGroup.getLayout();
			layout.marginWidth = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updateMarginHeight(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			FillLayout layout = (FillLayout) layGroup.getLayout();
			layout.marginHeight = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updateSpacing(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			FillLayout layout = (FillLayout) layGroup.getLayout();
			layout.spacing = widget.getSelection();
			layout(layGroup);
		}
	}
}
