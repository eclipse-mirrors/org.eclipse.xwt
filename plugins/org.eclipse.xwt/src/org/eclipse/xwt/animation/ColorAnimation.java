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
package org.eclipse.xwt.animation;

import org.eclipse.swt.graphics.Color;
import org.eclipse.xwt.XWTException;
import org.eclipse.xwt.animation.internal.ITimeline;
import org.eclipse.xwt.animation.internal.TridentTimeline;

public class ColorAnimation extends AnimationTimeline {
	private Color from;
	private Color by;
	private Color to;
	
	public Color getTo() {
		return to;
	}
	
	public void setTo(Color to) {
		this.to = to;
	}
	
	public Color getFrom() {
		return from;
	}
	
	public void setFrom(Color from) {
		this.from = from;
	}
	
	public Color getBy() {
		return by;
	}
	
	public void setBy(Color by) {
		this.by = by;
	}
		
	protected void updateTimeline(ITimeline timeline, Object target) {
		super.updateTimeline(timeline, target);
		if (timeline instanceof TridentTimeline) {
			TridentTimeline tridentTimeline = (TridentTimeline) (timeline);
			Color from = getFrom();
			Color to = getTo();
			if (from == null && to == null) {
				from = (Color) getCacheValue();
				to = (Color) getCurrentValue(target);
				if (from != null && from.equals(to)) {
					throw new XWTException("action ignored");
				}
			}
			tridentTimeline.addPropertyToInterpolate(getTargetProperty(), from, to);
		}
	}
}
