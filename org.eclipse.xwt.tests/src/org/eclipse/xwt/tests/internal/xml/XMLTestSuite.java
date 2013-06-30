/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.xwt.tests.internal.xml;

import junit.framework.Test;
import junit.framework.TestSuite;

public class XMLTestSuite extends TestSuite {
	public static final Test suite() {
		return new XMLTestSuite();
	}

	public XMLTestSuite() {
		addTest(new TestSuite(XMLTests.class));
	}
}
