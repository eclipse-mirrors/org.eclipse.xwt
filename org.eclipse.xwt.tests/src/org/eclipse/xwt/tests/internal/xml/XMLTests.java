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

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.Map;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;
import org.eclipse.swt.widgets.Button;

/**
 * Test suite for the internals of XML parsing.
 */
public class XMLTests extends XWTTestCase {

	/**
	 * Tests that URLs employing custom stream handlers (identified by custom URL schemes)
	 * are correctly manipulated by XWT such that their contents are accessed at run-time.
	 */
	public void testURLWithCustomStreamHandler() throws Exception {
		final String filename = "helloButton" + IConstants.XWT_EXTENSION_SUFFIX;
		
		Map<String, URL> delegates = new java.util.HashMap<String, URL>();
		delegates.put(filename, XMLTests.class.getResource(filename));
		
		URL url = new URL(null, "delegate:" + filename, new DelegatingURLStreamHandler(delegates));
		
		runTest(url, new Runnable() {

			public void run() {
				Object element = XWT.findElementByName(root, "helloButton");
				assertTrue(element instanceof Button);
			}
		});
	}

	//
	// Test framework
	//

	final class DelegatingURLStreamHandler extends URLStreamHandler {

		private final Map<String, URL> delegates;

		public DelegatingURLStreamHandler(Map<String, URL> delegates) {
			super();

			this.delegates = delegates;
		}

		@Override
		protected URLConnection openConnection(URL u) throws IOException {
			URL delegate = delegates.get(u.getFile());
			if(delegate == null) {
				throw new IOException("No delegate for " + u.getFile());
			}

			return delegate.openConnection();
		}
	}
}
