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
package org.eclipse.xwt.tools.ui.designer.core;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class DesignerPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.soyatec.tools.designer";
	public static final IPath VE_CACHE_ROOT_NAME = new Path(".cache");
	// The shared instance
	private static DesignerPlugin plugin;

	/**
	 * The constructor
	 */
	public DesignerPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static DesignerPlugin getDefault() {
		return plugin;
	}

	public static void log(IStatus status) {
		log(status, 0, true);
	}

	public static void log(IStatus status, boolean appendLogger) {
		log(status, 0, appendLogger);
	}

	public static void log(IStatus status, int nesting) {
		log(status, nesting, true);
	}

	public static void log(IStatus status, int nesting, boolean appendLogger) {
		getDefault().getLog().log(status);
	}

	/**
	 * Log Message Info
	 */

	public static void logInfo(String message) {
		logInfo(message, 0, true);
	}

	public static void logInfo(String message, boolean appendLogger) {
		logInfo(message, 0, appendLogger);
	}

	public static void logInfo(String message, int nesting) {
		logInfo(message, nesting, true);
	}

	public static void logInfo(String message, int nesting, boolean appendLogger) {
		log(newStatus(IStatus.INFO, message, null), nesting, appendLogger);
	}

	/**
	 * Log Message and Throwable Info
	 */

	public static void logInfo(String message, Throwable t) {
		logInfo(message, t, 0, true);
	}

	public static void logInfo(String message, Throwable t, boolean appendLogger) {
		logInfo(message, t, 0, appendLogger);
	}

	public static void logInfo(String message, Throwable t, int nesting) {
		logInfo(message, t, nesting, true);
	}

	public static void logInfo(String message, Throwable t, int nesting,
			boolean appendLogger) {
		log(newStatus(IStatus.INFO, message, t), nesting, appendLogger);
	}

	/**
	 * Log Throwable Info
	 */

	public static void logInfo(Throwable t) {
		logInfo(t, 0, true);
	}

	public static void logInfo(Throwable t, boolean appendLogger) {
		logInfo(t, 0, appendLogger);
	}

	public static void logInfo(Throwable t, int nesting) {
		logInfo(t, nesting, true);
	}

	public static void logInfo(Throwable t, int nesting, boolean appendLogger) {
		log(newStatus(IStatus.INFO, t.getMessage(), t), nesting, appendLogger);
	}

	/**
	 * Log Message Error
	 */

	public static void logError(String message) {
		logError(message, 0, true);
	}

	public static void logError(String message, boolean appendLogger) {
		logError(message, 0, appendLogger);
	}

	public static void logError(String message, int nesting) {
		logError(message, nesting, true);
	}

	public static void logError(String message, int nesting,
			boolean appendLogger) {
		log(newStatus(IStatus.ERROR, message, null), nesting, appendLogger);
	}

	/**
	 * Log Message and Throwable Error
	 */

	public static void logError(String message, Throwable t) {
		logError(message, t, 0, true);
	}

	public static void logError(String message, Throwable t,
			boolean appendLogger) {
		logError(message, t, 0, appendLogger);
	}

	public static void logError(String message, Throwable t, int nesting) {
		logError(message, t, nesting, true);
	}

	public static void logError(String message, Throwable t, int nesting,
			boolean appendLogger) {
		log(newStatus(IStatus.ERROR, message, t), nesting, appendLogger);
	}

	/**
	 * Log Throwable Error
	 */

	public static void logError(Throwable t) {
		logError(t, 0, true);
	}

	public static void logError(Throwable t, boolean appendLogger) {
		logError(t, 0, appendLogger);
	}

	public static void logError(Throwable t, int nesting) {
		logError(t, nesting, true);
	}

	public static void logError(Throwable t, int nesting, boolean appendLogger) {
		log(newStatus(IStatus.ERROR, t.getMessage(), t), nesting, appendLogger);
	}

	/**
	 * Log Message Warning
	 */

	public static void logWarning(String message) {
		logWarning(message, 0, true);
	}

	public static void logWarning(String message, boolean appendLogger) {
		logWarning(message, 0, appendLogger);
	}

	public static void logWarning(String message, int nesting) {
		logWarning(message, nesting, true);
	}

	public static void logWarning(String message, int nesting,
			boolean appendLogger) {
		log(newStatus(IStatus.WARNING, message, null), nesting, appendLogger);
	}

	/**
	 * Log Message and Throwable Warning
	 */

	public static void logWarning(String message, Throwable t) {
		logWarning(message, t, 0, true);
	}

	public static void logWarning(String message, Throwable t,
			boolean appendLogger) {
		logWarning(message, t, 0, appendLogger);
	}

	public static void logWarning(String message, Throwable t, int nesting) {
		logWarning(message, t, nesting, true);
	}

	public static void logWarning(String message, Throwable t, int nesting,
			boolean appendLogger) {
		log(newStatus(IStatus.WARNING, message, t), nesting, appendLogger);
	}

	/**
	 * Log Throwable Warning
	 */

	public static void logWarning(Throwable t) {
		logWarning(t, 0, true);
	}

	public static void logWarning(Throwable t, boolean appendLogger) {
		logWarning(t, 0, appendLogger);
	}

	public static void logWarning(Throwable t, int nesting) {
		logWarning(t, nesting, true);
	}

	public static void logWarning(Throwable t, int nesting, boolean appendLogger) {
		log(newStatus(IStatus.WARNING, t.getMessage(), t), nesting,
				appendLogger);
	}

	/**
	 * Create an IStatus
	 * 
	 * @return a new IStatus
	 */
	public static IStatus newStatus(int severity, String message,
			Throwable exception) {
		return new Status(severity, PLUGIN_ID, 0, message, exception);
	}
}
