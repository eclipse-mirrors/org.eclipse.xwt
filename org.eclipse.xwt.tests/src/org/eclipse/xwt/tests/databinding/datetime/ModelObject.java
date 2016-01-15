/*******************************************************************************
 * Copyright (c) 2006, 2016 Soyatec (http://www.soyatec.com) and others.       *
 * All rights reserved. This program and the accompanying materials            *
 * are made available under the terms of the Eclipse Public License v1.0       *
 * which accompanies this distribution, and is available at                    *
 * http://www.eclipse.org/legal/epl-v10.html                                   *
 *                                                                             *  
 * Contributors:                                                               *        
 *     Soyatec - initial API and implementation                                *
 *******************************************************************************/
package org.eclipse.xwt.tests.databinding.datetime;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelObject {
  private final PropertyChangeSupport changeSupport = 
      new PropertyChangeSupport(this);

  public void addPropertyChangeListener(PropertyChangeListener 
      listener) {
    changeSupport.addPropertyChangeListener(listener);
  }

  public void removePropertyChangeListener(PropertyChangeListener 
      listener) {
    changeSupport.removePropertyChangeListener(listener);
  }

  protected void firePropertyChange(String propertyName, Object oldValue,
      Object newValue) {
    changeSupport.firePropertyChange(propertyName, oldValue, newValue);
  }
} 
