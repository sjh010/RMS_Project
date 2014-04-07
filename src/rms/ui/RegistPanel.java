package rms.ui;

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
	
	//��ư ����� Logic	
	private void makeButton(){
		String[] buttonName = {"�ǹ�����", "�������", "��",
							   "ȣ��", "��(����)", "������",
							   "�������̸�", "����������", "�����̸�",
							   "��������", "�ǹ�Ư¡"};
		button = UIUtility.setButton(buttonName, panel, 20);
		registButton = new JButton("�Է�");
		registButton.setSize(100, 40);
		registButton.setLocation(1130, 20);
		panel.add(registButton);
	}
	
	//�޺��ڽ� ����� Logic
	private void makeComboBox(){
		String[][] comboBoxList = {{"����Ʈ", "����", "����"},
								   {"����", "����", "�Ÿ�"}};
		comboBox = UIUtility.setComboBox(comboBoxList, panel, 20);
	}
	
	//�ؽ�Ʈ�ʵ� ����� Logic
	private void makeTextField(){
		textField = new JTextField[9];
		UIUtility.setTextField(textField, panel, 220, 40);
	}
	
	public JPanel getPanel(){
		return panel;
	}
} 