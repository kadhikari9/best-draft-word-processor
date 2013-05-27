package com.test.wordprocessor.ui.action;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class PasteTextMenuAction extends MenuAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6444881503047369466L;

	public PasteTextMenuAction(String text, ImageIcon icon, Integer mnemonic) {
		super(text, icon, mnemonic);
	}

	public void actionPerformed(ActionEvent e) {
		this.textComponent.paste();
	}

}
