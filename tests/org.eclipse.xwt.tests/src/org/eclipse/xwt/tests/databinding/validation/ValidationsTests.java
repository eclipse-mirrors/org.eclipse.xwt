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
 *     Soyatec & hceylan - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.databinding.validation;

import java.net.URL;

import org.eclipse.swt.widgets.Text;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;

public class ValidationsTests extends XWTTestCase {

	public void testValidation() throws Exception {
		URL url = ValidationsTests.class.getResource(Validation.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Text text1 = (Text) XWT.findElementByName(root, "text1");
				Text text2 = (Text) XWT.findElementByName(root, "text2");

				checkValidationFailure1(text1, text2);
				checkValidationFailure2(text1, text2);
				checkValidationOk(text1, text2);
			}

			private void checkValidationOk(Text text1, Text text2) {
				text2.setText("test3");
				text1.setText("LongEnough");
				assertEquals(text2.getText(), "LongEnough");
			}

			private void checkValidationFailure2(Text text1, Text text2) {
				text2.setText("test2");
				text1.setText("short"); //no string
				assertEquals(text2.getText(), "test2");
			}

			private void checkValidationFailure1(Text text1, Text text2) {
				text2.setText("test1");
				text1.setText(""); //no string
				assertEquals(text2.getText(), "test1");
			}
		});
	}

	public void testValidation_Single() throws Exception {
		URL url = ValidationSingle.class.getResource(ValidationSingle.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Text text1 = (Text) XWT.findElementByName(root, "text1");
				Text text2 = (Text) XWT.findElementByName(root, "text2");

				checkValidationFailure1(text1, text2);
				checkValidationFailure2(text1, text2);
				checkValidationOk(text1, text2);
			}

			private void checkValidationOk(Text text1, Text text2) {
				text2.setText("test3");
				text1.setText("LongEnough");
				assertEquals(text2.getText(), "LongEnough");
			}

			private void checkValidationFailure2(Text text1, Text text2) {
				text2.setText("test2");
				text1.setText("short"); //no string
				assertEquals(text2.getText(), "test2");
			}

			private void checkValidationFailure1(Text text1, Text text2) {
				text2.setText("test1");
				text1.setText(""); //no string
				assertEquals(text2.getText(), "test1");
			}
		});
	}
	
	public void testValidationStatus() throws Exception{
		URL url = Validation_ToolTip.class.getResource(Validation_ToolTip.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		
		runTest(url, new Runnable() {
			public void run() {
				Text text1 = (Text) XWT.findElementByName(root, "text1");
				checkValidationStatus(text1);
				checkValidationStatusOK(text1);
			}
			
			private void checkValidationStatusOK(Text text1) {
				text1.setText("lessthan8");
				assertEquals(text1.getToolTipText(), "");
			}

			private void checkValidationStatus(Text text1){
				text1.setText("more than 8 characters");
				assertEquals(text1.getToolTipText(), "Value should be 8 - 16 chars long");
			}
		});
	}
	
	public void testValidationStatus_Attribute() throws Exception{
		URL url = Validation_ToolTip_Attribute.class.getResource(Validation_ToolTip_Attribute.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		
		runTest(url, new Runnable() {
			public void run() {
				Text text1 = (Text) XWT.findElementByName(root, "text1");
				
				checkValidationStatusOK(text1);
				
				checkValidationStatus(text1);
				
			}
			
			private void checkValidationStatusOK(Text text1) {
				text1.setText("lessthan8");
				assertEquals(text1.getToolTipText(), "");
			}

			private void checkValidationStatus(Text text1){
				text1.setText("more than 16 characters");
				assertEquals(text1.getToolTipText(), "Value should be 8 - 16 chars long");
			}
		});
	}
}
