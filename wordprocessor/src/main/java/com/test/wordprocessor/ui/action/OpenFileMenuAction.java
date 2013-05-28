package com.test.wordprocessor.ui.action;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.test.wordprocessor.ui.manager.FileManager;

public class OpenFileMenuAction extends FileMenuAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7742186302325831449L;

	private final FileManager fileManager;

	public OpenFileMenuAction(String text, ImageIcon icon, Integer mnemonic) {
		super(text, icon, mnemonic);
		fileManager = FileManager.getInstance();
	}

	public void actionPerformed(ActionEvent e) {
		int confirm = JOptionPane.showConfirmDialog(null,
				"Do you want to save this file?", "Mesage",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (confirm == JOptionPane.YES_OPTION) {
			fileManager.saveFile(getActiveEditor());
		} else if (confirm == JOptionPane.CANCEL_OPTION) {
			return;
		}

		else {
			fileManager.openFile(getActiveEditor());
			documentPanel.setActiveTabTitle(fileManager.getSelectedFile()
					.getName());
		}
	}

}
