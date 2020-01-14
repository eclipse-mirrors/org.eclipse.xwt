package org.eclipse.xwt.jface;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.AbstractListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class RadioGroupViewer extends AbstractListViewer {
	private RadioGroup radioGroup;

	public RadioGroupViewer(Composite parent) {
		this(parent, SWT.NONE);
	}

	public RadioGroupViewer(Composite parent, int style) {
		this(new RadioGroup(parent, style));
	}

	public RadioGroupViewer(RadioGroup group) {
		Assert.isNotNull(group);
		this.radioGroup = group;
		hookControl(group);
	}

	public Control getControl() {
		return radioGroup;
	}

	public RadioGroup getRadioGroup() {
		return radioGroup;
	}

	public void reveal(Object element) {
	}

	protected void listShowSelection() {
	}

	protected void listSetSelection(int[] ixs) {
		for (int idx = 0; idx < ixs.length; idx++) {
			radioGroup.select(ixs[idx]);
		}
	}

	protected int[] listGetSelectionIndices() {
		return new int[] { radioGroup.getSelectionIndex() };
	}

	protected void listAdd(String string, int index) {
		radioGroup.setLayoutDeferred(true);
		try {
			RadioItem item = new RadioItem(radioGroup, SWT.NONE, index);
			item.setText(string);
		} finally {
			radioGroup.setLayoutDeferred(false);
		}
	}
	protected void listDeselectAll() {
		radioGroup.deselectAll();
	}

	protected int listGetItemCount() {
		return radioGroup.getItemCount();
	}
	protected void listRemove(int index) {
		radioGroup.remove(index);
	}

	protected void listRemoveAll() {
		radioGroup.removeAll();
	}
	protected void listSetItem(int index, String string) {
		RadioItem item = radioGroup.getItems()[index];
		item.setText(string);
	}
	protected void listSetItems(String[] labels) {
		radioGroup.removeAll();

		for (int i = 0; i < labels.length; i++) {
			RadioItem item = new RadioItem(radioGroup, SWT.NONE);
			item.setText(labels[i]);
		}
	}

	public void add(Object element) {
		super.add(element);
	}

	public void add(Object[] elements) {
		super.add(elements);
	}
	public void insert(Object element, int position) {
		super.insert(element, position);
	}
	public Object getElementAt(int index) {
		return super.getElementAt(index);
	}
	protected int indexForElement(Object element) {
		return super.indexForElement(element);
	}

	protected int listGetTopIndex() {
		return super.listGetTopIndex();
	}

	protected void listSetTopIndex(int index) {
		super.listSetTopIndex(index);
	}

	public void remove(Object element) {
		super.remove(element);
	}

	public void remove(Object[] elements) {
		super.remove(elements);
	}
}