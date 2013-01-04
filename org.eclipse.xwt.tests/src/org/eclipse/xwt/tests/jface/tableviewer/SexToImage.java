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
package org.eclipse.xwt.tests.jface.tableviewer;

import java.net.URL;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xwt.IValueConverter;
import org.eclipse.xwt.XWTException;
import org.eclipse.xwt.utils.ResourceManager;

public class SexToImage implements IValueConverter {
	public Object convertBack(Object value) {
		return null;
	}

	public Object getFromType() {
		return int.class;
	}

	public Object getToType() {
		return Image.class;
	}

	public Object convert(Object fromObject) {
		Sex sex = (Sex) fromObject;
		if (sex == null) {
			sex = Sex.Male;
		}
		switch (sex) {
		case Female:
			URL resource = SexToImage.class.getResource("female32.png");
			return ResourceManager.resources.getImage(resource);
		case Male:
			resource = SexToImage.class.getResource("male32.png");
			return ResourceManager.resources.getImage(resource);
		default:
			throw new XWTException("Unsupported Sex type");
		}
	}
}
