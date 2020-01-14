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
package org.eclipse.xwt.tests.metaclass;

import junit.framework.TestCase;

import org.eclipse.xwt.javabean.metadata.AbstractMetaclass;
import org.eclipse.xwt.metadata.IObjectInitializer;

public class Metaclass_Tests extends TestCase {

	public void testInitilaizers() {
		AbstractMetaclass metaclass = new AbstractMetaclass() {
		};

		IObjectInitializer initializer1 = new IObjectInitializer() {
			public void initialize(Object object) {
			}
		};

		IObjectInitializer initializer2 = new IObjectInitializer() {
			public void initialize(Object object) {
			}
		};

		IObjectInitializer initializer3 = new IObjectInitializer() {
			public void initialize(Object object) {
			}
		};

		metaclass.addInitializer(initializer1);

		assertEquals(metaclass.getInitializers().length, 1);

		metaclass.addInitializer(initializer1);
		assertEquals(metaclass.getInitializers().length, 1);

		metaclass.addInitializer(initializer2);
		assertEquals(metaclass.getInitializers().length, 2);
		assertEquals(metaclass.getInitializers()[0], initializer1);
		assertEquals(metaclass.getInitializers()[1], initializer2);

		metaclass.addInitializer(initializer3);
		assertEquals(metaclass.getInitializers().length, 3);
		assertEquals(metaclass.getInitializers()[0], initializer1);
		assertEquals(metaclass.getInitializers()[1], initializer2);
		assertEquals(metaclass.getInitializers()[2], initializer3);

		metaclass.removeInitializer(initializer2);
		assertEquals(metaclass.getInitializers().length, 2);
		assertEquals(metaclass.getInitializers()[0], initializer1);
		assertEquals(metaclass.getInitializers()[1], initializer3);

		metaclass.removeInitializer(initializer1);
		assertEquals(metaclass.getInitializers().length, 1);
		assertEquals(metaclass.getInitializers()[0], initializer3);

		metaclass.removeInitializer(initializer3);
		assertEquals(metaclass.getInitializers().length, 0);
	}
}
