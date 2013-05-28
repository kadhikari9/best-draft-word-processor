package com.test.wordprocessor.ui.action;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import com.test.wordprocessor.ui.manager.UndoRedoManager;

public class RedoEventMenuAction extends MenuAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9006158700752865610L;

	private UndoRedoManager undoRedoManager;

	public RedoEventMenuAction(String text, ImageIcon icon, Integer mnemonic) {
		super(text, icon, mnemonic);
	}

	public void actionPerformed(ActionEvent e) {
		undoRedoManager.redo();
	}

	public void setUndoRedoManager(UndoRedoManager undoRedoManager) {
		this.undoRedoManager = undoRedoManager;
	}

}
