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
package org.eclipse.xwt.vex;

import org.eclipse.jface.text.IDocument;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;

public interface VEXCodeSynchronizer {

	void add(IDOMNode node, String name);

	void remove(IDOMNode node);

	void update(IDOMNode node);

	/**
	 * Generate the fields
	 * 
	 * @return
	 */
	void generateFields(String fullTypeName, String argName);

	/**
	 * Remove generated fields
	 * 
	 * @return
	 */
	void removeFields(String fullTypeName, String argName);

	void buildInitialization();

	/**
	 * Generate event handles
	 * 
	 * @return
	 */
	boolean generateHandles();

	/**
	 * Jump to the java definition
	 * 
	 * @return
	 */
	boolean openDefinition();

	boolean codeAboutToBeChanged();

	/**
	 * Editor code get changed
	 * 
	 * @return
	 */
	boolean handleInputChanged(IDocument newInput);
}