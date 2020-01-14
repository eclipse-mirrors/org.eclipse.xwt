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
package org.eclipse.xwt.emf.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class EMFTestSuite extends TestSuite {
	public static final Test suite() {
		return new EMFTestSuite();
	}

	/**
	 * The execution of the tests must be started from simple to complex in
	 * order.
	 */
	public EMFTestSuite() {
		addTest(new TestSuite(EMFTestCase.class));
	}
}
