package com.test.wordprocessor.ui.manager;

import javax.swing.JEditorPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;

public class FontManager {

	private JEditorPane textComponent;
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

	public void setTextComponent(JEditorPane textComponent) {
		this.textComponent = textComponent;
	}

	public void setBold(boolean bold) {
		StyleConstants.setBold(simpleAttributeSet, bold);
		setCharacterAttributes(textComponent, simpleAttributeSet, true);
	}

	public void setItalics(boolean italics) {
		StyleConstants.setItalic(simpleAttributeSet, italics);
		setCharacterAttributes(textComponent, simpleAttributeSet, true);
	}

	public void setFont(String font) {
		StyleConstants.setFontFamily(simpleAttributeSet, font);
		setCharacterAttributes(textComponent, simpleAttributeSet, true);
	}

	public void setFontSize(int size) {
		StyleConstants.setFontSize(simpleAttributeSet, size);
		setCharacterAttributes(textComponent, simpleAttributeSet, true);
	}

	private void setCharacterAttributes(JEditorPane editor, AttributeSet attr,
			boolean replace) {
		int start = editor.getSelectionStart();
		int end = editor.getSelectionEnd();
		if (start != end) {
			StyledDocument doc = (StyledDocument) editor.getDocument();
			doc.setCharacterAttributes(start, end - start, attr, replace);
		}
		StyledEditorKit k = (StyledEditorKit) editor.getEditorKit();
		MutableAttributeSet inputAttributes = k.getInputAttributes();
		if (replace) {
			inputAttributes.removeAttributes(inputAttributes);
		}
		inputAttributes.addAttributes(attr);
	}
}
