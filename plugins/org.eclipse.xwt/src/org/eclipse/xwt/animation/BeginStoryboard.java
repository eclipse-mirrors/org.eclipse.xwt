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
package org.eclipse.xwt.animation;

import org.eclipse.swt.widgets.Event;
import org.eclipse.xwt.core.TriggerAction;
import org.eclipse.xwt.internal.utils.UserData;

public class BeginStoryboard extends TriggerAction {
	private HandoffBehavior handoffBehavior = HandoffBehavior.SnapshotAndReplace;
	private String name;
	private Storyboard storyboard;
		
	/**
	 * Getter of the property <tt>HandoffBehavior</tt>
	 * 
	 * @return Returns the handoffBehavior.
	 * @uml.property name="HandoffBehavior"
	 */
	public HandoffBehavior getHandoffBehavior() {
		return handoffBehavior;
	}

	/**
	 * Setter of the property <tt>HandoffBehavior</tt>
	 * 
	 * @param HandoffBehaviorProperty
	 *            The handoffBehavior to set.
	 * @uml.property name="HandoffBehavior"
	 */
	public void setHandoffBehavior(HandoffBehavior handoffBehavior) {
		this.handoffBehavior = handoffBehavior;
	}

	/**
	 * Getter of the property <tt>Name</tt>
	 * 
	 * @return Returns the name.
	 * @uml.property name="Name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of the property <tt>Name</tt>
	 * 
	 * @param NameProperty
	 *            The name to set.
	 * @uml.property name="Name"
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter of the property <tt>Storyboard</tt>
	 * 
	 * @return Returns the Storyboard.
	 * @uml.property name="Storyboard"
	 */
	public Storyboard getStoryboard() {
		return storyboard;
	}

	/**
	 * Setter of the property <tt>Storyboard</tt>
	 * 
	 * @param NameProperty
	 *            The Storyboard to set.
	 * @uml.property name="Storyboard"
	 */
	public void setStoryboard(Storyboard storyboard) {
		this.storyboard = storyboard;
	}
	
	@Override
	public void initialize(Object target) {
		if (name != null) {
			UserData.findScopeKeeper(target).addNamedObject(name, this);			
		}
		getStoryboard().initialize(target);
	}

	@Override
	public void endFinalize(Object target) {
		getStoryboard().endFinalize(target);
	}

	@Override
	public void run(Event event, Object target, Runnable stateChangedRunnable) {
		getStoryboard().start(event, target, stateChangedRunnable);
	}
}
