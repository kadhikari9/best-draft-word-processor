package com.test.wordprocessor.ui.action;

import javax.swing.ImageIcon;

import com.test.wordprocessor.ui.manager.FileManager;

public abstract class FileMenuAction extends MenuAction {

	private static final long serialVersionUID = 4329282826285318627L;

	protected final FileManager fileManager;

	public FileMenuAction(String text, ImageIcon icon, Integer mnemonic) {
		super(text, icon, mnemonic);
		fileManager = FileManager.getInstance();
	}

}
