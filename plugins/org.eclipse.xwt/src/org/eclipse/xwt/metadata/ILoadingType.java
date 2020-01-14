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
package org.eclipse.xwt.metadata;

/**
 * This class is used to indicate when the property can be 
 * initialized during the XML Loading. 
 * 
 * @author yyang <yves.yang@soyatec.com>
 */
public interface ILoadingType {
	public ILoadingType DEFAULT = new ILoadingType() {
		public IValueLoading getValueLoading() {
			return IValueLoading.Normal;
		}		
		public IProperty[] getDependencies() {
			return IProperty.EMPTY_ARRAY;
		}
	};
	
	/**
	 * When the property can be loaded.
	 * @return
	 */
	IValueLoading getValueLoading();

	/**
	 * The dependency properties must be loaded before.  
	 * @return
	 */
	IProperty[] getDependencies();
}
