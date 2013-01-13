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
package org.eclipse.xwt.tests.snippet017.pojo;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xwt.IConstants;
import org.eclipse.xwt.XWT;
import org.eclipse.xwt.tests.XWTTestCase;
import org.eclipse.xwt.tests.snippet017.pojo.TableViewerWithDerivedColumns.Person;
import org.eclipse.xwt.tests.snippet017.pojo.TableViewerWithDerivedColumns.ViewModel;

public class Snippet017Tests extends XWTTestCase {
	protected Person findPerson(List<Person> people, String name) {
		for (Person person : people) {
			if (name.equals(person.getName())) {
				return person;
			}
		}
		return null;
	}
	
	public void testTableViewerWithDerivedColumns() throws Exception {
		final String name = "Scrooge McDuck";
		final String motherName = "Downy O'Drake";
		final String fatherName = "Fergus McDuck";
		URL url = Snippet017Tests.class.getResource(TableViewerWithDerivedColumns.class.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new ViewModel(), new Runnable() {
			public void run() {
				Object element = XWT.findElementByName(root, "TableViewer");
				assertTrue(element instanceof TableViewer);
				TableViewer tableViewer = (TableViewer) element;
				Object dataContext = XWT.getDataContext(element);
				assertTrue(dataContext instanceof ViewModel);
				ViewModel viewModel = (ViewModel) dataContext; 
				ArrayList<Person> people = viewModel.getPeople();
				
				IObservableValue observableValue = XWT.observableValue(tableViewer, null, "singleSelection");
				
				Person person = findPerson(people, name);
				observableValue.setValue(person);
			}
		}, 
		new Runnable() {
			public void run() {
				Object viewer = XWT.findElementByName(root, "TableViewer");
				assertTrue(viewer instanceof TableViewer);
				TableViewer tableViewer = (TableViewer) viewer;
				Object dataContext = XWT.getDataContext(viewer);
				assertTrue(dataContext instanceof ViewModel);
				ViewModel viewModel = (ViewModel) dataContext; 
				ArrayList<Person> people = viewModel.getPeople();
				
				IObservableValue observableValue = XWT.observableValue(tableViewer, null, "singleSelection");
				Person person = findPerson(people, name);
				assertEquals(observableValue.getValue(), person);
				
				{
					Object element = XWT.findElementByName(root, "NameText");
					assertTrue(element instanceof Text);
					Text nameText = (Text) element;
					assertEquals(nameText.getText(), name);
				}
				
				{
					Object element = XWT.findElementByName(root, "MotherCombo");
					assertTrue(element instanceof ComboViewer);
					ComboViewer comboViewer = (ComboViewer) element;

					IObservableValue singleSelection = XWT.observableValue(comboViewer, null, "singleSelection");
					Object selected = singleSelection.getValue();
					assertTrue(selected instanceof Person);
					Person mother = (Person) selected;
					assertEquals(mother.getName(), motherName);
				}
				
				{
					Object element = XWT.findElementByName(root, "FatherCombo");
					assertTrue(element instanceof ComboViewer);
					ComboViewer comboViewer = (ComboViewer) element;

					IObservableValue singleSelection = XWT.observableValue(comboViewer, null, "singleSelection");
					Object selected = singleSelection.getValue();
					assertTrue(selected instanceof Person);
					Person mother = (Person) selected;
					assertEquals(mother.getName(), fatherName);
				}
			}
		});
	}
	
	
	public void testTableViewerWithDerivedColumns_Text() throws Exception {
		final String name = "Scrooge McDuck";
		final String newName = "Scrooge McDuck" + " Junor";
		
		URL url = Snippet017Tests.class.getResource(TableViewerWithDerivedColumns.class.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new ViewModel(), new Runnable() {
			public void run() {
				Object element = XWT.findElementByName(root, "TableViewer");
				assertTrue(element instanceof TableViewer);
				TableViewer tableViewer = (TableViewer) element;
				Object dataContext = XWT.getDataContext(element);
				assertTrue(dataContext instanceof ViewModel);
				ViewModel viewModel = (ViewModel) dataContext; 
				ArrayList<Person> people = viewModel.getPeople();
				
				IObservableValue observableValue = XWT.observableValue(tableViewer, null, "singleSelection");
				
				Person person = findPerson(people, name);
				observableValue.setValue(person);
				
				{
					Object text = XWT.findElementByName(root, "NameText");
					assertTrue(text instanceof Text);
					Text nameText = (Text) text;
					
					// modification via UI
					nameText.setText(newName);
				}
			}
		}, 
		new Runnable() {
			public void run() {
				Object viewer = XWT.findElementByName(root, "TableViewer");
				assertTrue(viewer instanceof TableViewer);
				TableViewer tableViewer = (TableViewer) viewer;
				Object dataContext = XWT.getDataContext(viewer);
				assertTrue(dataContext instanceof ViewModel);
				ViewModel viewModel = (ViewModel) dataContext; 
				ArrayList<Person> people = viewModel.getPeople();
				
				IObservableValue observableValue = XWT.observableValue(tableViewer, null, "singleSelection");
				Person person = findPerson(people, newName);
				assertTrue(person != null);
				assertEquals(observableValue.getValue(), person);
				
				{
					Object element = XWT.findElementByName(root, "NameText");
					assertTrue(element instanceof Text);
					Text nameText = (Text) element;
					assertEquals(nameText.getText(), newName);
				}
			}
		});
	}
	
