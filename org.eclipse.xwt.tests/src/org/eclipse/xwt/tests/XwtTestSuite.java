/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.xwt.tests.animation.AnimationSuite;
import org.eclipse.xwt.tests.annotation.AnnotationTests;
import org.eclipse.xwt.tests.attachedproperty.AttachedPropertyTests;
import org.eclipse.xwt.tests.clr.CLRTestSuite;
import org.eclipse.xwt.tests.clrfactory.CLRFactoryTestSuite;
import org.eclipse.xwt.tests.controls.ControlsTestSuite;
import org.eclipse.xwt.tests.controls.layout.LayoutTestSuite;
import org.eclipse.xwt.tests.controls.uiresource.UIResourceTestSuite;
import org.eclipse.xwt.tests.databinding.BindingTestSuite;
import org.eclipse.xwt.tests.events.EventsTestSuite;
import org.eclipse.xwt.tests.forms.FormsTestSuite;
import org.eclipse.xwt.tests.jface.JFaceTestSuite;
import org.eclipse.xwt.tests.metaclass.Metaclass_Tests;
import org.eclipse.xwt.tests.name.NameTestSuite;
import org.eclipse.xwt.tests.namespace.handler.NamespacehandlerTestSuite;
import org.eclipse.xwt.tests.resources.ResourcesTestSuite;
import org.eclipse.xwt.tests.resourcesdictionary.ResourcesDictionaryTestSuite;
import org.eclipse.xwt.tests.snippet017.Snippet017TestSuite;
import org.eclipse.xwt.tests.snippet019.Snippet019TestSuite;
import org.eclipse.xwt.tests.swt.SWTTestSuite;
import org.eclipse.xwt.tests.threading.ThreadingSuite;
import org.eclipse.xwt.tests.trigger.TriggerTestSuite;
import org.eclipse.xwt.tests.xaml.BindingExpressionTestSuite;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class XwtTestSuite extends TestSuite {
	public static final Test suite() {
		return new XwtTestSuite();
	}

	/**
	 * The execution of the tests must be started from simple to complex in
	 * order.
	 */
	public XwtTestSuite() {
		// XAML
		addXAMLTests();

		// Metaclass
		addTest(new TestSuite(Metaclass_Tests.class));

		// XWT
		addXWTTests();

		// annotations
		addTest(new TestSuite(AnnotationTests.class));

		// widgets SWT
		addControlsTests();

		addUserControlTests();

		addKeyBindingTests();

		// widgets JFace
		addJFaceTests();

		// i18n
		addI18NTests();

		// events
		addEventTests();

		// data binding
		addDataBindingTests();

		// Presentation tests
		addPresentationTests();

		// Style provider
		addStyleTests();

		// triggers
		addTriggerTests();

		// triggers
		addSnippetTests();

		// triggers
		addFormsTests();

		// triggers
		addAnimationTests();
		
		// Must be done at last
		addTest(ThreadingSuite.suite());
	}

	protected void addXAMLTests() {
		addTest(NameTestSuite.suite());
		addTest(ResourcesTestSuite.suite());
		addTest(ResourcesDictionaryTestSuite.suite());
		addTest(BindingExpressionTestSuite.suite());
	}

	protected void addXWTTests() {
		addTest(CLRTestSuite.suite());
		addTest(CLRFactoryTestSuite.suite());
		addTest(new TestSuite(AttachedPropertyTests.class));
	}

	protected void addControlsTests() {
		addTest(ControlsTestSuite.suite());
		addTest(LayoutTestSuite.suite());
		addTest(SWTTestSuite.suite());
		addTest(UIResourceTestSuite.suite());
	}

	protected void addUserControlTests() {
	}

	protected void addKeyBindingTests() {
	}

	protected void addPresentationTests() {
	}

	protected void addJFaceTests() {
		addTest(JFaceTestSuite.suite());
	}

	protected void addEventTests() {
		addTest(EventsTestSuite.suite());
	}

	protected void addDataBindingTests() {
		addTest(BindingTestSuite.suite());
	}

	protected void addI18NTests() {
	}

	protected void addStyleTests() {
	}

	protected void addSnippetTests() {
		addTest(Snippet017TestSuite.suite());
		addTest(Snippet019TestSuite.suite());
	}

	protected void addFormsTests() {
		addTest(FormsTestSuite.suite());
	}

	protected void addAnimationTests() {
		addTest(AnimationSuite.suite());
	}

	protected void addTriggerTests() {
		addTest(TriggerTestSuite.suite());
	}

	protected void addCustomizationTests() {
		addTest(NamespacehandlerTestSuite.suite());
	}
}
