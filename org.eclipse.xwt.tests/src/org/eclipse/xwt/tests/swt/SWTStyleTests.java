/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.swt;

import java.net.URL;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

/**
 * This class test the function about OperatorHelper
 * 
 * @author YaHong.Song(yahong.song@soyatec.com)
 * 
 */
public class SWTStyleTests extends XWTTestCase {

	/**
	 * The extensibility of Value resolver like <class>.member
	 * 
	 */
	public void testSWT_Style_Customized() throws Exception {
		URL url = Style.class.getResource(Style_Customized.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Object object = XWT.findElementByName(root, "MyElement");
				assertTrue(object instanceof MyElement);
				MyElement myElement = (MyElement) object;
				assertTrue(myElement.isMyStyle());				
			}
		});
	}

	
	/**
	 * this test must be at the last test since it modifies the XWT
	 * 
	 * @throws Exception
	 */
	public void testSWT_Style_Default() throws Exception {
		URL url = Style.class.getResource(Style.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		XWT.registerMetaclass(MyElement.class);
		runTest(url, new Runnable() {
			public void run() {
				Object object = XWT.findElementByName(root, "MyElement");
				assertTrue(object instanceof MyElement);
				MyElement myElement = (MyElement) object;
				assertTrue(myElement.isMyStyle());				
			}
		});
	}
}
