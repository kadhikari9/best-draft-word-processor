package com.test.wordprocessor.ui;

import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.test.wordprocessor.constants.MenuConstants;
import com.test.wordprocessor.factory.ActionFactory;

public class ProcessorMenu {

	private final ActionFactory actionFactory;

	private final JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu editMenu;

	private JMenuItem fileNew;
	private JMenuItem fileOpen;
	private JMenuItem fileSave;
	private JMenuItem fileExit;

	private JMenuItem copy;
	private JMenuItem cut;
	private JMenuItem paste;
	private JMenuItem undo;
	private JMenuItem redo;

	public ProcessorMenu(JMenuBar menuBar) {
		this.menuBar = menuBar;
		actionFactory = ActionFactory.getInstance();
	}

	public void initMenu() {
		fileMenu = new JMenu(MenuConstants.FILE);
		editMenu = new JMenu(MenuConstants.EDIT);
		fileMenu.setMnemonic(KeyEvent.VK_F);
		editMenu.setMnemonic(KeyEvent.VK_E);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);

		addMenuItems();
	}

	private void addMenuItems() {

		Action fileNewMenuAction = actionFactory.getNewMenuAction();
		Action openMenuAction = actionFactory.getOpenMenuAction();
		Action saveMenuAction = actionFactory.getSaveMenuAction();
		Action exitAction = actionFactory.getExitMenuAction();

		fileNew = new JMenuItem(fileNewMenuAction);
		fileOpen = new JMenuItem(openMenuAction);
		fileSave = new JMenuItem(saveMenuAction);
		fileExit = new JMenuItem(exitAction);

		fileMenu.add(fileNew);
		fileMenu.add(fileOpen);
		fileMenu.add(fileSave);

		fileMenu.addSeparator();

		fileMenu.add(fileExit);

		Action cutMenuAction = actionFactory.getCutMenuAction();
		Action copyMenuAction = actionFactory.getCopyMenuAction();
		Action pasteMenuAction = actionFactory.getPasteMenuAction();
		Action undoMenuAction = actionFactory.getUndoMenuAction();
		Action redoMenuAction = actionFactory.getRedoMenuAction();

		copy = new JMenuItem(copyMenuAction);
		cut = new JMenuItem(cutMenuAction);
		paste = new JMenuItem(pasteMenuAction);
		undo = new JMenuItem(undoMenuAction);
		redo = new JMenuItem(redoMenuAction);

		editMenu.add(copy);
		editMenu.add(cut);
		editMenu.add(paste);
		editMenu.addSeparator();
		editMenu.add(undo);
		editMenu.add(redo);

	}

}
