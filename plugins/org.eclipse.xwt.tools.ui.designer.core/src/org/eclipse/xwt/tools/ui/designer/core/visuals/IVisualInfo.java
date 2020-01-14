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
/*
 * $RCSfile: IVisualInfo.java,v $ $Revision: 1.4 $ $Date: 2010/06/18 00:15:24 $
 */
package org.eclipse.xwt.tools.ui.designer.core.visuals;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.xwt.tools.ui.designer.core.images.IImageNotifier;

/**
 * @author jliu jin.liu@soyatec.com
 */
public interface IVisualInfo extends IImageNotifier {

	public Object getVisualObject();

	public void setVisualObject(Object visualObject);

	public boolean isRoot();

	public Rectangle getBounds();

	public Rectangle getClientArea();

}
