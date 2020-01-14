/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.forms;

import org.eclipse.xwt.tests.forms.tableviewer.master.detail.set.Forms_TableViewer_Set_MasterDetail_Tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class FormsTestSuite extends TestSuite {
	public static final Test suite() {
		return new FormsTestSuite();
	}

	public FormsTestSuite() {
		addTest(new TestSuite(FormsTests.class));
		addTest(new TestSuite(Forms_TableViewer_Set_MasterDetail_Tests.class));
	}
}
