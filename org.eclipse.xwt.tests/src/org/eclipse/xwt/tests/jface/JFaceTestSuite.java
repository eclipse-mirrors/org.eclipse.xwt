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
package org.eclipse.xwt.tests.jface;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.xwt.tests.jface.comboviewer.array.JFaceComboViewer_ArrayTests;
import org.eclipse.xwt.tests.jface.comboviewer.collection.JFaceComboViewer_CollectionTests;
import org.eclipse.xwt.tests.jface.comboviewer.enumeration.JFaceComboViewer_EnumTests;
import org.eclipse.xwt.tests.jface.listviewer.array.JFaceListViewer_ArrayTests;
import org.eclipse.xwt.tests.jface.listviewer.collection.JFaceListViewer_CollectionTests;
import org.eclipse.xwt.tests.jface.tableviewer.JFaceTableViewer_Tests;
import org.eclipse.xwt.tests.jface.tableviewer.filter.JFaceTableViewer_Filters_Tests;
import org.eclipse.xwt.tests.jface.tableviewer.master.detail.JFaceTableViewer_MasterDetail_Tests;
import org.eclipse.xwt.tests.jface.tableviewer.master.detail.array.JFaceTableViewer_Array_MasterDetail_Tests;
import org.eclipse.xwt.tests.jface.tableviewer.master.detail.list.JFaceTableViewer_List_MasterDetail_Tests;
import org.eclipse.xwt.tests.jface.tableviewer.master.detail.set.JFaceTableViewer_Set_MasterDetail_Tests;

public class JFaceTestSuite extends TestSuite {
	public static final Test suite() {
		return new JFaceTestSuite();
	}

	public JFaceTestSuite() {
		addTest(new TestSuite(JFaceTests.class));
		addTest(new TestSuite(JFaceListViewer_ArrayTests.class));
		addTest(new TestSuite(JFaceListViewer_CollectionTests.class));
		addTest(new TestSuite(JFaceTableViewer_Tests.class));
		addTest(new TestSuite(JFaceTableViewer_Filters_Tests.class));
		addTest(new TestSuite(JFaceTableViewer_MasterDetail_Tests.class));
		addTest(new TestSuite(JFaceTableViewer_List_MasterDetail_Tests.class));
		addTest(new TestSuite(JFaceTableViewer_Set_MasterDetail_Tests.class));
		addTest(new TestSuite(JFaceTableViewer_Array_MasterDetail_Tests.class));
		addTest(new TestSuite(JFaceComboViewer_ArrayTests.class));
		addTest(new TestSuite(JFaceComboViewer_CollectionTests.class));	
		addTest(new TestSuite(JFaceComboViewer_EnumTests.class));	
	}
}
