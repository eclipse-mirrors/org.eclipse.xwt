/*******************************************************************************
 * Copyright (c) 2006, 2010 The Pampered Chef, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Coconut Palm Software, Inc. - Initial API and implementation
 *     Matthew Hall - bugs 260329, 260337
 *     Yves YANG - port to XWT
 ******************************************************************************/
package org.eclipse.xwt.tests.snippet017;

import java.util.ArrayList;

public class ViewModel {
	// The model to bind
	private ArrayList<Person> people = new ArrayList<Person>();
	{
		Person fergus = new Person("Fergus McDuck", TableViewerWithDerivedColumns.UNKNOWN, TableViewerWithDerivedColumns.UNKNOWN);
		Person downy = new Person("Downy O'Drake", TableViewerWithDerivedColumns.UNKNOWN, TableViewerWithDerivedColumns.UNKNOWN);
		Person scrooge = new Person("Scrooge McDuck", downy, fergus);
		Person hortense = new Person("Hortense McDuck", downy, fergus);
		Person quackmore = new Person("Quackmore Duck", TableViewerWithDerivedColumns.UNKNOWN, TableViewerWithDerivedColumns.UNKNOWN);
		Person della = new Person("Della Duck", hortense, quackmore);
		Person donald = new Person("Donald Duck", hortense, quackmore);
		donald.setFather(quackmore);
		donald.setMother(hortense);
		della.setFather(quackmore);
		della.setMother(hortense);
		hortense.setMother(downy);
		hortense.setFather(fergus);
		scrooge.setMother(downy);
		scrooge.setFather(fergus);
		people.add(TableViewerWithDerivedColumns.UNKNOWN);
		people.add(downy);
		people.add(fergus);
		people.add(scrooge);
		people.add(quackmore);
		people.add(hortense);
		people.add(della);
		people.add(donald);
	}

	public ArrayList<Person> getPeople() {
		return people;
	}
}