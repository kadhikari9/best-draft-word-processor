package com.test.wordprocessor.ui.manager;

import javax.swing.JEditorPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;

import com.test.wordprocessor.ui.DocumentPanel;

public class FontManager {

	private DocumentPanel documentPanel;
	private final SimpleAttributeSet simpleAttributeSet;
	private static FontManager instance;

	private FontManager() {
		simpleAttributeSet = new SimpleAttributeSet();
	}

	public static FontManager getInstance() {
		if (instance == null) {
			instance = new FontManager();
		}
		return instance;
	}

	public void setDocumentPanel(DocumentPanel documentPanel) {
		this.documentPanel = documentPanel;
	}

	public void setBold(boolean bold) {
		JEditorPane textComponent = documentPanel.getSelectedEditor();
		StyleConstants.setBold(simpleAttributeSet, bold);
		setCharacterAttributes(textComponent, simpleAttributeSet);
	}

	public void setItalics(boolean italics) {
		JEditorPane textComponent = documentPanel.getSelectedEditor();
		StyleConstants.setItalic(simpleAttributeSet, italics);
		setCharacterAttributes(textComponent, simpleAttributeSet);
	}

	public void setFont(String font) {
		JEditorPane textComponent = documentPanel.getSelectedEditor();
		StyleConstants.setFontFamily(simpleAttributeSet, font);
		setCharacterAttributes(textComponent, simpleAttributeSet);
	}

	public void setFontSize(int size) {
		JEditorPane textComponent = documentPanel.getSelectedEditor();
		StyleConstants.setFontSize(simpleAttributeSet, size);
		setCharacterAttributes(textComponent, simpleAttributeSet);
	}

	private void setCharacterAttributes(JEditorPane editor, AttributeSet attr) {
		int start = editor.getSelectionStart();
		int end = editor.getSelectionEnd();
		if (start != end) {
			StyledDocument doc = (StyledDocument) editor.getDocument();
			doc.setCharacterAttributes(start, end - start, attr, true);
		}
		StyledEditorKit k = (StyledEditorKit) editor.getEditorKit();
		MutableAttributeSet inputAttributes = k.getInputAttributes();
		inputAttributes.removeAttributes(inputAttributes);
		inputAttributes.addAttributes(attr);
	}
}
