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

import org.eclipse.xwt.XWTException;

public class KeyTime {
	private TimeSpan timeSpan;
	private double percent;
	private KeyTimeType type;
	
	public static KeyTime Paced = new KeyTime(KeyTimeType.Paced);
	public static KeyTime Uniform = new KeyTime(KeyTimeType.Uniform);
	
	protected KeyTime(KeyTimeType type) {
		this.type = type;
	}
	
	protected KeyTime(String content) {
		if (content.endsWith("%")) {
			type = KeyTimeType.Percent;
			
			return;
		}
		int index = content.indexOf(":");
		if (index != -1) {
			type = KeyTimeType.TimeSpan;
			timeSpan = TimeSpan.parse(content);
			return;
		}
		throw new XWTException("Wrong syntax: " + content);
	}
	
	public TimeSpan getTimeSpan() {
		return timeSpan;
	}

	public double getPercent() {
		return percent;
	}

	public KeyTimeType getType() {
		return type;
	}
	
	public static KeyTime fromString(String content) {
		if ("Paced".equalsIgnoreCase(content)) {
			return Paced;
		}
		else if ("Uniform".equalsIgnoreCase(content)) {
			return Uniform;
		}
		return new KeyTime(content);
	}
}
