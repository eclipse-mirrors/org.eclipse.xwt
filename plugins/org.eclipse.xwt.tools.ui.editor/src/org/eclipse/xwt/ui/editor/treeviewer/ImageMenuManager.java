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
package org.eclipse.xwt.ui.editor.treeviewer;

import java.lang.reflect.Field;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.xwt.ui.utils.ImageManager;

public class ImageMenuManager extends MenuManager {
	protected ImageDescriptor imageDescriptor;

	public ImageMenuManager() {
	}

	public ImageMenuManager(String text, ImageDescriptor imageDescriptor) {
		super(text);
		this.imageDescriptor = imageDescriptor;
	}

	public ImageMenuManager(String text, String id, ImageDescriptor imageDescriptor) {
		super(text, id);
		this.imageDescriptor = imageDescriptor;
	}

	@Override
	public void fill(Menu parent, int index) {
		super.fill(parent, index);
		if (imageDescriptor != null) {
			try {
				Field field = MenuManager.class.getDeclaredField("menuItem");
				field.setAccessible(true);
				Object object = field.get(this);
				if (object instanceof MenuItem) {
					MenuItem menuItem = (MenuItem) object;
					menuItem.setImage(ImageManager.getImage(imageDescriptor));
				}
			} catch (Exception e) {
				throw new IllegalStateException("The field MenuManager.menuItem is not found. Maybe the version of SWT chnaged.");
			}
		}
	}
}
