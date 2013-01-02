/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.animation;

import org.eclipse.swt.widgets.Event;

public class StopStoryboard extends ControllableStoryboardAction {
	@Override
	public void run(Event event, Object target, Runnable stateChangedRunnable) {
		Storyboard storyboard = getStoryboard();
		if (storyboard != null) {
			storyboard.stop(event, stateChangedRunnable);
		}
	}
}
