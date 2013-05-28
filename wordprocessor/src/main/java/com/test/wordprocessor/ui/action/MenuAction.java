package com.test.wordprocessor.ui.action;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.KeyStroke;

import com.test.wordprocessor.ui.DocumentPanel;

public abstract class MenuAction extends AbstractAction {

	/**
	 * 
	 */

	protected DocumentPanel documentPanel;

	private static final long serialVersionUID = -6037521297853552947L;

	public MenuAction(String text, ImageIcon icon, Integer mnemonic) {
		super(text, icon);
		putValue(MNEMONIC_KEY, mnemonic);
	}

	public void setAcceleratorKey(KeyStroke keyStroke) {
		putValue(ACCELERATOR_KEY, keyStroke);
	}

	public DocumentPanel getDocumentPanel() {
		return documentPanel;
	}

	public void setDocumentPanel(DocumentPanel documentPanel) {
		this.documentPanel = documentPanel;
	}

	public JEditorPane getActiveEditor() {
		return documentPanel.getSelectedEditor();
	}

	public void setActiveTabTitle(String title) {
		documentPanel.setActiveTabTitle(title);
	}

}
