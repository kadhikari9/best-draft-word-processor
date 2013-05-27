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
	private JTabbedPane documentTab;
	private JEditorPane textComponent;

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
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				if (!textComponent.getText().isEmpty()) {
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
				} else {
					System.exit(0);
				}
			}

		});
	}

	private void initTab() {
		documentTab = new JTabbedPane();
		this.add(documentTab, BorderLayout.CENTER);
		addNewTab("Untitled", "");
	}

	public void addNewTab(String title, String text) {
		textComponent = new JEditorPane();
		textComponent.setText(text);
		textComponent.setEditorKit(new StyledEditorKit());
		JScrollPane scrollPane = new JScrollPane(textComponent);
		documentTab.add(scrollPane);
		documentTab.setTitleAt(0, title);

		processorMenu.setTextComponent(textComponent);
		processorToolbar.setTextComponent(textComponent);

	}
}
