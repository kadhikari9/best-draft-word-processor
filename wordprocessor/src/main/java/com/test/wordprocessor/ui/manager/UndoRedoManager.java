package com.test.wordprocessor.ui.manager;

import javax.swing.JMenuItem;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class UndoRedoManager implements UndoableEditListener {

	private final UndoManager undoManager;
	private JMenuItem undoMenu;
	private JMenuItem redoMenu;
	private static UndoRedoManager instance;

	private UndoRedoManager() {
		undoManager = new UndoManager();
		undoManager.setLimit(15);
	}

	public static UndoRedoManager getInstance() {
		if (instance == null) {
			instance = new UndoRedoManager();
		}
		return instance;
	}

	public void undoableEditHappened(UndoableEditEvent e) {
		undoManager.addEdit(e.getEdit());
		update();
	}

	public void undo() {
		undoManager.undo();
		update();
	}

	private void update() {
		if (!undoManager.canUndo()) {
			undoMenu.setEnabled(false);
		}
		if (undoManager.canRedo()) {
			redoMenu.setEnabled(true);
		}
		if (!undoManager.canRedo()) {
			redoMenu.setEnabled(false);
		}
		if (undoManager.canUndo()) {
			undoMenu.setEnabled(true);
		}
	}

	public void redo() {
		undoManager.redo();
		update();
	}

	public JMenuItem getUndoMenu() {
		return undoMenu;
	}

	public void setUndoMenu(JMenuItem undoMenu) {
		this.undoMenu = undoMenu;
	}

	public JMenuItem getRedoMenu() {
		return redoMenu;
	}

	public void setRedoMenu(JMenuItem redoMenu) {
		this.redoMenu = redoMenu;
	}

}
