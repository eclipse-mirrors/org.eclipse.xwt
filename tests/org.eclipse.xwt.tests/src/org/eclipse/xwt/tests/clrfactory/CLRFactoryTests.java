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
package org.eclipse.xwt.tests.clrfactory;

import java.net.URL;
import java.util.HashMap;

import org.eclipse.swt.widgets.Button;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.IXWTLoader;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class CLRFactoryTests extends XWTTestCase {
	
	public void testCLRFactoryDefault() throws Exception {
		URL url = CLR.class.getResource(CLRFactoryDefault.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				selectButton(element);
			}
		}, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				assertTrue(element.getText().equals(""));
			}
		});
	}

	public void testCLRFactoryValue() throws Exception {
		URL url = CLR.class.getResource(CLRFactoryValue.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				selectButton(element);
			}
		}, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				assertTrue(element.getText().equals("arg1 arg2"));
			}
		});
	}

	public void testCLRFactoryNamespace() throws Exception {
		URL url = CLR.class.getResource(CLRFactoryNamespace.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				selectButton(element);
			}
		}, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				assertTrue(element.getText().equals(""));
			}
		});
	}

	public void testCLRFactorySingleton() throws Exception {
		URL url = CLR.class.getResource(CLRFactorySingleton.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				selectButton(element);
			}
		}, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				Object data = element.getData("CLR");
				assertTrue(data instanceof CLR);
				CLR clr = (CLR) data;
				assertEquals(clr.getFactory(), CLRFactory.INSTANCE);
			}
		});
	}

	public void testCLRFactoryOption() throws Exception {
		URL url = CLR.class.getResource(CLRFactoryOption.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		HashMap<String, Object> options = new HashMap<String, Object>();
		final CLRFactory clrFactory = new CLRFactory();
		options.put(IXWTLoader.CLASS_FACTORY_PROPERTY, clrFactory);
		runTest(url, options, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				selectButton(element);
			}
		}, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				assertTrue(element.getText().equals(""));
			}
		});
	}

	public void testCLRFactoryGlobalOption() throws Exception {
		URL url = CLR.class.getResource(CLRFactoryOption.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		CLRFactory clrFactory = new CLRFactory();
		XWT.setCLRFactory(clrFactory);
		runTest(url, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				selectButton(element);
			}
		}, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				assertTrue(element.getText().equals(""));
			}
		});
	}
	
	public void testCLRFactoryPrecedentOption() throws Exception {
		URL url = CLR.class.getResource(CLRFactoryDefault.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		HashMap<String, Object> options = new HashMap<String, Object>();
		final CLRFadeFactory clrFactory = new CLRFadeFactory();
		options.put(IXWTLoader.CLASS_FACTORY_PROPERTY, clrFactory);
		runTest(url, options, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				selectButton(element);
			}
		}, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				Object data = element.getData("CLR");
				assertTrue(data instanceof CLR);
			}
		});
	}

	public void testCLRFactoryPrecedentGlobal() throws Exception {
		URL url = CLR.class.getResource(CLRFactoryDefault.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		CLRFadeFactory clrFactory = new CLRFadeFactory();
		XWT.setCLRFactory(clrFactory);
		runTest(url, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				selectButton(element);
			}
		}, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				Object data = element.getData("CLR");
				assertTrue(data instanceof CLR);
			}
		});
	}

	public void testCLRFactoryPrecedentOptionOverGlobal() throws Exception {
		URL url = CLR.class.getResource(CLRFactoryOption.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		HashMap<String, Object> options = new HashMap<String, Object>();
		// CLRfactory should be not used
		final CLRFadeFactory clrFadeFactory = new CLRFadeFactory();
		XWT.setCLRFactory(clrFadeFactory);
		
		// CLRfactory should be used
		CLRFactory clrFactory = new CLRFactory();
		options.put(IXWTLoader.CLASS_FACTORY_PROPERTY, clrFactory);
		runTest(url, options, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				selectButton(element);
			}
		}, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				Object data = element.getData("CLR");
				assertTrue(data instanceof CLR);
			}
		});
	}
	
	public void testCLRFactoryOptionArg() throws Exception {
		URL url = CLR.class.getResource(CLRFactoryOptionArgs.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		HashMap<String, Object> options = new HashMap<String, Object>();
		final CLRFactory clrFactory = new CLRFactory();
		options.put(IXWTLoader.CLASS_FACTORY_PROPERTY, clrFactory);
		runTest(url, options, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				selectButton(element);
			}
		}, new Runnable() {
			public void run() {
				Button element = (Button)XWT.findElementByName(root, "button");
				assertTrue(element.getText().equals("arg1 arg2"));
			}
		});
	}
}
