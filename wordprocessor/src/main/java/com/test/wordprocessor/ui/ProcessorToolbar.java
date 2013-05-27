package com.test.wordprocessor.ui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import com.test.wordprocessor.constants.IconPaths;
import com.test.wordprocessor.constants.MenuConstants;

public class ProcessorToolbar extends HasTextComponent {

	private final JToolBar toolBar;

	private JButton fileNewButton;
	private JButton fileOpenButton;
	private JButton fileSaveButton;
	private JComboBox fontSelector;
	private JComboBox fontSizeSelector;
	private JToggleButton fontBoldToggle;
	private JToggleButton fontItalicsToggle;

	private boolean boldFlag;
	private boolean italicFlag;

	public ProcessorToolbar(JToolBar toolBar) {
		this.toolBar = toolBar;
		toolBar.setFloatable(false);
	}

	public void initToolBar() {
		fileNewButton = new JButton(
				actionManager.getMenuAction(MenuConstants.NEW));
		fileOpenButton = new JButton(
				actionManager.getMenuAction(MenuConstants.OPEN));
		fileSaveButton = new JButton(
				actionManager.getMenuAction(MenuConstants.SAVE));

		fileNewButton.setText("");
		fileOpenButton.setText("");
		fileSaveButton.setText("");
		fileNewButton.setBorderPainted(false);
		fileOpenButton.setBorderPainted(false);
		fileSaveButton.setBorderPainted(false);

		fontSelector = new JComboBox(getFonts());
		fontSizeSelector = new JComboBox(getFontSizes());
		fontSelector.setEditable(true);
		fontSizeSelector.setEditable(true);

		fontBoldToggle = new JToggleButton(new ImageIcon(
				IconPaths.FONT_BOLD_DISABLE));
		fontItalicsToggle = new JToggleButton(new ImageIcon(
				IconPaths.FONT_ITALIC_DISABLE));

		fontBoldToggle.setBorderPainted(false);
		fontItalicsToggle.setBorderPainted(false);

		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		JPanel comboPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		comboPanel.add(fontSelector);
		comboPanel.add(fontSizeSelector);

		toolBar.add(fileNewButton);
		toolBar.add(fileOpenButton);
		toolBar.add(fileSaveButton);
		toolBar.add(comboPanel);
		toolBar.add(fontBoldToggle);
		toolBar.add(fontItalicsToggle);

		initBoldItalicAction();
		initFontAction();
	}

	private void initFontAction() {
		fontSelector.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				fontManager.setFont(fontSelector.getSelectedItem().toString());

			}
		});

		fontSizeSelector.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String fontSize = fontSizeSelector.getSelectedItem().toString();
				Integer size = getFontSize(fontSize);
				if (size == null) {
					JOptionPane.showMessageDialog(null, "Invalid font size.",
							"Error", JOptionPane.ERROR_MESSAGE);
				} else if (size < 8 || size > 72) {
					JOptionPane.showMessageDialog(null,
							"Font size must be in between 8 and 72.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					fontManager.setFontSize(size);
				}

			}
		});
		System.out.println(fontSizeSelector.getActionListeners().length);
	}

	public Integer getFontSize(String size) {
		Integer i;
		try {
			i = Integer.parseInt(size);
		} catch (NumberFormatException e) {
			return null;
		}
		return i;
	}

	private void initBoldItalicAction() {
		fontBoldToggle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!boldFlag) {
					boldFlag = true;
				} else {
					boldFlag = false;
				}
				fontManager.setBold(boldFlag);
			}
		});

		fontItalicsToggle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!italicFlag) {
					italicFlag = true;
				} else {
					italicFlag = false;
				}
				fontManager.setItalics(italicFlag);
			}
		});
	}

	private Object[] getFonts() {
		GraphicsEnvironment e = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		Font[] allFonts = e.getAllFonts();
		String[] fontNames = new String[allFonts.length];
		int i = 0;
		for (Font f : allFonts) {
			fontNames[i] = f.getName();
			i++;
		}
		return fontNames;
	}

	private Object[] getFontSizes() {
		java.util.List<Integer> sizeList = new ArrayList<Integer>();
		int size = 8;
		for (int i = 0; i < 5; i++) {
			sizeList.add(size);
			size++;
		}
		size++;
		for (int i = 0; i < 8; i++) {
			sizeList.add(size);
			size += 2;
		}
		sizeList.add(36);
		sizeList.add(48);
		sizeList.add(72);
		return sizeList.toArray();
	}
}
