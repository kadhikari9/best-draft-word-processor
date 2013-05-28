package com.test.wordprocessor.ui.action;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class SaveFileMenuAction extends FileMenuAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8102969991834676556L;

	public SaveFileMenuAction(String text, ImageIcon icon, Integer mnemonic) {
		super(text, icon, mnemonic);
	}

	public void actionPerformed(ActionEvent e) {
		fileManager.saveFile(getActiveEditor());
		if (fileManager.getSelectedFile() != null
				&& fileManager.getSelectedFile().exists()) {
			documentPanel.setActiveTabTitle(fileManager.getSelectedFile()
					.getName());
		}
	}

}
