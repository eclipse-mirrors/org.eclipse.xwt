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
package org.eclipse.xwt.tests.databinding;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.xwt.tests.databinding.bindcontrol.ControlBindingTests;
import org.eclipse.xwt.tests.databinding.multibinding.MultiBindingTests;
import org.eclipse.xwt.tests.databinding.pojo.PojoDataBindingTests;
import org.eclipse.xwt.tests.databinding.pojo.attribute.PojoAttrDataBindingTests;
import org.eclipse.xwt.tests.databinding.self.DataBindingSelfTests;
import org.eclipse.xwt.tests.databinding.status.ValidationStatusTests;
import org.eclipse.xwt.tests.databinding.validation.ValidationsTests;

public class BindingTestSuite extends TestSuite {
	public static final Test suite() {
		return new BindingTestSuite();
	}

	public BindingTestSuite() {
		addTest(new TestSuite(DataBindingTests.class));
		addTest(new TestSuite(PojoDataBindingTests.class));
		addTest(new TestSuite(PojoAttrDataBindingTests.class));
		addTest(new TestSuite(ControlBindingTests.class));
		addTest(new TestSuite(MultiBindingTests.class));
		addTest(new TestSuite(DataBindingSelfTests.class));
		addTest(new TestSuite(ValidationsTests.class));
		addTest(new TestSuite(ValidationStatusTests.class));
	}
}
