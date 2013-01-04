/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.controls.uiresource;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.xwt.tests.controls.button.ButtonTests;
import org.eclipse.xwt.tests.controls.ccombo.CComboTests;
import org.eclipse.xwt.tests.controls.combo.ComboTests;
import org.eclipse.xwt.tests.controls.shell.ShellTests;
import org.eclipse.xwt.tests.controls.tree.TreeTests;

public class UIResourceTestSuite extends TestSuite {
	public static final Test suite() {
		return new UIResourceTestSuite();
	}

	public UIResourceTestSuite() {
		addTest(new TestSuite(UIResourceTests.class));
		addTest(new TestSuite(ButtonTests.class));
		addTest(new TestSuite(ComboTests.class));
		addTest(new TestSuite(CComboTests.class));
		addTest(new TestSuite(ShellTests.class));
		addTest(new TestSuite(TreeTests.class));
	}
}
