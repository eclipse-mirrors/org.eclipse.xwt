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
package org.eclipse.ve.internal.swt.targetvm.unix;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.graphics.GC;

public class DisposeUtil {

	/**
	 * in MAC Cocoa, we should not dispose the GC for an image. The image will dispose
	 * the gc automatically.
	 * 
	 * @param gc
	 */
	public static void dispose(GC gc) {
		if (!Platform.getWS().equals(Platform.WS_COCOA)) {
			gc.dispose();
		}
	}
}
