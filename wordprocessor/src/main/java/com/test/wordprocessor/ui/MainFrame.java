package com.test.wordprocessor.ui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9006806923792355892L;
	private ProcessorMenu processorMenu;
	private JMenuBar menuBar;

	public MainFrame(String title) {
		super(title);
		initComponents();
	}

	private void initComponents() {
		menuBar = new JMenuBar();
		processorMenu = new ProcessorMenu(menuBar);
		processorMenu.initMenu();
		this.setJMenuBar(menuBar);
	}

}
