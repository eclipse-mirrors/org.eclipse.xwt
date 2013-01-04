/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.databinding.self;

import java.net.URL;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;

public class DecoratedText extends Composite {
	protected String decorator;
	
	public DecoratedText(Composite parent, int style) {
		super(parent, style);
	}

	public String getDecorator() {
		return decorator;
	}

	public void setDecorator(String decorator) {
		this.decorator = decorator;
	}
	
	public static void main(String[] args) {

		URL url = DecoratedText.class.getResource(DecoratedText.class
				.getSimpleName()
				+ IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.open(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
