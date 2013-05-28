package com.test.wordprocessor.ui.manager;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import com.test.wordprocessor.constants.IconPaths;
import com.test.wordprocessor.constants.MenuConstants;
import com.test.wordprocessor.ui.DocumentPanel;
import com.test.wordprocessor.ui.action.CopyTextMenuAction;
import com.test.wordprocessor.ui.action.CutTextMenuAction;
import com.test.wordprocessor.ui.action.ExitMenuAction;
import com.test.wordprocessor.ui.action.MenuAction;
import com.test.wordprocessor.ui.action.NewFileMenuAction;
import com.test.wordprocessor.ui.action.OpenFileMenuAction;
import com.test.wordprocessor.ui.action.PasteTextMenuAction;
import com.test.wordprocessor.ui.action.RedoEventMenuAction;
import com.test.wordprocessor.ui.action.SaveFileMenuAction;
import com.test.wordprocessor.ui.action.UndoEventMenuAction;

public class ActionManager {

	public static ActionManager instance;

	private MenuAction newMenuAction;
	private MenuAction openMenuAction;
	private MenuAction saveMenuAction;
	private MenuAction exitMenuAction;

	private MenuAction cutMenuAction;
	private MenuAction copyMenuAction;
	private MenuAction pasteMenuAction;
	private MenuAction undoMenuAction;
	private MenuAction redoMenuAction;

	private final Map<String, MenuAction> actionMap;

	private ActionManager() {
		actionMap = new HashMap<String, MenuAction>();
		init();
	}

	public static ActionManager getInstance() {
		if (instance == null) {
			instance = new ActionManager();
		}
		return instance;
	}

	private void init() {
		newMenuAction = new NewFileMenuAction(MenuConstants.NEW, new ImageIcon(
				IconPaths.NEW), KeyEvent.VK_N);
		openMenuAction = new OpenFileMenuAction(MenuConstants.OPEN,
				new ImageIcon(IconPaths.OPEN), KeyEvent.VK_O);
		saveMenuAction = new SaveFileMenuAction(MenuConstants.SAVE,
				new ImageIcon(IconPaths.SAVE), KeyEvent.VK_S);
		exitMenuAction = new ExitMenuAction(MenuConstants.EXIT, null,
				KeyEvent.VK_X);

		cutMenuAction = new CutTextMenuAction(MenuConstants.CUT, new ImageIcon(
				IconPaths.CUT), KeyEvent.VK_T);
		copyMenuAction = new CopyTextMenuAction(MenuConstants.COPY,
				new ImageIcon(IconPaths.COPY), KeyEvent.VK_C);
		pasteMenuAction = new PasteTextMenuAction(MenuConstants.PASTE,
				new ImageIcon(IconPaths.PASTE), KeyEvent.VK_P);
		undoMenuAction = new UndoEventMenuAction(MenuConstants.UNDO,
				new ImageIcon(IconPaths.UNDO), KeyEvent.VK_U);
		redoMenuAction = new RedoEventMenuAction(MenuConstants.REDO,
				new ImageIcon(IconPaths.REDO), KeyEvent.VK_R);

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

		addToMap();
	}

	private void addToMap() {
		actionMap.put(MenuConstants.NEW, newMenuAction);
		actionMap.put(MenuConstants.OPEN, openMenuAction);
		actionMap.put(MenuConstants.SAVE, saveMenuAction);
		actionMap.put(MenuConstants.EXIT, exitMenuAction);

		actionMap.put(MenuConstants.CUT, cutMenuAction);
		actionMap.put(MenuConstants.COPY, copyMenuAction);
		actionMap.put(MenuConstants.PASTE, pasteMenuAction);
		actionMap.put(MenuConstants.UNDO, undoMenuAction);
		actionMap.put(MenuConstants.REDO, redoMenuAction);
	}

	public MenuAction getMenuAction(String key) {
		return actionMap.get(key);
	}

	public void setDocumentPanel(DocumentPanel documentPanel) {
		Set<String> keys = actionMap.keySet();
		for (String key : keys) {
			actionMap.get(key).setDocumentPanel(documentPanel);
		}
	}

}
