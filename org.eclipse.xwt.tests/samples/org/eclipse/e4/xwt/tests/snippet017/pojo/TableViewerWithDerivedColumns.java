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

package org.eclipse.e4.xwt.tests.snippet017.pojo;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;

/**
 * Demonstrates binding a TableViewer to a collection.
 */
public class TableViewerWithDerivedColumns {
	public static void main(String[] args) {
		ViewModel viewModel = new ViewModel();
		URL url = TableViewerWithDerivedColumns.class.getResource(TableViewerWithDerivedColumns.class.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
		try {
			XWT.open(url, viewModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Person UNKNOWN = new Person("unknown", null, null);
	
	
	protected Person findPerson(List<Person> people, String name) {
		for (Person person : people) {
			if (name.equals(person.getName())) {
				return person;
			}
		}
		return null;
	}

	public void changeMother(Object sender, Event event) {
		final String newMotherName = "Della Duck";
		ViewModel dataContext = (ViewModel) XWT.getDataContext(event.widget);
		
		ComboViewer comboViewer = (ComboViewer) XWT.findElementByName(event.widget, "MotherCombo");

		TableViewer tableViewer = (TableViewer) XWT.findElementByName(event.widget, "TableViewer");

		IObservableValue singleSelection = XWT.observableValue(tableViewer, null, "singleSelection");
		Object selected = singleSelection.getValue();

		IObservableValue motherValue = XWT.observableValue(comboViewer, selected, "mother");
		Person newMother = findPerson(dataContext.getPeople(), newMotherName);
		motherValue.setValue(newMother);
		
		tableViewer.refresh();
		comboViewer.refresh();
	}

	// The data model class. This is normally a persistent class of some sort.
	public static class Person {
		// A property...
		String name = "Donald Duck";
		Person mother;
		Person father;

		public Person(String name, Person mother, Person father) {
			this.name = name;
			this.mother = mother;
			this.father = father;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Person getMother() {
			return mother;
		}

		public void setMother(Person mother) {
			this.mother = mother;
		}

		public Person getFather() {
			return father;
		}

		public void setFather(Person father) {
			this.father = father;
		}

		public String toString() {
			return name;
		}
	}

	// The View's model--the root of our Model graph for this particular GUI.
	//
	// Typically each View class has a corresponding ViewModel class.
	// The ViewModel is responsible for getting the objects to edit from the
	// data access tier. Since this snippet doesn't have any persistent objects
	// ro retrieve, this ViewModel just instantiates a model object to edit.
	public static class ViewModel {
		// The model to bind
		private ArrayList<Person> people = new ArrayList<Person>();
		{
			Person fergus = new Person("Fergus McDuck", UNKNOWN, UNKNOWN);
			Person downy = new Person("Downy O'Drake", UNKNOWN, UNKNOWN);
			Person scrooge = new Person("Scrooge McDuck", downy, fergus);
			Person hortense = new Person("Hortense McDuck", downy, fergus);
			Person quackmore = new Person("Quackmore Duck", UNKNOWN, UNKNOWN);
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
			people.add(UNKNOWN);
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
}
