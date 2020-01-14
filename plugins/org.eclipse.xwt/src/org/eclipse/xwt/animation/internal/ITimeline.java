/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.animation.internal;

import org.pushingpixels.trident.TimelineScenario.TimelineScenarioActor;

public interface ITimeline extends TimelineScenarioActor {
	public Object getTarget();
	
	public void playReverse();

	public void end();

	public void abort();

	public void cancel();

	public void pause();

	public void resume();
	
	public void addStateChangedRunnable(Runnable runnable);
	
	public void removeStateChangedRunnable(Runnable runnable);
}
