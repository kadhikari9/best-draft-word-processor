package com.test.wordprocessor.ui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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

	private final ImageIcon boldDisable;
	private final ImageIcon boldEnable;
	private final ImageIcon italicDisable;
	private final ImageIcon italicEnable;

	private boolean boldFlag;
	private boolean italicFlag;

	private String[] fontNames;
	private Vector<String> filteredFonts;

	public ProcessorToolbar(JToolBar toolBar) {
		this.toolBar = toolBar;
		toolBar.setFloatable(false);
		boldDisable = new ImageIcon(IconPaths.FONT_BOLD_DISABLE);
		boldEnable = new ImageIcon(IconPaths.FONT_BOLD_ENABLE);
		italicDisable = new ImageIcon(IconPaths.FONT_ITALIC_DISABLE);
		italicEnable = new ImageIcon(IconPaths.FONT_ITALIC_ENABLE);
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

		fontSelector = new JComboBox();
		setFonts();

		fontSelector.setModel(new ComboBoxModel(filteredFonts));
		fontSelector.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXXXXXXXXXXX");
		fontSizeSelector = new JComboBox(getFontSizes());
		fontSelector.setEditable(true);
		fontSizeSelector.setEditable(true);

		fontBoldToggle = new JToggleButton(boldDisable);
		fontItalicsToggle = new JToggleButton(italicDisable);

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

	private class ComboBoxModel extends DefaultComboBoxModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 885419683586730974L;

		public ComboBoxModel(Vector<?> vector) {
			super(vector);
		}

		@Override
		public int getSize() {
			return filteredFonts.size();
		}

		@Override
		public Object getElementAt(int index) {
			if (index >= 0 && index < filteredFonts.size())
				return filteredFonts.elementAt(index);
			else
				return null;
		}
	}

	private void initFontAction() {
		final JTextField textField = (JTextField) fontSelector.getEditor()
				.getEditorComponent();

		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					filterFonts(textField.getText());
				}
			}
		});

		fontSelector.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					fontManager.setFont(fontSelector.getSelectedItem()
							.toString());
				}
			}
		});

		fontSizeSelector.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					setFontSize();
				}
			}
		});

	}

	private void setFontSize() {
		String fontSize = fontSizeSelector.getSelectedItem().toString();
		Integer size = getFontSize(fontSize);
		if (size == null) {
			JOptionPane.showMessageDialog(null, "Invalid font size.", "Error",
					JOptionPane.ERROR_MESSAGE);
			fontSizeSelector.setSelectedIndex(0);
		} else if (size < 8 || size > 72) {
			JOptionPane.showMessageDialog(null,
					"Font size must be in between 8 and 72.", "Error",
					JOptionPane.ERROR_MESSAGE);
			fontSizeSelector.setSelectedIndex(0);
		} else {
			fontManager.setFontSize(size);
		}
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
					fontBoldToggle.setIcon(boldEnable);

				} else {
					boldFlag = false;
					fontBoldToggle.setIcon(boldDisable);
				}
				fontManager.setBold(boldFlag);
			}
		});

		fontItalicsToggle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!italicFlag) {
					italicFlag = true;
					fontItalicsToggle.setIcon(italicEnable);
				} else {
					italicFlag = false;
					fontItalicsToggle.setIcon(italicDisable);
				}
				fontManager.setItalics(italicFlag);
			}
		});
	}

	private void filterFonts(String filter) {
		if (!fontSelector.isPopupVisible()) {
			fontSelector.showPopup();
		}

		filteredFonts = new Vector<String>();
		for (String s : fontNames) {
			if (filter.isEmpty()) {
				filteredFonts.add(s);
			} else if (s.toLowerCase().startsWith(filter.toLowerCase())) {
				filteredFonts.add(s);
			}
		}
		DefaultComboBoxModel model = (DefaultComboBoxModel) fontSelector
				.getModel();
		model.removeAllElements();
		for (String s : filteredFonts) {
			model.addElement(s);
		}
	}

	private void setFonts() {
		GraphicsEnvironment e = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		Font[] allFonts = e.getAllFonts();
		fontNames = new String[allFonts.length];
		int i = 0;
		for (Font f : allFonts) {
			fontNames[i] = f.getName();
			i++;
		}
		filteredFonts = new Vector<String>(Arrays.asList(fontNames));
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
