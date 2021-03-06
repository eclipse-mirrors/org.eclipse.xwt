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
package org.eclipse.xwt.tools.ui.designer.core.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xwt.tools.ui.designer.core.DesignerPlugin;

/**
 * @author jliu (jin.liu@soyatec.com)
 */
public class ProblemCheckerRegistry {

	public static final String EXTENSION_ID = "problemCheckers";
	private static final String CHECKER = "class";

	public final static ProblemCheckerRegistry INSTANCE = new ProblemCheckerRegistry();

	private Map<String, IProblemChecker> name2checker = new HashMap<String, IProblemChecker>();

	private ProblemCheckerRegistry() {
		// 
	}

	public List<IProblemChecker> getCheckers(String bundleId) {
		List<IProblemChecker> checkers = new ArrayList<IProblemChecker>();
		IConfigurationElement[] configElem = Platform.getExtensionRegistry().getConfigurationElementsFor(DesignerPlugin.PLUGIN_ID, EXTENSION_ID);
		for (IConfigurationElement ce : configElem) {
			try {
				if (bundleId != null && !bundleId.equals(ce.getNamespaceIdentifier())) {
					continue;
				}
				String attribute = ce.getAttribute(CHECKER);
				IProblemChecker checker = name2checker.get(attribute);
				if (checker == null) {
					checker = (IProblemChecker) ce.createExecutableExtension(CHECKER);
					name2checker.put(attribute, checker);
				}
				checkers.add(checker);
			} catch (CoreException e) {
				return Collections.emptyList();
			}
		}
		return checkers;
	}
}
