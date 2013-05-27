package com.test.wordprocessor.factory;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import com.test.wordprocessor.constants.IconPaths;
import com.test.wordprocessor.constants.MenuConstants;
import com.test.wordprocessor.ui.action.MenuAction;

public class ActionFactory {

	public static ActionFactory instance;

	private MenuAction newMenuAction;
	private MenuAction openMenuAction;
	private MenuAction saveMenuAction;
	private MenuAction exitMenuAction;

	private MenuAction cutMenuAction;
	private MenuAction copyMenuAction;
	private MenuAction pasteMenuAction;
	private MenuAction undoMenuAction;
	private MenuAction redoMenuAction;

	private ActionFactory() {
		init();
	}

	public static ActionFactory getInstance() {
		if (instance == null) {
			instance = new ActionFactory();
		}
		return instance;
	}

	private void init() {
		newMenuAction = new MenuAction(MenuConstants.NEW, new ImageIcon(
				IconPaths.NEW), KeyEvent.VK_N);
		openMenuAction = new MenuAction(MenuConstants.OPEN, new ImageIcon(
				IconPaths.OPEN), KeyEvent.VK_O);
		saveMenuAction = new MenuAction(MenuConstants.SAVE, new ImageIcon(
				IconPaths.SAVE), KeyEvent.VK_S);
		exitMenuAction = new MenuAction(MenuConstants.EXIT, null, KeyEvent.VK_X);

		cutMenuAction = new MenuAction(MenuConstants.CUT, new ImageIcon(
				IconPaths.CUT), KeyEvent.VK_T);
		copyMenuAction = new MenuAction(MenuConstants.COPY, new ImageIcon(
				IconPaths.COPY), KeyEvent.VK_C);
		pasteMenuAction = new MenuAction(MenuConstants.PASTE, new ImageIcon(
				IconPaths.PASTE), KeyEvent.VK_P);
		undoMenuAction = new MenuAction(MenuConstants.UNDO, new ImageIcon(
				IconPaths.UNDO), KeyEvent.VK_U);
		redoMenuAction = new MenuAction(MenuConstants.REDO, new ImageIcon(
				IconPaths.REDO), KeyEvent.VK_R);

		newMenuAction.setAcceleratorKey(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.CTRL_MASK));
		openMenuAction.setAcceleratorKey(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));
		saveMenuAction.setAcceleratorKey(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		cutMenuAction.setAcceleratorKey(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));
		copyMenuAction.setAcceleratorKey(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				ActionEvent.CTRL_MASK));
		pasteMenuAction.setAcceleratorKey(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				ActionEvent.CTRL_MASK));
		undoMenuAction.setAcceleratorKey(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
				ActionEvent.CTRL_MASK));
		redoMenuAction.setAcceleratorKey(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
				ActionEvent.CTRL_MASK));
	}

	public MenuAction getNewMenuAction() {
		return newMenuAction;
	}

	public MenuAction getOpenMenuAction() {
		return openMenuAction;
	}

	public MenuAction getSaveMenuAction() {
		return saveMenuAction;
	}

	public MenuAction getExitMenuAction() {
		return exitMenuAction;
	}

	public MenuAction getCutMenuAction() {
		return cutMenuAction;
	}

	public MenuAction getCopyMenuAction() {
		return copyMenuAction;
	}

	public MenuAction getPasteMenuAction() {
		return pasteMenuAction;
	}

	public MenuAction getUndoMenuAction() {
		return undoMenuAction;
	}

	public MenuAction getRedoMenuAction() {
		return redoMenuAction;
	}

}
