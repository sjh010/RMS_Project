package rms.ui;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;


public class RmsUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("�ε��� ���� �ý���");				
		frame.setLocation(30, 30);							
		frame.setPreferredSize(new Dimension(1250, 900));		
		frame.setLayout(null); 									
		Container contentPane = frame.getContentPane();
		
		//��ư ����� Logic
		String[] buttonName = {"�ǹ�����", "�������", "��",
	               "ȣ��", "��(����)", "������",
	               "�������̸�", "����������", "�����̸�",
	               "��������", "�ǹ�Ư¡"};
		JButton[] button = UIUtility.setButton(buttonName, contentPane);
		
		JButton registButton = new JButton("�Է�");
		registButton.setSize(100, 40);
		registButton.setLocation(1130, 20);
		contentPane.add(registButton);
		
		//�޺��ڽ� ����� Logic
		String[][] comboBoxList = {{"����Ʈ", "����", "����"},
								   {"����", "����", "�Ÿ�"}};
		JComboBox[] comboBox = UIUtility.setComboBox(comboBoxList, contentPane);

		//�ؽ�Ʈ�ʵ� ����� Logic
		JTextField[] textField = new JTextField[9];
		UIUtility.setTextField(textField, contentPane);
		
		//�����ʸ� �Է¹�ư�� �޾��ִ� Logic
		ActionListener listener = 
				new RegistButtonActionListener(comboBox, textField);
		button[10].addActionListener(listener);
		
		//ȭ�鿡 ���÷��� �ϴ� Logic
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.pack();											
		frame.setVisible(true);	
	}
}