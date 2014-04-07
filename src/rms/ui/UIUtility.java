package rms.ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UIUtility {
	private static int buttonX;
	private static int comboBoxX;
	private static int textFieldX;
	private static int textFieldY;
	
	public static JButton[] setButton(String[] buttonName, JPanel panel, int x){
		JButton[] button = new JButton[buttonName.length];
		buttonX = x;
		for(int i=0; i<button.length; i++){
			button[i] = new JButton(buttonName[i]);
			button[i].setSize(100, 20);
			button[i].setLocation(buttonX, 20);
			panel.add(button[i]);
			buttonX += 100;
		}
		return button;
	}
	
	public static JComboBox[] setComboBox(String[][] comboBoxList, JPanel panel, int x){
		JComboBox[] comboBox = new JComboBox[comboBoxList.length];
		comboBoxX = x;
		for(int i=0; i<comboBox.length; i++){
			comboBox[i] = new JComboBox(comboBoxList[i]);
			comboBox[i].setSize(100, 20);
			comboBox[i].setLocation(comboBoxX, 40);
			panel.add(comboBox[i]);
			comboBoxX += 100;
		}
		return comboBox;
	}
	public static void setTextField(JTextField[] textField, JPanel panel, int x, int y){
		textFieldX = x;
		textFieldY = y;
		for(int i=0; i<textField.length; i++){
			textField[i] = new JTextField();
			textField[i].setSize(100, 20);
			textField[i].setLocation(textFieldX, textFieldY);
			panel.add(textField[i]);
			textFieldX += 100;
		}
	}
}