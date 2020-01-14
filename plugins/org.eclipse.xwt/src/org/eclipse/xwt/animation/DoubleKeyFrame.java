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

import org.pushingpixels.trident.Timeline;

public abstract class DoubleKeyFrame {
	public static final DoubleKeyFrame[] EMPTY_ARRAY = {}; 
	private KeyTime keyTime;
	private Double value;

	public KeyTime getKeyTime() {
		return keyTime;
	}

	public void setKeyTime(KeyTime keyTime) {
		this.keyTime = keyTime;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	protected void start(Timeline timeline, Object target) {
	}
}
