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
package org.eclipse.xwt.tests.annotation;

import java.lang.reflect.Field;
import java.net.URL;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.tests.XWTTestCase;

public class AnnotationTests extends XWTTestCase {

	public void testField() throws Exception {
		URL url = Button.class
				.getResource(Button.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		ButtonHandler.instance = null;
		runTest(url, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				try {
					Field field = ButtonHandler.class.getDeclaredField("myButton");
					assertNotNull(ButtonHandler.instance);
					field.setAccessible(true);
					Object object = field.get(ButtonHandler.instance);
					assertNotNull(object);
				} catch (Exception e) {
					fail();
				}
			}
		});
	}

	public void testField_rename() throws Exception {
		URL url = Button.class
				.getResource("Button_rename"
						+ IConstants.XWT_EXTENSION_SUFFIX);
		ButtonHandler_rename.instance = null;
		runTest(url, new Runnable() {
			public void run() {
				checkButton();
			}

			public void checkButton() {
				try {
					Field field = ButtonHandler_rename.class.getDeclaredField("myButton");
					assertNotNull(ButtonHandler_rename.instance);
					field.setAccessible(true);
					Object object = field.get(ButtonHandler_rename.instance);
					assertNotNull(object);
				} catch (Exception e) {
					fail();
				}
			}
		});
	}
}
