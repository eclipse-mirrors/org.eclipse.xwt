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
package org.eclipse.xwt.tools.ui.designer.parts.misc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xwt.tools.ui.designer.parts.CompositeEditPart;
import org.eclipse.xwt.tools.ui.designer.parts.ControlEditPart;

public class CompositeEditPartHelper {

	/**
	 * Remove popup menus, just keep the ControlEditParts
	 * 
	 * @param compositeEditPart
	 * @return
	 */
	public static List<ControlEditPart> getChildren(
			CompositeEditPart compositeEditPart) {
		List<ControlEditPart> collector = new ArrayList<ControlEditPart>();
		for (Iterator<?> iterator = compositeEditPart.getChildren().iterator(); iterator
				.hasNext();) {
			Object element = iterator.next();
			if (element instanceof ControlEditPart) {
				collector.add((ControlEditPart) element);
			}
		}
		return collector;
	}
}
