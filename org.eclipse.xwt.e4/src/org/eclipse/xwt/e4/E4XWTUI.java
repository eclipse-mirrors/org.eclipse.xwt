/*******************************************************************************
 * Copyright (c) 2013 Eclipse XWT Project.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Erdal Karaca - initial API and implementation
 ******************************************************************************/
package org.eclipse.xwt.e4;

import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xwt.DefaultLoadingContext;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.INamespaceHandler;
import org.eclipse.xwt.IXWTLoader;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.core.IUserDataConstants;
import org.eclipse.xwt.e4.internal.Case;
import org.eclipse.xwt.e4.internal.DataBean;
import org.eclipse.xwt.e4.internal.Export;
import org.eclipse.xwt.e4.internal.ExportsProperty;
import org.eclipse.xwt.e4.internal.Make;
import org.eclipse.xwt.e4.internal.Switch;
import org.eclipse.xwt.e4.internal.UIRefProperty;
import org.eclipse.xwt.e4.internal.Var;
import org.eclipse.xwt.e4.internal.VarsProperty;
import org.eclipse.xwt.e4.internal.converters.Instanceof;
import org.eclipse.xwt.e4.internal.widgets.PageBook;
import org.eclipse.xwt.e4.internal.widgets.PageBookItem;
import org.eclipse.xwt.internal.core.Binding;
import org.eclipse.xwt.internal.core.ScopeKeeper;
import org.eclipse.xwt.internal.utils.UserData;
import org.eclipse.xwt.metadata.IMetaclass;

public class E4XWTUI {
	static {
		XWT.registerMetaclass(DataBean.class);
		XWT.registerMetaclass(Make.class);

		{
			XWT.registerMetaclass(Export.class);
			XWT.registerMetaclass(Var.class);
			IMetaclass mc = XWT.getMetaclass(Widget.class);
			mc.addProperty(new ExportsProperty());
			mc.addProperty(new VarsProperty());
		}

		{
			XWT.registerMetaclass(Switch.class);
			XWT.registerMetaclass(Case.class);
		}

		{
			IMetaclass mc = XWT.getMetaclass(Composite.class);
			mc.addProperty(new UIRefProperty());
		}

		XWT.registerMetaclass(PageBook.class);
		XWT.registerMetaclass(PageBookItem.class);

		XWT.registerMetaclass(Instanceof.class);

		XWT.registerConvertor(new IConverter() {
			@Override
			public Object getToType() {
				return Object.class;
			}

			@Override
			public Object getFromType() {
				return Make.class;
			}

			@Override
			public Object convert(Object fromObject) {
				Make make = (Make) fromObject;
				return make.getMade();
			}
		});

		XWT.registerNamespaceHandler("http://www.eclipse.org/xwt/e4",
				new INamespaceHandler() {
					@Override
					public void handleAttribute(Widget widget, Object target,
							String name, String value) {
						// TODO
					}
				});
	}

	protected Logger log = Logger.getLogger(this.getClass().getName());

	private Object root;
	private DataBean dataBean = new DataBean();

	public void setInput(Object newInput) {
		dataBean.setInput(newInput);
	}

	protected URL doGetUrl() {
		Class<?> clazz = this.getClass();
		return clazz.getResource(clazz.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
	}

	@PostConstruct
	public void createUI(Composite container, IEclipseContext context) {
		if (root != null) {
			throw new IllegalStateException("This UI has already been loaded.");
		}

		if (container.getLayout() == null) {
			container.setLayout(new FillLayout());
		}

		container.setData(IEclipseContext.class.getName(), context);
		container.setData(E4XWTUI.class.getName(), this);

		URL url = doGetUrl();
		Map<String, Object> options = new HashMap<String, Object>();
		populateOptions(options);

		if (container != null) {
			options.put(IXWTLoader.CONTAINER_PROPERTY, container);
		}

		try {
			XWT.setLoadingContext(new DefaultLoadingContext(this.getClass()
					.getClassLoader()));
			root = XWT.loadWithOptions(url, options);
			injectXWTBindings(context);
		} catch (Exception e) {
			log.severe(e.getMessage());
			e.printStackTrace();
		}
	}

	private void injectXWTBindings(IEclipseContext context) {
		UserData userData = (UserData) ((Widget) root)
				.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		ScopeKeeper map = (ScopeKeeper) userData
				.getData(IUserDataConstants.XWT_NAMECONTEXT_KEY);
		Collection<String> names = map.names();
		for (String name : names) {
			Object object = map.getNamedObject(name);

			if (object instanceof Var) {
				continue;
			}

			context.set(name, object);
		}
	}

	protected void populateOptions(Map<String, Object> options) {
		options.put(IXWTLoader.CLASS_PROPERTY, this);
		options.put(IXWTLoader.DATACONTEXT_PROPERTY, dataBean);
	}

	public void open() {
		URL url = doGetUrl();
		Map<String, Object> options = new HashMap<String, Object>();
		populateOptions(options);

		try {
			XWT.open(url, options);
			root = Display.getDefault().getActiveShell();
		} catch (Exception e) {
			log.severe(e.getMessage());
			e.printStackTrace();
		}
	}

	public Object getRoot() {
		return root;
	}

	@SuppressWarnings("unchecked")
	protected <T> T findByName(String name) {
		return (T) XWT.findElementByName(getRoot(), name);
	}

	public URL getUrl() {
		return doGetUrl();
	}

	@SuppressWarnings("unchecked")
	public static <T> T findData(Class<T> t, Object target) {
		if (target instanceof Widget) {
			T ret = (T) ((Widget) target).getData(t.getName());

			if (ret != null) {
				return ret;
			}
		}

		if (target instanceof Control) {
			return findData(t, ((Control) target).getParent());
		}

		if (target instanceof Viewer) {
			Control control = ((Viewer) target).getControl();
			return findData(t, control);
		}

		if (target instanceof Binding) {
			T data = findData(t, ((Binding) target).getControl());

			if (data != null) {
				return data;
			}

			return findData(t, ((Binding) target).getHost());
		}

		return null;
	}
}
