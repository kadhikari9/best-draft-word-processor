package com.test.wordprocessor.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JEditorPane;
import javax.swing.JTabbedPane;

public class DocumentPanel {

	private JTabbedPane tabbedPane;
	private final List<JEditorPane> editorPaneList = new ArrayList<JEditorPane>();

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	public List<JEditorPane> getEditorPane() {
		return editorPaneList;
	}

	public void addNewEditor(JEditorPane editorPane) {
		editorPaneList.add(editorPane);
	}

	public void removeEditor(int index) {
		tabbedPane.remove(index);
		editorPaneList.remove(index);
	}

	public void setActiveTabTitle(String title) {
		int index = tabbedPane.getSelectedIndex();
		if (title.isEmpty()) {
			title = "Untitled";
		}
		tabbedPane.setTitleAt(index, title);
	}

	public JEditorPane getSelectedEditor() {
		int index = tabbedPane.getSelectedIndex();
		return editorPaneList.get(index);
	}

}
