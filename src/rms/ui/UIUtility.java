package rms.ui;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
//
public class UIUtility {
	private static int buttonX = 20;
	private static int comboBoxX = 20;
	private static int textFieldX = 220;
	
	public static void setButton(JButton[] button, Container contentPane){
		for(int i=0; i<button.length; i++){
			button[i].setSize(100, 20);
			button[i].setLocation(buttonX, 20);
			contentPane.add(button[i]);
			if( buttonX > 1000 ) buttonX += 110; else buttonX += 100;
		}
	}
	
	public static void setComboBox(JComboBox[] comboBox, Container contentPane){
		for(int i=0; i<comboBox.length; i++){
			comboBox[i].setSize(100, 20);
			comboBox[i].setLocation(comboBoxX, 40);
			contentPane.add(comboBox[i]);
			comboBoxX += 100;
		}
	}
	
	public static void setTextField(JTextField[] textField, Container contentPane){
		for(int i=0; i<textField.length; i++){
			textField[i] = new JTextField();
			textField[i].setSize(100, 20);
			textField[i].setLocation(textFieldX, 40);
			contentPane.add(textField[i]);
			textFieldX += 100;
		}
	}
}