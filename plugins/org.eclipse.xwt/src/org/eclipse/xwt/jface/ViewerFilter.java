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
package org.eclipse.xwt.jface;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.xwt.core.Condition;

public class ViewerFilter extends org.eclipse.jface.viewers.ViewerFilter {
	protected Condition[] conditions = Condition.EMPTY_ARRAY;
	
	public Condition[] getConditions() {
		return conditions;
	}

	public void setConditions(Condition[] conditions) {
		this.conditions = conditions;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		// No condition is same as no filter
		if (conditions.length == 0) {
			return false;
		}
		for (Condition condition : conditions) {
			if (!condition.evaluate(element)) {
				return false;
			}
		}
		return true;
	}
}
