package rms.ui;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;


public class RmsUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("부동산 관리 시스템");				
		frame.setLocation(30, 30);							
		frame.setPreferredSize(new Dimension(1250, 900));		
		frame.setLayout(null); 									
		Container contentPane = frame.getContentPane();
		
		//버튼 만드는 Logic
		String[] buttonName = {"건물종류", "계약종류", "평",
	               "호수", "세(가격)", "보증금",
	               "세입자이름", "세입자전번", "주인이름",
	               "주인전번", "건물특징"};
		JButton[] button = UIUtility.setButton(buttonName, contentPane);
		
		JButton registButton = new JButton("입력");
		registButton.setSize(100, 40);
		registButton.setLocation(1130, 20);
		contentPane.add(registButton);
		
		//콤보박스 만드는 Logic
		String[][] comboBoxList = {{"아파트", "주택", "빌라"},
								   {"월세", "전세", "매매"}};
		JComboBox[] comboBox = UIUtility.setComboBox(comboBoxList, contentPane);

		//텍스트필드 만드는 Logic
		JTextField[] textField = new JTextField[9];
		UIUtility.setTextField(textField, contentPane);
		
		//리스너를 입력버튼에 달아주는 Logic
		ActionListener listener = 
				new RegistButtonActionListener(comboBox, textField);
		button[10].addActionListener(listener);
		
		//화면에 디스플레이 하는 Logic
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.pack();											
		frame.setVisible(true);	
	}
}