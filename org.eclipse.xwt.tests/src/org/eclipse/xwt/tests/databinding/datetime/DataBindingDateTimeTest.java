/*******************************************************************************
 * Copyright (c) 2006, 2016 Soyatec (http://www.soyatec.com) and others.       *
 * All rights reserved. This program and the accompanying materials            *
 * are made available under the terms of the Eclipse Public License v1.0       *
 * which accompanies this distribution, and is available at                    *
 * http://www.eclipse.org/legal/epl-v10.html                                   *
 *                                                                             *  
 * Contributors:                                                               *        
 *     Soyatec - initial API and implementation                                *
 *******************************************************************************/
package org.eclipse.xwt.tests.databinding.datetime;

import java.net.URL;

import org.eclipse.swt.widgets.DateTime;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class DataBindingDateTimeTest extends XWTTestCase {

	public void testDataBinding() throws Exception {

		URL url = DataBindingDateTimeTest.class.getResource(TestClassView.class
				.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {

				DateTime datetime = (DateTime) XWT.findElementByName(root,
						"birthday");
				DateTime copyDateTime = (DateTime) XWT.findElementByName(root,
						"CopyDateTime");
				checkBinding(datetime, copyDateTime);

			}

			private void checkBinding(DateTime datetime1, DateTime datetime2) {
				assertEquals(datetime2.getYear(), datetime1.getYear());
				assertEquals(datetime2.getMonth(), datetime1.getMonth());
				assertEquals(datetime2.getDay(), datetime1.getDay());
			}
		});
	}
}
