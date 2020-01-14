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
package org.eclipse.xwt.tests.style.css;

import java.io.IOException;
import java.io.StringReader;

import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xwt.css.CSSStyle;
import org.eclipse.xwt.css.CSSXWT;

public class MainEventHandler {

	/**
	 * @param event
	 */
	public void updateCSSEngine(Event event) {
		Text text = (Text) event.widget;
		CSSEngine engine = CSSXWT.getCSSEngine(text);
		if (engine == null) {
			CSSStyle cssStyle = new CSSStyle();
			cssStyle.setContent(text.getText());
			cssStyle.applyStyle(text);
		} else {
			engine.reset();
			try {
				// Parse style sheet
				engine.parseStyleSheet(new StringReader(text.getText()));

				// Re-apply styles for the whole widgets
				engine.applyStyles(text.getShell(), true, true);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
