package com.test.wordprocessor.ui;

import javax.swing.JEditorPane;

import com.test.wordprocessor.ui.manager.ActionManager;
import com.test.wordprocessor.ui.manager.FontManager;

public abstract class HasTextComponent {

	protected JEditorPane textComponent;
	protected final ActionManager actionManager;
	protected final FontManager fontManager;

	public HasTextComponent() {
		actionManager = ActionManager.getInstance();
		fontManager = FontManager.getInstance();
	}

	public void setTextComponent(JEditorPane area) {
		this.textComponent = area;
		actionManager.setTextComponent(textComponent);
		fontManager.setTextComponent(textComponent);
	}

}