	public void testTableViewerWithDerivedColumns_TextAPI() throws Exception {
		final String name = "Scrooge McDuck";
		final String newName = "Scrooge McDuck" + " Junor";
		
		URL url = Snippet017Tests.class.getResource(TableViewerWithDerivedColumns.class.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new ViewModel(), new Runnable() {
			public void run() {
				Object element = XWT.findElementByName(root, "TableViewer");
				assertTrue(element instanceof TableViewer);
				TableViewer tableViewer = (TableViewer) element;
				Object dataContext = XWT.getDataContext(element);
				assertTrue(dataContext instanceof ViewModel);
				ViewModel viewModel = (ViewModel) dataContext; 
				ArrayList<Person> people = viewModel.getPeople();
				
				IObservableValue observableValue = XWT.observableValue(tableViewer, null, "singleSelection");
				
				Person person = findPerson(people, name);
				observableValue.setValue(person);
				
				{
					Object text = XWT.findElementByName(root, "NameText");
					assertTrue(text instanceof Text);
					Text nameText = (Text) text;
					
					// modification via API
					IObservableValue textValue = XWT.observableValue(nameText, null, "text");
					textValue.setValue(newName);
				}
			}
		}, 
		new Runnable() {
			public void run() {
				Object viewer = XWT.findElementByName(root, "TableViewer");
				assertTrue(viewer instanceof TableViewer);
				TableViewer tableViewer = (TableViewer) viewer;
				Object dataContext = XWT.getDataContext(viewer);
				assertTrue(dataContext instanceof ViewModel);
				ViewModel viewModel = (ViewModel) dataContext; 
				ArrayList<Person> people = viewModel.getPeople();
				
				IObservableValue observableValue = XWT.observableValue(tableViewer, null, "singleSelection");
				Person person = findPerson(people, newName);
				assertTrue(person != null);
				assertEquals(observableValue.getValue(), person);
				
				{
					Object element = XWT.findElementByName(root, "NameText");
					assertTrue(element instanceof Text);
					Text nameText = (Text) element;
					assertEquals(nameText.getText(), newName);
				}
			}
		});
	}
	
