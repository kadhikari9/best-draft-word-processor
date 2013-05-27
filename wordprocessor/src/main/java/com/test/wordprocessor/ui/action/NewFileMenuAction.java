package com.test.wordprocessor.ui.action;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class NewFileMenuAction extends MenuAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6341777056268045596L;

	public NewFileMenuAction(String text, ImageIcon icon, Integer mnemonic) {
		super(text, icon, mnemonic);
	}

	public void actionPerformed(ActionEvent e) {
		int confirm = JOptionPane.showConfirmDialog(null,
				"Do you want to save this file?", "Mesage",
				JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "To do");
		}
	}

}
