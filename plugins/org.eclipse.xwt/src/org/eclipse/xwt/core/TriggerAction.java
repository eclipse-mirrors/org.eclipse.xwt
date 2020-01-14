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
package org.eclipse.xwt.core;

import org.eclipse.swt.widgets.Event;

public abstract class TriggerAction {
	public static final TriggerAction[] EMPTY_ARRAY = new TriggerAction[0];
	
	public abstract void run(Event event, Object target, Runnable stateChangedRunnable);
	
	public abstract void initialize(Object target);
	
	public abstract void endFinalize(Object target);
}
