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
package org.eclipse.xwt.tests.events;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.xwt.tests.events.initialize.EventsInitTests;
import org.eclipse.xwt.tests.events.loaded.EventsLoadedTests;
import org.eclipse.xwt.tests.events.loaded.multipleClass.MultipleClassLoadedTests;

public class EventsTestSuite extends TestSuite {
	public static final Test suite() {
		return new EventsTestSuite();
	}

	public EventsTestSuite() {
		addTest(new TestSuite(EventsTests.class));
		addTest(new TestSuite(EventsInitTests.class));
		addTest(new TestSuite(EventsLoadedTests.class));
		addTest(new TestSuite(MultipleClassLoadedTests.class));
	}
}
