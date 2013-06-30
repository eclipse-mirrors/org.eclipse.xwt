/*******************************************************************************
 * Copyright (c) 2013 Eclipse XWT Project.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Erdal Karaca - initial API and implementation
 ******************************************************************************/
package org.eclipse.xwt.e4.internal.widgets;

import org.eclipse.swt.widgets.Composite;

public class PageBookItem extends Composite {
	private PageBook pageBook;
	private boolean makingVisible = false;

	public PageBookItem(Composite parent, int style) {
		super(parent, style);

		if (parent instanceof PageBook) {
			this.pageBook = (PageBook) parent;
		}
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);

		if (visible && !makingVisible) {
			try {
				makingVisible = true;
				pageBook.showPage(this);
			} finally {
				makingVisible = false;
			}
		}
	}
}
