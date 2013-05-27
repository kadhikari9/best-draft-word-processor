package com.test.wordprocessor.ui.action;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ExitMenuAction extends MenuAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8115459368083074137L;

	public ExitMenuAction(String text, ImageIcon icon, Integer mnemonic) {
		super(text, icon, mnemonic);
	}

	public void actionPerformed(ActionEvent e) {
		if (!textComponent.getText().isEmpty()) {
			int confirm = JOptionPane.showConfirmDialog(null,
					"Do you want to save this file?", "Mesage",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (confirm == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "To do");
			}

			else if (confirm == JOptionPane.CANCEL_OPTION) {
				return;
			}

			else {
				System.exit(0);
			}
		} else {
			System.exit(0);
		}
	}

}
