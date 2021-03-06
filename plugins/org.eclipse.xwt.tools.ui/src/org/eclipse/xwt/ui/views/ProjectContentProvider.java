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
package org.eclipse.xwt.ui.views;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.xwt.ILoadingContext;
import org.eclipse.xwt.ui.utils.ProjectContext;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

public class ProjectContentProvider implements IContentProvider {
	protected URL contentURL;
	protected ILoadingContext loadingContext;

	public ProjectContentProvider(IFile file) {
		URI uri = file.getLocationURI();

		IJavaProject javaProject = JavaCore.create(file.getProject());
		if (javaProject.exists()) {
			loadingContext = ProjectContext.getContext(javaProject);
		}
		try {
			contentURL = uri.toURL();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	public URL getContentURL() {
		return contentURL;
	}

	public ILoadingContext getLoadingContext() {
		return loadingContext;
	}

}
