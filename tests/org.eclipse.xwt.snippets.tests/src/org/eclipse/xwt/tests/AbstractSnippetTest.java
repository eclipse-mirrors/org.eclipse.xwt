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
 *     Erdal Karaca - refactored to use base class
 *******************************************************************************/
package org.eclipse.xwt.tests;

import org.eclipse.xwt.snippets.XWTSnippet;
import org.junit.Before;

public abstract class AbstractSnippetTest extends XWTTestCase {
	private XWTSnippet snippet;

	protected abstract XWTSnippet doGetSnippet();

	public XWTSnippet getSnippet() {
		if (snippet == null) {
			snippet = doGetSnippet();
		}

		return snippet;
	}

	@Before
	public void setUp() {
		getSnippet().load();
	}

	@SuppressWarnings("unchecked")
	protected <T> T getRoot(Class<T> t) {
		Object root = getSnippet().getRoot();
		assertTrue(root != null);
		assertTrue(t.isAssignableFrom(root.getClass()));
		return (T) root;
	}
}
