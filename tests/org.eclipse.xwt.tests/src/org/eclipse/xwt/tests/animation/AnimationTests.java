/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.animation;

import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class AnimationTests extends XWTTestCase {
	protected Color initialColor;
	protected int initialInt;
	protected Point initialLocation;
	protected Point initialSize;
	protected Rectangle initialBounds;

	public void test_Color_Background() throws Exception {
		URL url = Color_Background_Composite.class
				.getResource(Color_Background_Composite.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				try {
					Object element = XWT.findElementByName(root, "startButton");
					assertTrue(element instanceof Button);
					Button button = (Button)element;
					selectButton(button);
					
					element = XWT.findElementByName(root, "labelTarget");
					assertTrue(element instanceof Label);
					Label label = (Label)element;
					initialColor = label.getBackground();
				} catch (Exception e) {
					fail();
				}
			}
		},
		new Runnable() {
			public void run() {
				try {
					Thread.currentThread().sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},
		new Runnable() {
			public void run() {
				try {
					Object element = XWT.findElementByName(root, "labelTarget");
					assertTrue(element instanceof Label);
					Label label = (Label)element;
					Color color = label.getBackground();
					assertNotSame(initialColor, color);
				} catch (Exception e) {
					fail();
				}
			}
		}		
		);
	}
	
	public void test_Color_Foreground() throws Exception {
		URL url = Color_Foreground_Composite.class
				.getResource(Color_Foreground_Composite.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				try {
					Object element = XWT.findElementByName(root, "startButton");
					assertTrue(element instanceof Button);
					Button button = (Button)element;
					selectButton(button);
					
					element = XWT.findElementByName(root, "labelTarget");
					assertTrue(element instanceof Label);
					Label label = (Label)element;
					initialColor = label.getForeground();
				} catch (Exception e) {
					fail();
				}
			}
		},
		new Runnable() {
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},
		new Runnable() {
			public void run() {
				try {
					Object element = XWT.findElementByName(root, "labelTarget");
					assertTrue(element instanceof Label);
					Label label = (Label)element;
					Color color = label.getForeground();
					assertNotSame(initialColor, color);
				} catch (Exception e) {
					fail();
				}
			}
		}		
		);
	}
	
	public void test_Int_Alpha() throws Exception {
		URL url = Int_Alpha_Shell.class
				.getResource(Int_Alpha_Shell.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				try {
					Object element = XWT.findElementByName(root, "startButton");
					assertTrue(element instanceof Button);
					Button button = (Button)element;
					selectButton(button);
					
					element = XWT.findElementByName(root, "window");
					assertTrue(element instanceof Shell);
					Shell shell = (Shell)element;
					initialInt = shell.getAlpha();
				} catch (Exception e) {
					fail();
				}
			}
		},
		new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},
		new Runnable() {
			public void run() {
				try {
					Object element = XWT.findElementByName(root, "window");
					assertTrue(element instanceof Shell);
					Shell shell = (Shell)element;
					int alpha = shell.getAlpha();
					if (!"gtk".equals(SWT.getPlatform())) {
						assertTrue(alpha != initialInt);
					}	
				} catch (Exception e) {
					fail();
				}
			}
		}		
		);
	}
	
	public void test_Point_Location_Shell() throws Exception {
		URL url = Point_Location_Shell.class
				.getResource(Point_Location_Shell.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				try {
					Object element = XWT.findElementByName(root, "startButton");
					assertTrue(element instanceof Button);
					Button button = (Button)element;
					selectButton(button);
					
					element = XWT.findElementByName(root, "window");
					assertTrue(element instanceof Shell);
					Shell shell = (Shell)element;
					initialLocation = shell.getLocation();
				} catch (Exception e) {
					fail();
				}
			}
		},
		new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},
		new Runnable() {
			public void run() {
				try {
					Object element = XWT.findElementByName(root, "window");
					assertTrue(element instanceof Shell);
					Shell shell = (Shell)element;
					Point location = shell.getLocation();
					assertNotSame(initialLocation, location);
				} catch (Exception e) {
					fail();
				}
			}
		}		
		);
	}
	
	public void test_Point_Size_Shell() throws Exception {
		URL url = Point_Size_Shell.class
				.getResource(Point_Size_Shell.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				try {
					Object element = XWT.findElementByName(root, "startButton");
					assertTrue(element instanceof Button);
					Button button = (Button)element;
					selectButton(button);
					
					element = XWT.findElementByName(root, "window");
					assertTrue(element instanceof Shell);
					Shell shell = (Shell)element;
					initialSize = shell.getSize();
				} catch (Exception e) {
					fail();
				}
			}
		},
		new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},
		new Runnable() {
			public void run() {
				try {
					Object element = XWT.findElementByName(root, "window");
					assertTrue(element instanceof Shell);
					Shell shell = (Shell)element;
					Point size = shell.getSize();
					assertNotSame(initialSize, size);
				} catch (Exception e) {
					fail();
				}
			}
		}		
		);
	}
	
	public void test_Rectangle_Bounds_Shell() throws Exception {
		URL url = Rectangle_Bounds_Shell.class
				.getResource(Rectangle_Bounds_Shell.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				try {
					Object element = XWT.findElementByName(root, "startButton");
					assertTrue(element instanceof Button);
					Button button = (Button)element;
					selectButton(button);
					
					element = XWT.findElementByName(root, "window");
					assertTrue(element instanceof Shell);
					Shell shell = (Shell)element;
					initialBounds = shell.getBounds();
				} catch (Exception e) {
					fail();
				}
			}
		},
		new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},
		new Runnable() {
			public void run() {
				try {
					Object element = XWT.findElementByName(root, "window");
					assertTrue(element instanceof Shell);
					Shell shell = (Shell)element;
					Rectangle rectangle = shell.getBounds();
					assertNotSame(initialBounds, rectangle);
				} catch (Exception e) {
					fail();
				}
			}
		}		
		);
	}
}
