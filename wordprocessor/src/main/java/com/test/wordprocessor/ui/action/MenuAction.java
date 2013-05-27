package com.test.wordprocessor.ui.action;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.KeyStroke;

public abstract class MenuAction extends AbstractAction {

	/**
	 * 
	 */

	protected JEditorPane textComponent;

	private static final long serialVersionUID = -6037521297853552947L;

	public MenuAction(String text, ImageIcon icon, Integer mnemonic) {
		super(text, icon);
		putValue(MNEMONIC_KEY, mnemonic);
	}

	public void setAcceleratorKey(KeyStroke keyStroke) {
		putValue(ACCELERATOR_KEY, keyStroke);
	}

	public JEditorPane getTextComponent() {
		return textComponent;
	}

	public void setTextComponent(JEditorPane textComponent) {
		this.textComponent = textComponent;
	}

}
