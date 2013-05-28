package com.test.wordprocessor.ui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
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
	private DocumentPanel documentPanel;

	public MainFrame(String title) {
		super(title);
		initComponents();
	}

	private void initComponents() {
		documentPanel = new DocumentPanel();
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
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null,
						"Do you want to save this file?", "Mesage",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (confirm == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "To do");
				}

				else if (confirm == JOptionPane.CANCEL_OPTION) {
					return;
				}

				else {
					System.exit(0);
				}
			}

		});
	}

	private void initTab() {
		JTabbedPane documentTab = new JTabbedPane();
		this.add(documentTab, BorderLayout.CENTER);
		documentPanel.setTabbedPane(documentTab);
		addNewTab();
	}

	public void addNewTab() {
		JEditorPane textComponent = new JEditorPane();
		textComponent.setEditorKit(new StyledEditorKit());
		JScrollPane scrollPane = new JScrollPane(textComponent);

		JTabbedPane documentTab = documentPanel.getTabbedPane();

		documentTab.add(scrollPane);
		documentPanel.addNewEditor(textComponent);
		documentPanel.setActiveTabTitle("");

		processorMenu.setDocumentPanel(documentPanel);
		processorToolbar.setDocumentPanel(documentPanel);

	}
}
