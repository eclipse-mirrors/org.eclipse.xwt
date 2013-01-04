/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.forms;

import java.net.URL;

import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;

public class FormsTests extends FormTestCase {
	public void testSection() throws Exception {
		URL url = FormsTests.class.getResource(Section.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkVisibility("Section",
						org.eclipse.ui.forms.widgets.Section.class);
				checkVisibility("Section.Label", Label.class);
			}
		});
	}

	public void testForm_Label() throws Exception {
		URL url = FormsTests.class.getResource(Form_Label.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkVisibility("Form", org.eclipse.ui.forms.widgets.Form.class);
				checkVisibility("Form.Label", Label.class);
			}
		});
	}

	public void testForm_Button() throws Exception {
		URL url = FormsTests.class.getResource(Form_Button.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkVisibility("Form", org.eclipse.ui.forms.widgets.Form.class);
				checkVisibility("Form.Button", Button.class);
			}
		});
	}

	public void testForm_LabelButton() throws Exception {
		URL url = FormsTests.class.getResource(Form_LabelButton.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkVisibility("Form", org.eclipse.ui.forms.widgets.Form.class);
				checkVisibility("Form.Label", Label.class);
				checkVisibility("Form.Button", Button.class);
			}
		});
	}

	public void testForm_Section() throws Exception {
		URL url = FormsTests.class.getResource(Form_Section.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkVisibility("Form", org.eclipse.ui.forms.widgets.Form.class);
				checkVisibility("Form.Section",
						org.eclipse.ui.forms.widgets.Section.class);
				checkVisibility("Form.Section.Label", Label.class);
			}
		});
	}

	public void testForm_HeadClient() throws Exception {
		URL url = FormsTests.class.getResource(Form_HeadClient.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkVisibility("Form.HeadClient.Button", Button.class);
			}
		});
	}

	public void testForm_Background() throws Exception {
		URL url = FormsTests.class.getResource(Form_Background.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				Form form1 = (Form) XWT.findElementByName(root,
						"FormBackground");
				Color form1Color = form1.getBackground();
				Form form2 = (Form) XWT.findElementByName(root, "Form");
				Color form2Color = form2.getBackground();
				assertFalse(form1Color.equals(form2Color));
			}
		});
	}

	public void testForm_ButtonSection() throws Exception {
		URL url = FormsTests.class.getResource(Form_ButtonSection.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkVisibility("Form", org.eclipse.ui.forms.widgets.Form.class);
				checkVisibility("Form.Button", Button.class);
				checkVisibility("Form.Section",
						org.eclipse.ui.forms.widgets.Section.class);
				checkVisibility("Form.Section.Label", Label.class);
			}
		});
	}

	public void testScrolledForm() throws Exception {
		URL url = FormsTests.class.getResource(ScrolledForm.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkVisibility("ScrolledForm",
						org.eclipse.ui.forms.widgets.ScrolledForm.class);
				checkVisibility("ScrolledForm.SashForm", SashForm.class);
				checkVisibility("ScrolledForm.SashForm.Section1",
						org.eclipse.ui.forms.widgets.Section.class);
				checkVisibility("ScrolledForm.SashForm.Section1.Composite",
						Composite.class);
				checkVisibility(
						"ScrolledForm.SashForm.Section1.Composite.Label",
						Label.class);
				checkVisibility(
						"ScrolledForm.SashForm.Section1.Composite.Text",
						Text.class);
				checkVisibility("ScrolledForm.SashForm.Section2",
						org.eclipse.ui.forms.widgets.Section.class);
				checkVisibility("ScrolledForm.SashForm.Section2.Label",
						Label.class);
				checkVisibility("ScrolledForm.Label", Label.class);
				checkChildren("ScrolledForm", 1);
				checkChildren("ScrolledForm", "Body", 2);
			}
		});
	}

	public void testForm_Group_Adapt() throws Exception {
		URL url = FormsTests.class.getResource(Form_Group.class.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				checkVisibility("Form.Group", Group.class);
				Group group = (Group) XWT.findElementByName(root, "Form.Group");
				Color color = group.getBackground();
				assertEquals(color.getBlue(), 255);
				assertEquals(color.getRed(), 255);
				assertEquals(color.getGreen(), 255);
			}
		});
	}

	public void testExpandableComposite_Composite() throws Exception {
		URL url = FormsTests.class
				.getResource(ExpandableComposite_Composite.class
						.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				org.eclipse.ui.forms.widgets.ExpandableComposite expandableComposite = (org.eclipse.ui.forms.widgets.ExpandableComposite) XWT
						.findElementByName(root,
								"ExpandableComposite");
				checkVisibility("ExpandableComposite.Label", Label.class);
				assertTrue(expandableComposite.isExpanded());
				assertTrue(expandableComposite.getClient() instanceof Composite);
			}
		});
	}

	public void testExpandableComposite_Label() throws Exception {
		URL url = FormsTests.class
				.getResource(ExpandableComposite_Label.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				org.eclipse.ui.forms.widgets.ExpandableComposite expandableComposite = (org.eclipse.ui.forms.widgets.ExpandableComposite) XWT
						.findElementByName(root,
								"ExpandableComposite");
				checkVisibility("ExpandableComposite.Label", Label.class);
				assertTrue(expandableComposite.isExpanded());
				assertTrue(expandableComposite.getClient() instanceof Label);
			}
		});
	}

	public void testExpandableComposite_Label_NotExpanded() throws Exception {
		URL url = FormsTests.class
				.getResource(ExpandableComposite_Label_NotExpanded.class.getSimpleName()
						+ IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new Runnable() {
			public void run() {
				org.eclipse.ui.forms.widgets.ExpandableComposite expandableComposite = (org.eclipse.ui.forms.widgets.ExpandableComposite) XWT
						.findElementByName(root,
								"ExpandableComposite");
				checkVisibility("ExpandableComposite.Label", Label.class);
				assertFalse(expandableComposite.isExpanded());
				assertTrue(expandableComposite.getClient() instanceof Label);
			}
		});
	}
}
