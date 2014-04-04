package rms.ui;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import rms.service.RmsService;


public class RegistPanel {
	
	private JPanel panel;
	private JButton[] button;
	private JComboBox[] comboBox;
	private JTextField[] textField;
	JButton registButton;
	RmsService service;
	
	public RegistPanel(RmsService service){
		this.service = service;
		panel = new JPanel();
		panel.setLayout(null);
		
		makeButton();
		makeComboBox();
		makeTextField();
		
		ActionListener listener = 
				new RegistButtonActionListener(comboBox, textField, service);
		registButton.addActionListener(listener);
	}
	
	//버튼 만드는 Logic
	private void makeButton(){
		
		String[] buttonName = {"건물종류", "계약종류", "평",
	               "호수", "세(가격)", "보증금",
	               "세입자이름", "세입자전번", "주인이름",
	               "주인전번", "건물특징"};
		button = UIUtility.setButton(buttonName, panel, 20);
		
		registButton = new JButton("입력");
		registButton.setSize(100, 40);
		registButton.setLocation(1130, 20);
		panel.add(registButton);
	}
	
	//콤보박스 만드는 Logic
	private void makeComboBox(){
		
		String[][] comboBoxList = {{"아파트", "주택", "빌라"},
								   {"월세", "전세", "매매"}};
		comboBox = UIUtility.setComboBox(comboBoxList, panel, 20);
	}
	
	//텍스트필드 만드는 Logic
	private void makeTextField(){
		
		JTextField[] textField = new JTextField[9];
		UIUtility.setTextField(textField, panel, 220);
	}
	
	public JPanel getPanel(){
		return panel;
	}
}