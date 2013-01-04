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

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;

public class GridLayout_Test {
	public static void main(String[] args) {

		URL url = GridLayout_Test.class.getResource(GridLayout_Test.class
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

	protected void updateNumColumns(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			GridLayout layout = (GridLayout) layGroup.getLayout();
			layout.numColumns = widget.getSelection();
			layout(layGroup);
		}
	}

	private void layout(Composite composite) {
		if (composite != null) {
			composite.layout(true, true);
			layout(composite.getParent());
		}
	}

	protected void updateMakeColunsEqual(Event event) {
		Button widget = (Button) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			GridLayout layout = (GridLayout) layGroup.getLayout();
			layout.makeColumnsEqualWidth = widget.getSelection();
			for (Control control : layGroup.getChildren()) {
				control.setLayoutData(null);
			}
			layout(layGroup);
		}
	}

	protected void updateMarginWidth(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			GridLayout layout = (GridLayout) layGroup.getLayout();
			layout.marginWidth = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updateMarginHeight(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			GridLayout layout = (GridLayout) layGroup.getLayout();
			layout.marginHeight = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updateMarginLeft(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			GridLayout layout = (GridLayout) layGroup.getLayout();
			layout.marginLeft = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updateMarginRight(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			GridLayout layout = (GridLayout) layGroup.getLayout();
			layout.marginRight = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updateMarginTop(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			GridLayout layout = (GridLayout) layGroup.getLayout();
			layout.marginTop = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updateMarginBottom(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			GridLayout layout = (GridLayout) layGroup.getLayout();
			layout.marginBottom = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updateHSpacing(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			GridLayout layout = (GridLayout) layGroup.getLayout();
			layout.horizontalSpacing = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updateVSpacing(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			GridLayout layout = (GridLayout) layGroup.getLayout();
			layout.verticalSpacing = widget.getSelection();
			layout(layGroup);
		}
	}
}
