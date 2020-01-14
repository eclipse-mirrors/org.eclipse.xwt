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

import org.eclipse.emf.common.util.URI;
import org.eclipse.xwt.vex.toolpalette.ContextType;
import org.eclipse.xwt.vex.toolpalette.Entry;
import org.w3c.dom.Node;

public interface VEXContext {

	/**
	 * Return the Tool view ID, which is used to open Tool View
	 * 
	 * @return
	 */
	String getToolViewID();

	/**
	 * Return the template context id
	 * 
	 * @return
	 */
	String getTemplateContextID();

	/**
	 * return the default tool palette resource file
	 * 
	 * @return
	 */
	URI getDefaultPaletteFile();

	/**
	 * test if the node corresponds to UI element type
	 * 
	 * @param node
	 * @return
	 */
	boolean hasType(Node node);

	/**
	 * test if the node is an event one
	 * 
	 * @param node
	 * @param name
	 * @return
	 */
	boolean isEventHandle(Node node, String name);

	/**
	 * Find the drop insert position.
	 * 
	 * @param node
	 *            research start node
	 * @param entry
	 *            entry provides research context information such as contextType and scope
	 * @param cursorPosition
	 *            cursor location in the text
	 * @return -1 if non position found
	 */
	int findDropPosition(Node node, Entry entry, int cursorPosition);

	int findDropPosition(Node node, String scope, ContextType contextType, int cursorPosition);
}
