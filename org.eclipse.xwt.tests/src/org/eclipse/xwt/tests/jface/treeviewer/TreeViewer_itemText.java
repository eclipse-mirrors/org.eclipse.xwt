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
package org.eclipse.xwt.tests.jface.treeviewer;

import java.net.URL;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;

/**
 * @author jliu
 */
public class TreeViewer_itemText {
	public static void main(String[] args) {

		URL url = TreeViewer_itemText.class
				.getResource(TreeViewer_itemText.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.open(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
