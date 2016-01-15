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

import java.util.Date;

public class Person extends ModelObject {
	  private String name;

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    firePropertyChange("name", this.name, this.name = name);
	  }
	  
	  private Boolean married = false; ;

	  public Boolean getMarried() {
	    return married;
	  }

	  public void setMarried(Boolean married) {
	    firePropertyChange("married", this.married, this.married = married);
	  }
	  
	  private Date birthday;

	  public Date getBirthday() {
	    return birthday;
	  }

	  public void setBirthday(Date birthday) {
	    firePropertyChange("birthday", this.birthday, this.birthday = birthday);
	  }
	} 

