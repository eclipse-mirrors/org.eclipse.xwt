/*******************************************************************************
 * Copyright (c) 2006, 2010 The Pampered Chef, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Coconut Palm Software, Inc. - Initial API and implementation
 *     Matthew Hall - bugs 260329, 260337
 *     Yves YANG - port to XWT
 ******************************************************************************/

package org.eclipse.xwt.tests.snippet017;

import java.net.URL;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;

/**
 * Demonstrates binding a TableViewer to a collection.
 */
public class TableViewerWithDerivedColumns {
	public static void main(String[] args) {
		ViewModel viewModel = new ViewModel();
		URL url = TableViewerWithDerivedColumns.class.getResource(TableViewerWithDerivedColumns.class.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.open(url, viewModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static Person UNKNOWN = new Person("unknown", null, null);
}