	public void testTableViewerWithDerivedColumns_MotherCombo() throws Exception {
		final String name = "Scrooge McDuck";
		final String motherName = "Downy O'Drake";
		final String newMotherName = "Della Duck";
		URL url = Snippet017Tests.class.getResource(TableViewerWithDerivedColumns.class.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new ViewModel(), new Runnable() {
			public void run() {
				Object viewer = XWT.findElementByName(root, "TableViewer");
				assertTrue(viewer instanceof TableViewer);
				TableViewer tableViewer = (TableViewer) viewer;
				Object dataContext = XWT.getDataContext(viewer);
				assertTrue(dataContext instanceof ViewModel);
				ViewModel viewModel = (ViewModel) dataContext; 
				ArrayList<Person> people = viewModel.getPeople();
				
				IObservableValue observableValue = XWT.observableValue(tableViewer, null, "singleSelection");
				
				Person person = findPerson(people, name);
				observableValue.setValue(person);
				
				{
					Object element = XWT.findElementByName(root, "MotherCombo");
					assertTrue(element instanceof ComboViewer);
					ComboViewer comboViewer = (ComboViewer) element;

					IObservableValue singleSelection = XWT.observableValue(comboViewer, null, "singleSelection");
					Object selected = singleSelection.getValue();
					assertTrue(selected instanceof Person);
					Person mother = (Person) selected;
					assertEquals(mother.getName(), motherName);

					Person newMother = findPerson(people, newMotherName);
					singleSelection.setValue(newMother);
				}
			}
		}, 
		new Runnable() {
			public void run() {
				Object viewer = XWT.findElementByName(root, "TableViewer");
				assertTrue(viewer instanceof TableViewer);
				TableViewer tableViewer = (TableViewer) viewer;
				Object dataContext = XWT.getDataContext(viewer);
				assertTrue(dataContext instanceof ViewModel);
				ViewModel viewModel = (ViewModel) dataContext; 
				ArrayList<Person> people = viewModel.getPeople();
				
				IObservableValue observableValue = XWT.observableValue(tableViewer, null, "singleSelection");
				Person person = findPerson(people, name);
				assertEquals(observableValue.getValue(), person);
				
				Person newMother = findPerson(people, newMotherName);

				assertEquals(person.getMother(), newMother);
				
				{
					Object element = XWT.findElementByName(root, "MotherCombo");
					assertTrue(element instanceof ComboViewer);
					ComboViewer comboViewer = (ComboViewer) element;

					IObservableValue singleSelection = XWT.observableValue(comboViewer, null, "singleSelection");
					Object selected = singleSelection.getValue();
					assertTrue(selected instanceof Person);
					Person mother = (Person) selected;
					assertEquals(mother, newMother);
				}
			}
		});
	}
	
	// TODO
	public void tesTableViewerWithDerivedColumns_MotherCombo_API() throws Exception {
		final String name = "Scrooge McDuck";
		final String motherName = "Downy O'Drake";
		final String newMotherName = "Della Duck";
		URL url = Snippet017Tests.class.getResource(TableViewerWithDerivedColumns.class.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
		runTest(url, new ViewModel(), new Runnable() {
			public void run() {
				Object viewer = XWT.findElementByName(root, "TableViewer");
				assertTrue(viewer instanceof TableViewer);
				TableViewer tableViewer = (TableViewer) viewer;
				Object dataContext = XWT.getDataContext(viewer);
				assertTrue(dataContext instanceof ViewModel);
				ViewModel viewModel = (ViewModel) dataContext; 
				ArrayList<Person> people = viewModel.getPeople();
				
				IObservableValue observableValue = XWT.observableValue(tableViewer, null, "singleSelection");
				
				Person person = findPerson(people, name);
				observableValue.setValue(person);
				
				{
					Object element = XWT.findElementByName(root, "MotherCombo");
					assertTrue(element instanceof ComboViewer);
					ComboViewer comboViewer = (ComboViewer) element;

					IObservableValue singleSelection = XWT.observableValue(comboViewer, null, "singleSelection");
					Object selected = singleSelection.getValue();
					assertTrue(selected instanceof Person);
					Person mother = (Person) selected;
					assertEquals(mother.getName(), motherName);

					IObservableValue motherValue = XWT.observableValue(comboViewer, person, "mother");

					Person newMother = findPerson(people, newMotherName);
					motherValue.setValue(newMother);
				}
			}
		}, 
		new Runnable() {
			public void run() {
				Object viewer = XWT.findElementByName(root, "TableViewer");
				assertTrue(viewer instanceof TableViewer);
				TableViewer tableViewer = (TableViewer) viewer;
				Object dataContext = XWT.getDataContext(viewer);
				assertTrue(dataContext instanceof ViewModel);
				ViewModel viewModel = (ViewModel) dataContext; 
				ArrayList<Person> people = viewModel.getPeople();
				
				IObservableValue observableValue = XWT.observableValue(tableViewer, null, "singleSelection");
				Person person = findPerson(people, name);
				assertEquals(observableValue.getValue(), person);
				
				Person newMother = findPerson(people, newMotherName);

				assertEquals(person.getMother(), newMother);
				
				{
					Object element = XWT.findElementByName(root, "MotherCombo");
					assertTrue(element instanceof ComboViewer);
					ComboViewer comboViewer = (ComboViewer) element;

					IObservableValue singleSelection = XWT.observableValue(comboViewer, null, "singleSelection");
					Object selected = singleSelection.getValue();
					assertTrue(selected instanceof Person);
					Person mother = (Person) selected;
					assertEquals(mother, newMother);
				}
			}
		});
	}
}
