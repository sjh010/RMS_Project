package rms.ui;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class UIUtility {
	private static int buttonX = 20;
	private static int comboBoxX = 20;
	private static int textFieldX = 220;
	
	public static JButton[] setButton(Container contentPane){
		
		String[] buttonName = {"건물종류", "계약종류", "평",
				               "호수", "세(가격)", "보증금",
				               "세입자이름", "세입자전번", "주인이름",
				               "주인전번", "건물특징", "입력"};
		JButton[] button = new JButton[buttonName.length];
		
		for(int i=0; i<button.length; i++){
			button[i] = new JButton(buttonName[i]);
			button[i].setSize(100, 20);
			button[i].setLocation(buttonX, 20);
			contentPane.add(button[i]);
			if( buttonX > 1000 ) buttonX += 110; else buttonX += 100;
		}
		
		return button;
	}
	
	public static JComboBox[] setComboBox(String[][] comboBoxList, Container contentPane){
		
		JComboBox[] comboBox = new JComboBox[comboBoxList.length];
		
		for(int i=0; i<comboBox.length; i++){
			comboBox[i] = new JComboBox(comboBoxList[i]);
			comboBox[i].setSize(100, 20);
			comboBox[i].setLocation(comboBoxX, 40);
			contentPane.add(comboBox[i]);
			comboBoxX += 100;
		}
		
		return comboBox;
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