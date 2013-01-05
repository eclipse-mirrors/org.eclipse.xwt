/*******************************************************************************
 * Copyright (c) 2013 Eclipse XWT Team
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Erdal Karaca - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.controls;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.xwt.snippets.XWTSnippet;
import org.eclipse.xwt.snippets.controls.Button_Visible;
import org.eclipse.xwt.tests.AbstractSnippetTest;
import org.junit.Test;

public class ButtonVisibleSnippetTest extends AbstractSnippetTest {
	@Override
	protected XWTSnippet doGetSnippet() {
		return new Button_Visible();
	}

	@Test
	public void testAll() {
		Composite rootComposite = getRoot(Composite.class);
		SWTBot bot = new SWTBot(rootComposite);
		SWTBotButton first = bot.button(0);
		SWTBotButton second = bot.button(0);
		
		assertTrue(first.isVisible());
		assertTrue(!second.isVisible());
	}
}
