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
package org.eclipse.xwt.tools.ui.designer.core.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.xwt.ui.utils.ProjectUtil;

/**
 * To minimize the dependency in e4 Visual Designer
 * 
 * TODO remove the direct dependency between e4/XWT
 * 
 * @author yyang
 */
public class XWTProjectUtil {
	public static void updateXWTWorkbenchDependencies(IProject project) {
		ProjectUtil.updateXWTWorkbenchDependencies(project);
	}
}
