package org.eclipse.xwt.testsDataBinding.DateTime;

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

