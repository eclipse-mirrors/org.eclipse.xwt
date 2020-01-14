package org.eclipse.xwt.jface;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Listener;

public class RadioItem extends Item {
	private RadioGroup parent;
	private Button button;

	public RadioItem(RadioGroup parent, int style) {
		this(parent, style, -1);
	}

	public RadioItem(final RadioGroup parent, int style, int index) {
		super(parent, checkStyle(style), checkIndex(parent, index));
		this.parent = parent;
		this.button = parent.createButton(getStyle(), index);

		Listener listener = new Listener() {
			public void handleEvent(Event event) {
				if (event.type == SWT.Selection)
					handleSelection(event);
				else if (event.type == SWT.Dispose)
					handleDispose(event);
			}
		};
		button.addListener(SWT.Selection, listener);
		addListener(SWT.Dispose, listener);

		parent.addItem(this, index);
	}

	private static int checkStyle(int style) {
		int result = 0;
		if ((style & SWT.LEFT) != 0)
			result |= SWT.LEFT;
		else if ((style & SWT.CENTER) != 0)
			result |= SWT.CENTER;
		else if ((style & SWT.RIGHT) != 0)
			result |= SWT.RIGHT;
		return result;
	}

	private static int checkIndex(RadioGroup parent, int position) {
		if (position == -1)
			return parent.getItemCount();
		if (position < 0 || position > parent.getItemCount())
			SWT.error(SWT.ERROR_INVALID_ARGUMENT);
		return position;
	}

	private void handleSelection(Event event) {
		parent.itemSelected(this);
	}

	private void handleDispose(Event event) {
		if (parent != null) {
			parent.removeItem(RadioItem.this);
		}
		if (button != null) {
			button.dispose();
			if (parent != null && !parent.isDisposed())
				parent.layout(false);
		}
		RadioItem.this.parent = null;
		button = null;
	}

	public RadioGroup getParent() {
		return parent;
	}

	public String getText() {
		checkWidget();
		return button.getText();
	}

	public void setText(String string) {
		checkWidget();
		button.setText(string);
		parent.layout(new Control[] { button });
	}

	public Image getImage() {
		checkWidget();
		return button.getImage();
	}

	public void setImage(Image image) {
		checkWidget();
		button.setImage(image);
		parent.layout(new Control[] { button });
	}

	public Color getForeground() {
		checkWidget();
		return button.getForeground();
	}

	public void setForeground(Color foreground) {
		checkWidget();
		if (foreground == null)
			SWT.error(SWT.ERROR_NULL_ARGUMENT);
		button.setForeground(foreground);
	}

	public Color getBackground() {
		checkWidget();
		return button.getBackground();
	}

	public void setBackground(Color background) {
		checkWidget();
		if (background == null)
			SWT.error(SWT.ERROR_NULL_ARGUMENT);
		button.setBackground(background);
	}

	public Font getFont() {
		checkWidget();
		return button.getFont();
	}

	public void setFont(Font font) {
		checkWidget();
		if (font == null)
			SWT.error(SWT.ERROR_NULL_ARGUMENT);
		button.setFont(font);
	}

	public Button getButton() {
		return button;
	}

	public boolean isSelected() {
		return button.getSelection();
	}

	void select() {
		button.setSelection(true);
		parent.itemSelected(this);
	}

	void deselect() {
		button.setSelection(false);
		parent.itemSelected(this);
	}

	void clear() {
		setText("");
		setImage(null);
		setFont(parent.getFont());
		setForeground(parent.getForeground());
		setBackground(parent.getBackground());
	}
}