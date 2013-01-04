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
package org.eclipse.xwt.tests.animation.repeatBehavior;

import junit.framework.TestCase;

import org.eclipse.xwt.animation.Duration;
import org.eclipse.xwt.animation.RepeatBehavior;

public class RepeatBehaviorTests extends TestCase {

	public void testCount() throws Exception {
		RepeatBehavior behavior = RepeatBehavior.parse("0.5x");
		assertTrue(behavior.getHasCount());
		assertEquals(behavior.getCount(), 0.5);		
		assertFalse(behavior.getHasDuration());
	}

	public void testForever() throws Exception {
		RepeatBehavior behavior = RepeatBehavior.parse("Forever");
		assertFalse(behavior.getHasCount());
		assertFalse(behavior.getHasDuration());
	}

	public void testDuration() throws Exception {
		RepeatBehavior behavior = RepeatBehavior.parse("9:10:35");
		assertFalse(behavior.getHasCount());
		assertTrue(behavior.getHasDuration());
		Duration duration = behavior.getDuration();
		assertEquals(duration.getTimeSpan().getSeconds(), 35);
		assertEquals(duration.getTimeSpan().getMinutes(), 10);
		assertEquals(duration.getTimeSpan().getHours(), 9);
	}
}
