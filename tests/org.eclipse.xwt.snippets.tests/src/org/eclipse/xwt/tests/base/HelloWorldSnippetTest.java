/*******************************************************************************
 * Copyright (c) 2013 Eclipse XWT Team
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Erdal Karaca - initial API and implementation
 *******************************************************************************/
package org.eclipse.xwt.tests.base;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.xwt.snippets.XWTSnippet;
import org.eclipse.xwt.snippets.base.HelloWorldSnippet;
import org.eclipse.xwt.tests.AbstractSnippetTest;
import org.junit.Test;

public class HelloWorldSnippetTest extends AbstractSnippetTest {
	@Override
	protected XWTSnippet doGetSnippet() {
		return new HelloWorldSnippet();
	}

	@Test
	public void testAll() {
		Composite rootComposite = getRoot(Composite.class);
		SWTBot bot = new SWTBot(rootComposite);
		SWTBotText text = bot.text(0);
		assertTrue(text.backgroundColor() != null
				&& text.backgroundColor().equals(
						rootComposite.getDisplay().getSystemColor(
								SWT.COLOR_BLUE)));
	}
}
