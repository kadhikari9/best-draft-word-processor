package com.test.wordprocessor.ui;

import java.awt.BorderLayout;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.text.StyledEditorKit;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9006806923792355892L;
	private ProcessorMenu processorMenu;
	private JMenuBar menuBar;
	private JToolBar toolBar;
	private ProcessorToolbar processorToolbar;
	private JTabbedPane documentTab;

	public MainFrame(String title) {
		super(title);
		initComponents();
	}

	private void initComponents() {
		menuBar = new JMenuBar();
		toolBar = new JToolBar();
		processorMenu = new ProcessorMenu(menuBar);
		processorMenu.initMenu();

		processorToolbar = new ProcessorToolbar(toolBar);
		processorToolbar.initToolBar();

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(toolBar, BorderLayout.PAGE_START);

		this.setJMenuBar(menuBar);
		this.add(panel, BorderLayout.NORTH);

		initTab();
	}

	private void initTab() {
		documentTab = new JTabbedPane();
		this.add(documentTab, BorderLayout.CENTER);
		addNewTab("Untitled", "");
	}

	public void addNewTab(String title, String text) {
		JEditorPane textField = new JEditorPane();
		textField.setText(text);
		textField.setEditorKit(new StyledEditorKit());
		JScrollPane scrollPane = new JScrollPane(textField);
		documentTab.add(scrollPane);
		documentTab.setTitleAt(0, title);

		processorMenu.setTextComponent(textField);
		processorToolbar.setTextComponent(textField);

	}
}
