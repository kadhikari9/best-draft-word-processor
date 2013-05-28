package com.test.wordprocessor.ui;

import com.test.wordprocessor.ui.manager.ActionManager;
import com.test.wordprocessor.ui.manager.FontManager;

public abstract class HasDocumentComponent {

	protected DocumentPanel documentPanel;
	protected final ActionManager actionManager;
	protected final FontManager fontManager;

	public HasDocumentComponent() {
		actionManager = ActionManager.getInstance();
		fontManager = FontManager.getInstance();
	}

	public void setDocumentPanel(DocumentPanel panel) {
		this.documentPanel = panel;
		actionManager.setDocumentPanel(panel);
		fontManager.setDocumentPanel(documentPanel);
	}

}
