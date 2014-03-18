/*******************************************************************************
 * Copyright (c) 2006, 2014 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.ui.workbench.properties;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyRegistry;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyRegistryFactory;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptorProvider;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

@SuppressWarnings("restriction")
public abstract class XWTTabDescriptorProvider implements ITabDescriptorProvider {

	private IWorkbenchPart previousPart;

	private ISelection previousSelection;

	private ITabDescriptor[] cachedResult;

	public ITabDescriptor[] getTabDescriptors(IWorkbenchPart part,
			ISelection selection) {
		if (part != previousPart || selection != previousSelection) {
			this.previousPart = part;
			this.previousSelection = selection;
			List<ITabDescriptor> descriptors = new ArrayList<ITabDescriptor>();

			addTabDescriptors(descriptors);

			// TODO: 2. Define/Get "category" of a TabDescriptor.

			// TODO: Add custom defined Tabs and Section from extensions.
			// FIXME: In some cases (e.g. Selection in the Papyrus Tree
			// outline), the IWorkbenchPart is not an
			// ITabbedPropertySheetPageContributor
			// TODO: Investigate on this case and fix the issue (contributor ==
			// null in this case)
			ITabbedPropertySheetPageContributor contributor;
			if (part instanceof ITabbedPropertySheetPageContributor) {
				contributor = (ITabbedPropertySheetPageContributor) part;
			} else {
				contributor = (ITabbedPropertySheetPageContributor) (part
						.getAdapter(ITabbedPropertySheetPageContributor.class));
			}

			if (contributor != null) {
				// get all tab descriptors for the registered extension points
				// Memory leak here
				TabbedPropertyRegistry registry = TabbedPropertyRegistryFactory
						.getInstance().createRegistry(contributor);

				// invoke dynamically on the tab registry, as method is private
				// problem of implementation of tabbed properties tabbed
				// registry. Either contribution using extension points, either
				// a tabprovider
				// both contribution can not exist together, the only solution
				// is to make a workaround.
				try {
					Method method = TabbedPropertyRegistry.class
							.getDeclaredMethod("getAllTabDescriptors"); //$NON-NLS-1$
					method.setAccessible(true);
					ITabDescriptor[] registeredTabDesriptors;

					registeredTabDesriptors = (ITabDescriptor[]) method
							.invoke(registry);

					if (registeredTabDesriptors != null) {
						for (ITabDescriptor descriptor : registeredTabDesriptors) {
							if (descriptor.getSectionDescriptors().size() > 0) {
								descriptors.add(descriptor);
							}
						}
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			}

			// TODO: need a sort?
			cachedResult = descriptors.toArray(new ITabDescriptor[descriptors
					.size()]);
		}
		return cachedResult;
	}

	abstract protected void addTabDescriptors(List<ITabDescriptor> descriptors);
}
