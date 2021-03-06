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

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.xwt.XWTException;
import org.eclipse.xwt.animation.internal.ITimeline;
import org.eclipse.xwt.animation.internal.TridentTimeline;
import org.eclipse.xwt.animation.interpolator.RectanglePropertyInterpolator;
import org.pushingpixels.trident.TridentConfig;

/**
 * 
 * @author yyang
 */
public class RectangleAnimation extends AnimationTimeline {
	private Rectangle from;
	private Rectangle to;
	private Rectangle by;
	
	private IEasingFunction easingFunction;

	static {
		TridentConfig.getInstance().addPropertyInterpolator(new RectanglePropertyInterpolator());
	}
	
	public Rectangle getFrom() {
		return from;
	}

	public void setFrom(Rectangle from) {
		this.from = from;
	}

	public Rectangle getTo() {
		return to;
	}

	public void setTo(Rectangle to) {
		this.to = to;
	}
	
	public IEasingFunction getEasingFunction() {
		return easingFunction;
	}

	public void setEasingFunction(IEasingFunction easingFunction) {
		this.easingFunction = easingFunction;
	}

	protected void updateTimeline(ITimeline timeline, Object target) {
		super.updateTimeline(timeline, target);
		if (timeline instanceof TridentTimeline) {
			TridentTimeline tridentTimeline = (TridentTimeline) (timeline);
			Rectangle from = getFrom();
			Rectangle to = getTo();
			if (from == null && to == null) {
				from = (Rectangle) getCacheValue();
				to = (Rectangle) getCurrentValue(target);
				if (from == null || from.width == 0 && from.height == 0) {
					setCacheValue(to);
					throw new XWTException("action ignored");
				}
				if (from != null && from.equals(to)) {
					throw new XWTException("action ignored");
				}
			}
			tridentTimeline.addPropertyToInterpolate(getTargetProperty(), from, to);
			tridentTimeline.setEasingFunction(getEasingFunction());
		}
	}
}
