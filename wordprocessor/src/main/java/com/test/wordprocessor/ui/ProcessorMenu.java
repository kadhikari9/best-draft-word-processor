package com.test.wordprocessor.ui;

import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.test.wordprocessor.constants.MenuConstants;

public class ProcessorMenu extends HasDocumentComponent {

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

		Action fileNewMenuAction = actionManager
				.getMenuAction(MenuConstants.NEW);
		Action openMenuAction = actionManager.getMenuAction(MenuConstants.OPEN);
		Action saveMenuAction = actionManager.getMenuAction(MenuConstants.SAVE);
		Action exitAction = actionManager.getMenuAction(MenuConstants.EXIT);
		Action cutMenuAction = actionManager.getMenuAction(MenuConstants.CUT);
		Action copyMenuAction = actionManager.getMenuAction(MenuConstants.COPY);
		Action pasteMenuAction = actionManager
				.getMenuAction(MenuConstants.PASTE);
		Action undoMenuAction = actionManager.getMenuAction(MenuConstants.UNDO);
		Action redoMenuAction = actionManager.getMenuAction(MenuConstants.REDO);

		fileNew = new JMenuItem(fileNewMenuAction);
		fileOpen = new JMenuItem(openMenuAction);
		fileSave = new JMenuItem(saveMenuAction);
		fileExit = new JMenuItem(exitAction);

		fileMenu.add(fileNew);
		fileMenu.add(fileOpen);
		fileMenu.add(fileSave);

		fileMenu.addSeparator();

		fileMenu.add(fileExit);

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

		undo.setEnabled(false);
		redo.setEnabled(false);

	}

}
