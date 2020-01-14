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
public class QuarticEase extends EasingFunctionBase {
	public double ease(double normalizedTime) {
		switch (getEasingMode()) {
		case EaseIn:
			return Math.pow(normalizedTime, 4);
		case EaseOut:
			return 1 - Math.pow(1 - normalizedTime, 4);
		case EaseInOut:
			normalizedTime /= 0.5;
			if (normalizedTime < 1)
				return Math.pow(normalizedTime, 4) / 2;
			return (2 - Math.pow(2 - normalizedTime, 4)) / 2;
		default:
			throw new XWTException(getEasingMode().name() + " is supported.");
		}
	}
}
