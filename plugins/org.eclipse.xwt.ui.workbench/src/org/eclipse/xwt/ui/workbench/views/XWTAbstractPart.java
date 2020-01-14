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
package org.eclipse.xwt.ui.workbench.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.net.URL;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.services.IStylingEngine;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xwt.DefaultLoadingContext;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.XWTLoader;
import org.eclipse.xwt.css.CSSHandler;
import org.eclipse.xwt.internal.utils.LoggerManager;
import org.eclipse.xwt.ui.workbench.IContentPart;

/**
 * The default class to handle the connection with e4 workbench.
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public abstract class XWTAbstractPart implements IContentPart {
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(
			this);
	
	private boolean constructing = true;

	private boolean xwtCaching = true;
	
	@Inject
	private Composite parent;

	@Inject
	private IStylingEngine engine;

	@Inject
	private EHandlerService handlerService;

	@Inject
	private ECommandService commandService;

	private IEclipseContext context;

	protected Object dataContext;

	static {
		try {
			XWT.registerNamespaceHandler(CSSHandler.NAMESPACE,
					CSSHandler.handler);
		} catch (Exception e) {
		}
	}

	public IEclipseContext getContext() {
		return context;
	}

	@Inject
	public void setContext(IEclipseContext context) {
		if (context == null) {
			return;
		}
		this.context = context;
	}

	/*
	 * Called by injection engine
	 */
	@SuppressWarnings("unused")
	@PostConstruct
	final private void partPostConstruct() {
		constructing = false;
	}
		
	public boolean isConstructing() {
		return constructing;
	}
	
	public IStylingEngine getStyleEngine() {
		return engine;
	}
	
	public boolean isXWTCaching() {
		return xwtCaching;
	}

	public void setXWTCaching(boolean pmfCaching) {
		this.xwtCaching = pmfCaching;
	}

	public EHandlerService getHandlerService() {
		return handlerService;
	}

	public ECommandService getCommandService() {
		return commandService;
	}

	public Object getDataContext() {
		return dataContext;
	}
	
	
	public void setDataContext(Object dataContext) {
		this.dataContext = dataContext;
	}

	public Composite getParent() {
		return parent;
	}

	@Inject
	public void setParent(Composite parent) {
		if (parent != null && this.parent == null) {
			this.parent = parent;
			parent.getShell().setBackgroundMode(SWT.INHERIT_DEFAULT);
		}
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(propertyName, listener);
	}

	public void firePropertyChange(PropertyChangeEvent evt) {
		changeSupport.firePropertyChange(evt);
	}
	
	public ClassLoader getClassLoader() {
		return this.getClass().getClassLoader();
	}

	protected void refresh(URL url, Object dataContext, ClassLoader loader) {
		if (parent == null || isConstructing()) {
			return;
		}
		parent.setVisible(false);
		for (Control child : parent.getChildren()) {
			child.dispose();
		}
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		try {
			XWT.setLoadingContext(new DefaultLoadingContext(loader));
			HashMap<String, Object> newOptions = new HashMap<String, Object>();
			newOptions.put(XWTLoader.CONTAINER_PROPERTY, parent);
			newOptions.put(XWTLoader.DATACONTEXT_PROPERTY, dataContext);
			newOptions.put(XWTLoader.CLASS_PROPERTY, this);
			if (isXWTCaching()) {
				newOptions.put(XWTLoader.XML_CACHE_PROPERTY, this);
			}
			XWT.loadWithOptions(url, newOptions);
			GridLayoutFactory.fillDefaults().generateLayout(parent);
			parent.layout(true, true);
		} catch (Exception e) {
			LoggerManager.log(e);
		} finally {
			Thread.currentThread().setContextClassLoader(classLoader);
			parent.setVisible(true);
		}
	}
	
	public Shell getShell() {
		return parent.getShell();
	}
}
