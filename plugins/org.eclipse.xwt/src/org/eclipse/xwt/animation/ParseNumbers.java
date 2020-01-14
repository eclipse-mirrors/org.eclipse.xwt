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

public class ParseNumbers {
	
	public static String intToString(int n, int m, int digits, char ch, int d) {
		String value = Integer.toString(n, m);

		if (ch != 0) {
			String prefix = Character.toString(ch);

			for (int i = digits - value.length(); i > 0; i--) {
				value = prefix + value;
			}
		}

		return value;
	}
}
