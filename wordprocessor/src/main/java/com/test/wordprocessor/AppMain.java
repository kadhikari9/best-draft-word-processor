package com.test.wordprocessor;

import javax.swing.JFrame;

import com.test.wordprocessor.ui.MainFrame;

public class AppMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MainFrame frame = new MainFrame("BestDraft Word Processor");
		frame.setBounds(320, 120, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
