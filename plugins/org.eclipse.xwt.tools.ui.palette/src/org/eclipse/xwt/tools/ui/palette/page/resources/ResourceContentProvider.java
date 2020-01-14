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
package org.eclipse.xwt.tools.ui.palette.page.resources;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class ResourceContentProvider implements IPaletteResourceProvider {
	protected Resource resource;

	public ResourceContentProvider(String resourceUri, String bundleId) {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createURI(resourceUri);
		if (uri.isRelative()) {
			uri = URI.createPlatformPluginURI("/" + bundleId + "/" + resourceUri, true);
		}
		resource = resourceSet.getResource(uri, true);
	}

	public Resource getPaletteResource() {
		return resource;
	}

	public IPaletteContentProvider getContentProvider() {
		return new EntryContentProvider();
	}

	public IPaletteLabelProvider getLabelProvider() {
		return new EntryLabelProvider();
	}
}
