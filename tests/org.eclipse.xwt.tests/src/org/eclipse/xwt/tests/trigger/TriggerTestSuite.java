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
package org.eclipse.xwt.tests.trigger;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.xwt.tests.trigger.datatrigger.DataTriggerTests;
import org.eclipse.xwt.tests.trigger.multidatatrigger.MultiDataTriggerTests;
import org.eclipse.xwt.tests.trigger.multitrigger.MultiTriggerTests;

public class TriggerTestSuite extends TestSuite {
	public static final Test suite() {
		return new TriggerTestSuite();
	}

	public TriggerTestSuite() {
		addTest(new TestSuite(OperatorHelperTest.class));
		addTest(new TestSuite(TriggerTests.class));
		addTest(new TestSuite(MultiTriggerTests.class));
		addTest(new TestSuite(DataTriggerTests.class));
		addTest(new TestSuite(MultiDataTriggerTests.class));
	}
}
