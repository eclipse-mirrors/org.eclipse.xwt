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
package org.eclipse.xwt.databinding;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.xwt.IDataBinding;
import org.eclipse.xwt.IDataProvider;
import org.eclipse.xwt.IValidationRule;
import org.eclipse.xwt.IValueConverter;
import org.eclipse.xwt.internal.core.Binding;
import org.eclipse.xwt.internal.core.BindingExpressionPath;
import org.eclipse.xwt.internal.core.UpdateSourceTrigger;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public abstract class AbstractDataBinding implements IDataBinding {
	private IDataProvider dataProvider;

	private Binding binding;

	private BindingExpressionPath targetPropertySegments;

	public BindingExpressionPath getSourcePropertyExpression() {
		return binding.getPathPropertySegments();
	}

	public BindingExpressionPath getTargetPropertyExpression() {
		return targetPropertySegments;
	}

	public AbstractDataBinding(Binding binding, IDataProvider dataProvider) {
		this.binding = binding;
		this.dataProvider = dataProvider;

		targetPropertySegments = new BindingExpressionPath(getTargetProperty());
	}

	/**
	 * @return the dataProvider
	 */
	public IDataProvider getDataProvider() {
		return dataProvider;
	}

	/**
	 * @param dataProvider
	 *            the dataProvider to set
	 */
	public void setDataProvider(IDataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	/**
	 *
	 */
	public BindingMode getBindingMode() {
		return binding.getMode();
	}

	/**
	 * Returns the name of the data binding context this binding is associated
	 * with
	 * 
	 * @return
	 */
	protected IBindingContext getDataBindingContext() {
		return binding.getBindingContext();
	}

	/**
	 *
	 */
	public IValueConverter getConverter() {
		return binding.getConverter();
	}

	/**
	 * @return the target
	 */
	public Object getControl() {
		return binding.getControl();
	}

	/**
	 * @return the target
	 */
	public Object getHost() {
		return binding.getHost();
	}

	/**
	 * 
	 * @return
	 */
	public BindingMode getMode() {
		return binding.getMode();
	}

	/**
	 * 
	 * @param mode
	 */
	public void setMode(BindingMode mode) {
		binding.setMode(mode);
	}

	/**
	 * 
	 * @return
	 */
	protected String getSourceProperty() {
		return binding.getPath();
	}

	/**
	 * 
	 * @return
	 */
	protected String getTargetProperty() {
		return binding.getType();
	}

	public IValidationRule[] getValidators() {
		return binding.getValidationRules();
	}

	public UpdateSourceTrigger getUpdateSourceTrigger() {
		return binding.getUpdateSourceTrigger();
	}

	protected IObservable getObservableSource() {
		return binding.getObservableSource();
	}

	protected void setObservableSource(IObservable observableSource) {
		binding.setObservableSource(observableSource);
	}
}
