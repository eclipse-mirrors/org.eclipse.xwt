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
package org.eclipse.xwt.tools.ui.designer.core.editor.outline.dnd;

import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public interface OutlineDropManager {

	/**
	 * Create a command for moving 'source' object after 'target' object.
	 * 
	 * @param source
	 * @param target
	 * @param operation  DND.DROP_COPY, DND#DROP_MOVE or DND#DROP_LINK
	 * @return command of dragging from outline.
	 */
	Command getMoveAfter(IStructuredSelection source, Object target, int operation);

	/**
	 * Create a command for moving 'source' object before 'target' object.
	 * 
	 * @param source
	 * @param target
	 * @param operation  DND.DROP_COPY, DND#DROP_MOVE or DND#DROP_LINK
	 * @return command of dragging from outline.
	 */
	Command getMoveBefore(IStructuredSelection source, Object target, int operation);

	/**
	 * Create a command for moving 'source' object on 'target' object.
	 * 
	 * @param source
	 * @param target
	 * @param operation  DND.DROP_COPY, DND#DROP_MOVE or DND#DROP_LINK
	 * @return command of dragging from outline.
	 */
	Command getMoveOn(IStructuredSelection source, Object target, int operation);

	/**
	 * Execute given command with commandStack or not.
	 * 
	 * @param command
	 */
	boolean execute(Command command);
}
