/*******************************************************************************
 * Copyright (c) 2013 Eclipse XWT Team
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Erdal Karaca - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.xwt.tests.base.HelloWorldSnippetTest;
import org.eclipse.xwt.tests.controls.ButtonVisibleSnippetTest;

public class XwtSnippetsTestSuite extends TestSuite {
	public static final Test suite() {
		return new XwtSnippetsTestSuite();
	}
	
	public XwtSnippetsTestSuite() {
		addBaseTests();
		addControlsTests();
	}

	private void addControlsTests() {
		addTest(new TestSuite(ButtonVisibleSnippetTest.class));
	}

	protected void addBaseTests() {
		addTest(new TestSuite(HelloWorldSnippetTest.class));
	}
}
