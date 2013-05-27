package com.test.wordprocessor.ui.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class MenuAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6037521297853552947L;

	public MenuAction(String text, ImageIcon icon, Integer mnemonic) {
		super(text, icon);
		putValue(MNEMONIC_KEY, mnemonic);
	}

	public void setAcceleratorKey(KeyStroke keyStroke) {
		putValue(ACCELERATOR_KEY, keyStroke);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
