/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 435432
 *   
 *****************************************************************************/
package org.eclipse.xwt.tests.internal.xml;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.IXWTLoader;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;
import org.eclipse.swt.widgets.Button;

/**
 * Test suite for the internals of XML parsing.
 */
public class XMLTests extends XWTTestCase {
	static final String HELLO_BUTTON_FILE_NAME = "helloButton" + IConstants.XWT_EXTENSION_SUFFIX;
	
	static final int ITERATIONS = 3;

	/**
	 * Tests that URLs employing custom stream handlers (identified by custom URL schemes)
	 * are correctly manipulated by XWT such that their contents are accessed at run-time.
	 */
	public void testURLWithCustomStreamHandler() throws Exception {
		final String filename = HELLO_BUTTON_FILE_NAME;
		
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
	
	/**
	 * Control test case checking that the absence of an XML parsing option results in no caching.
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=435432
	 */
	public void testParsedXMLElementCaching_None() throws Exception {
		final HitCountingURLStreamHandler handler = new HitCountingURLStreamHandler();
		final Map<String, Object> options = new HashMap<String, Object>();
		final URL resourceURL = new URL(null, XMLTests.class.getResource(HELLO_BUTTON_FILE_NAME).toExternalForm(), handler);
		
		Runnable verifier = new Runnable() {
			private int expectedHitCount = 0;
			
			@Override
			public void run() {
				expectedHitCount++; // No caching means hitting the URL each time
				assertEquals(expectedHitCount, handler.getHitCount());
			}
		};
		
		for (int i = 0; i < ITERATIONS; i++) {
			runTest(resourceURL, options, verifier);
		}
	}
	
	/**
	 * Tests that the Boolean XML caching option value is correctly respected and results in the cache being used.
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=435432
	 */
	public void testParsedXMLElementCaching_Boolean() throws Exception {
		final HitCountingURLStreamHandler handler = new HitCountingURLStreamHandler();
		final Map<String, Object> options = new HashMap<String, Object>();
		final URL resourceURL = new URL(null, XMLTests.class.getResource(HELLO_BUTTON_FILE_NAME).toExternalForm(), handler);
		
		Runnable verifier = new Runnable() {
			private final int expectedHitCount = 1;
			
			@Override
			public void run() {
				assertEquals(expectedHitCount, handler.getHitCount());
			}
		};
		
		options.put(IXWTLoader.XML_CACHE_PROPERTY, true);
		
		// Hit the loader a few times
		for (int i = 0; i < ITERATIONS; i++) {
			runTest(resourceURL, options, verifier);
		}
	}
	
	/**
	 * Tests that the Integer XML caching option value is correctly respected and results in the cache being used.
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=435432
	 */
	public void testParsedXMLElementCaching_Integer() throws Exception {
		final HitCountingURLStreamHandler handler = new HitCountingURLStreamHandler();
		final Map<String, Object> options = new HashMap<String, Object>();
		final URL resourceURL = new URL(null, XMLTests.class.getResource(HELLO_BUTTON_FILE_NAME).toExternalForm(), handler);
		
		Runnable verifier = new Runnable() {
			private final int expectedHitCount = 1;
			
			@Override
			public void run() {
				assertEquals(expectedHitCount, handler.getHitCount());
			}
		};
		
		// Pretty small cache, but enough for this test
		options.put(IXWTLoader.XML_CACHE_PROPERTY, 1);
		
		for (int i = 0; i < ITERATIONS; i++) {
			runTest(resourceURL, options, verifier);
		}
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
	
	final class HitCountingURLStreamHandler extends URLStreamHandler {
		private int hitCount;
		
		HitCountingURLStreamHandler() {
			super();
		}
		
		public int getHitCount() {
			return hitCount;
		}
		
		private void increment() {
			hitCount++;
		}
		
		@Override
		protected URLConnection openConnection(URL u) throws IOException {
			increment();
			return new URL(u.toExternalForm()).openConnection();
		}
	}
}
