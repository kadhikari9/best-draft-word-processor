package com.test.wordprocessor.ui.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

public class FileManager {
	private static FileManager instance;
	private final JFileChooser fileChooser;

	private FileManager() {
		fileChooser = new JFileChooser();
	}

	public static FileManager getInstance() {
		if (instance == null) {
			instance = new FileManager();
		}
		return instance;
	}

	public File getSelectedFile() {
		return fileChooser.getSelectedFile();
	}

	public void newFile(JEditorPane textEditorPane) {
		fileChooser.setSelectedFile(null);
	}

	public void openFile(JEditorPane textComponent) {
		int returnVal = fileChooser.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			FileInputStream io = null;
			BufferedReader reader = null;
			try {
				io = new FileInputStream(file);
				reader = new BufferedReader(new InputStreamReader(io));
				StyledDocument styledDocument = (StyledDocument) textComponent
						.getDocument();
				textComponent.setText("");
				String line;
				while ((line = reader.readLine()) != null) {
					styledDocument.insertString(styledDocument.getLength(),
							line, new SimpleAttributeSet());
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (BadLocationException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					reader.close();
					io.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
