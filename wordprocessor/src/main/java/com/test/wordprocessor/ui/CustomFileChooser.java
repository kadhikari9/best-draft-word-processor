package com.test.wordprocessor.ui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CustomFileChooser extends JFileChooser {

	/**
	 * 
	 */
	private static final long serialVersionUID = -993174295462046763L;

	@Override
	public void approveSelection() {
		File f = getSelectedFile();
		if (f.exists() && getDialogType() == SAVE_DIALOG) {
			int confirm = JOptionPane.showConfirmDialog(this,
					"Do you want to overwrite this file?", "Mesage",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			switch (confirm) {
			case JOptionPane.YES_OPTION:
				super.approveSelection();
				return;
			case JOptionPane.NO_OPTION:
				return;
			case JOptionPane.CLOSED_OPTION:
				return;
			}
		}
		super.approveSelection();
	}
}
