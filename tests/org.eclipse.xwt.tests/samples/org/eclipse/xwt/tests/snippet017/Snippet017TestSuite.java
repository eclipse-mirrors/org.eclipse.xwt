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
package org.eclipse.xwt.tests.snippet017;

import junit.framework.Test;
import junit.framework.TestSuite;

public class Snippet017TestSuite extends TestSuite {
	public static final Test suite() {
		return new Snippet017TestSuite();
	}

	public Snippet017TestSuite() {
		addTest(new TestSuite(Snippet017Tests.class));
		addTest(new TestSuite(org.eclipse.xwt.tests.snippet017.inner.Snippet017Tests.class));
		addTest(new TestSuite(org.eclipse.xwt.tests.snippet017.pojo.Snippet017Tests.class));
	}
}
