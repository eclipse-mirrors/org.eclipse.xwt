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
package org.eclipse.xwt.tools.ui.designer.core.model;

import org.eclipse.emf.common.notify.Notification;

/**
 * @author jin.liu(jin.liu@soyatec.com)
 */
public abstract class AbstractModelBuilder implements IModelBuilder {

	private ModelNotifySupport notifySupport = new ModelNotifySupport();

	public void addModelListener(ModelChangeListener listener) {
		notifySupport.addModelListener(listener);
	}

	public boolean hasListener(ModelChangeListener listener) {
		return notifySupport.hasListener(listener);
	}

	public void removeModelListener(ModelChangeListener listener) {
		notifySupport.removeModelListener(listener);
	}

	public void dispatchEvent(Notification event) {
		notifySupport.dispatchEvent(event);
	}

	public void dispose() {
		notifySupport.dispose();
	}
}
