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
package org.eclipse.xwt.animation;

import org.eclipse.xwt.XWTException;

/**
 * 
 * @author yyang
 */
public class BackEase extends EasingFunctionBase {
	private double amplitude = 1;

	public double getAmplitude() {
		return amplitude;
	}

	public void setAmplitude(double amplitude) {
		this.amplitude = amplitude;
	}

	public double ease(double normalizedTime) {
		switch (getEasingMode()) {
		case EaseIn:
			return easeValue(normalizedTime, getAmplitude());
		case EaseOut:
			return 1 - easeValue(1 - normalizedTime, getAmplitude());
		case EaseInOut:
			normalizedTime /= 0.5;
			if (normalizedTime < 1)
				return easeValue(normalizedTime, getAmplitude()) / 2;
			return (2 - easeValue(2 - normalizedTime, getAmplitude())) / 2;
		default:
			throw new XWTException(getEasingMode().name() + " is supported.");
		}
	}

	protected double easeValue(double normalizedTime, double amplitude) {
		return normalizedTime * normalizedTime * normalizedTime
				- normalizedTime * amplitude
				* Math.sin(normalizedTime * Math.PI);
	}
}
