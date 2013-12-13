/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tools.ui.designer.preference;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xwt.tools.ui.designer.core.DesignerPlugin;
import org.eclipse.xwt.tools.ui.designer.layouts.LayoutType;

public class PreferenceInitializer extends AbstractPreferenceInitializer {
	public void initializeDefaultPreferences() {
		IPreferenceStore store = DesignerPlugin.getDefault().getPreferenceStore();
		store.setDefault(Preferences.PROMPT_DURING_CREATION, true);
		store.setDefault(Preferences.DEFAULT_LAYOUT, LayoutType.GridLayout.value());
	}
}
