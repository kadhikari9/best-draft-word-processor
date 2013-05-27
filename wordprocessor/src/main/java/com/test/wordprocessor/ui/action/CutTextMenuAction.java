package com.test.wordprocessor.ui.action;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class CutTextMenuAction extends MenuAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2369826387800092586L;

	public CutTextMenuAction(String text, ImageIcon icon, Integer mnemonic) {
		super(text, icon, mnemonic);
	}

	public void actionPerformed(ActionEvent e) {
		this.textComponent.cut();
	}

}
