package com.test.wordprocessor.ui.action;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import com.test.wordprocessor.ui.manager.UndoRedoManager;

public class UndoEventMenuAction extends MenuAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7111048141750571133L;

	private UndoRedoManager undoRedoManager;

	public UndoEventMenuAction(String text, ImageIcon icon, Integer mnemonic) {
		super(text, icon, mnemonic);
	}

	public void actionPerformed(ActionEvent e) {
		undoRedoManager.undo();
	}

	public void setUndoRedoManager(UndoRedoManager undoRedoManager) {
		this.undoRedoManager = undoRedoManager;
	}

}
