/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.threading;

import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

/**
 * @author yyang(yves.yang@soyatec.com)
 */
public class ThreadingTests extends XWTTestCase {
	protected boolean openStarted = false;
	protected int shells = 0;
	
	/**
	 * The extensibility of Value resolver like <class>.member
	 * 
	 */
	public void testThreading_Open() throws Exception {
		if (SWT.getPlatform().equals("gtk")) {
			clearnUpDisplay();
		}
		else {
			Display.getDefault().dispose();			
		}
		if (SWT.getPlatform().equals("cocoa") || SWT.getPlatform().equals("carbon")) {			
			macDoTestThreading_Open();
		}
		else {
			doTestThreading_Open();
		}
	}

	public void macDoTestThreading_Open() throws Exception {		
		XWT.getAllMetaclasses(); // invoke XWT initialization in the main thread. 
		
		URL url = ThreadingTests.class.getResource(Threading.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				URL url = Threading.class.getResource(Threading.class
						.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
				try {
					openStarted = true;
					XWT.open(url);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		Thread thread2 = new Thread() {
			@Override
			public void run() {
				URL url = Threading.class.getResource(Threading.class
						.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
				try {
					openStarted = true;
					XWT.open(url);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		thread1.start();
		thread2.start();
		
		long startTime = -1;
		for (int i = 0; i< 100; i++) {
			if (!Display.getDefault().readAndDispatch()) {
				Display.getDefault().sleep();
			}
			
			if (Display.getDefault().getShells().length == 2) {
				break;
			}
			
			Shell[] shells = Display.getDefault().getShells();
			if (shells.length == 0) {
				if (startTime == -1) {
					startTime = System.currentTimeMillis();
				}
				else if ((System.currentTimeMillis() - startTime) > 1000) {
					assertFalse(true);
					break;
				}
			}
			else {
				startTime = -1;
			}
		}
	}

	public void doTestThreading_Open() throws Exception {
		URL url = ThreadingTests.class.getResource(Threading.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				URL url = Threading.class.getResource(Threading.class
						.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
				try {
					openStarted = true;
					XWT.open(url);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		Thread thread2 = new Thread() {
			@Override
			public void run() {
				URL url = Threading.class.getResource(Threading.class
						.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
				try {
					openStarted = true;
					XWT.open(url);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		thread1.start();
		thread2.start();
		
		if (SWT.getPlatform().startsWith("win")) {
			for (int i = 0; i < 100; i++) {
				if (Display.findDisplay(thread1) == null && Display.findDisplay(thread2) == null) {
					Thread.sleep(500);				
				}
			}
			assertTrue(Display.findDisplay(thread1) != null || Display.findDisplay(thread2) != null);
	
			for (int i = 0; i < 10; i++) {
				if (Display.findDisplay(thread1) == null || Display.findDisplay(thread2) == null) {
					Thread.sleep(500);
				}
			}
			assertTrue(Display.findDisplay(thread1) != null && Display.findDisplay(thread2) != null);
		}
		else {
			while (!openStarted) {
				Thread.sleep(500);				
			}
			Runnable runnable = new Runnable() {
				public void run() {
					shells = Display.getDefault().getShells().length;
				}
			}; 
			for (int i = 0; i < 100; i++) {
				// make sure Display is already initialized by one thread.
				Display.getDefault().syncExec(runnable);
				if (shells == 0) {
					Thread.sleep(500);				
				}
			}
	
			for (int i = 0; i < 100; i++) {
				Display.getDefault().syncExec(runnable);
				if (shells != 2) {
					Thread.sleep(500);
				}
			}
			assertTrue(shells == 2);			
		}
	}
}
