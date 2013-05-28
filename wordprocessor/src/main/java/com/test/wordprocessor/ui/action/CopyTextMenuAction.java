package com.test.wordprocessor.ui.action;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class CopyTextMenuAction extends MenuAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3159133689888432529L;

	public CopyTextMenuAction(String text, ImageIcon icon, Integer mnemonic) {
		super(text, icon, mnemonic);
	}

	public void actionPerformed(ActionEvent e) {
		this.getActiveEditor().copy();
	}
}
