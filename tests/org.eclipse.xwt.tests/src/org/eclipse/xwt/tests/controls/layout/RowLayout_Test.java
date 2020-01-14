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

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;

public class RowLayout_Test {
	public static void main(String[] args) {

		URL url = RowLayout_Test.class.getResource(RowLayout_Test.class
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

	protected void updateTypeHorizontal(Event event) {
		Button widget = (Button) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			RowLayout layout = (RowLayout) layGroup.getLayout();
			layout.type = SWT.HORIZONTAL;
			layout(layGroup);
		}
	}

	protected void updateTypeVertical(Event event) {
		Button widget = (Button) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			RowLayout layout = (RowLayout) layGroup.getLayout();
			layout.type = SWT.VERTICAL;
			layout(layGroup);
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
			RowLayout layout = (RowLayout) layGroup.getLayout();
			layout.marginWidth = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updateMarginHeight(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			RowLayout layout = (RowLayout) layGroup.getLayout();
			layout.marginHeight = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updateMarginLeft(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			RowLayout layout = (RowLayout) layGroup.getLayout();
			layout.marginLeft = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updateMarginRight(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			RowLayout layout = (RowLayout) layGroup.getLayout();
			layout.marginRight = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updateMarginTop(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			RowLayout layout = (RowLayout) layGroup.getLayout();
			layout.marginTop = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updateMarginBottom(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			RowLayout layout = (RowLayout) layGroup.getLayout();
			layout.marginBottom = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updateSpacing(Event event) {
		Spinner widget = (Spinner) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			RowLayout layout = (RowLayout) layGroup.getLayout();
			layout.spacing = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updatePropWrap(Event event) {
		Button widget = (Button) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			RowLayout layout = (RowLayout) layGroup.getLayout();
			layout.wrap = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updatePropPack(Event event) {
		Button widget = (Button) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			RowLayout layout = (RowLayout) layGroup.getLayout();
			layout.pack = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updatePropJustify(Event event) {
		Button widget = (Button) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			RowLayout layout = (RowLayout) layGroup.getLayout();
			layout.justify = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updatePropFill(Event event) {
		Button widget = (Button) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			RowLayout layout = (RowLayout) layGroup.getLayout();
			layout.fill = widget.getSelection();
			layout(layGroup);
		}
	}

	protected void updatePropCenter(Event event) {
		Button widget = (Button) event.widget;
		Group layGroup = findGroup(widget);
		if (layGroup != null) {
			RowLayout layout = (RowLayout) layGroup.getLayout();
			layout.center = widget.getSelection();
			layout(layGroup);
		}
	}
}
