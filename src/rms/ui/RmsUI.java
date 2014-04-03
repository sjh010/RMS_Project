package rms.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class RmsUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("�ε��� ���� �ý���");				
		frame.setLocation(30, 30);							
		frame.setPreferredSize(new Dimension(1250, 900));		
		frame.setLayout(null); 									
		Container contentPane = frame.getContentPane();
		
		
		//��ư ����� Logic
		JButton[] button = new JButton[12];
		button[0] = new JButton("�ǹ�����");
		button[1] = new JButton("�������");
		button[2] = new JButton("��");
		button[3] = new JButton("ȣ��");
		button[4] = new JButton("��(����)");
		button[5] = new JButton("������");
		button[6] = new JButton("�������̸�");
		button[7] = new JButton("����������");
		button[8] = new JButton("�����̸�");
		button[9] = new JButton("��������");
		button[10] = new JButton("�ǹ�Ư¡");
		button[11] = new JButton("�Է�");
		
		UIUtility.setButton(button, contentPane);
		
		
		//�޺��ڽ� ����� Logic
		String[] buildingTypeList = {"����Ʈ", "����", "����"};
		String[] contractTypeList = {"����", "����", "�Ÿ�"};
		JComboBox[] comboBox = new JComboBox[2];
		comboBox[0] = new JComboBox(buildingTypeList);
		comboBox[1] = new JComboBox(contractTypeList);
		
		UIUtility.setComboBox(comboBox, contentPane);

		
		//�ؽ�Ʈ�ʵ� ����� Logic
		JTextField[] textField = new JTextField[9];
		
		UIUtility.setTextField(textField, contentPane);
		
		
		//�����ʸ� �Է¹�ư�� �޾��ִ� Logic
		ActionListener listener = 
				new RegistButtonActionListener(comboBox, textField);
		button[11].addActionListener(listener);
		
		
		//ȭ�鿡 ���÷��� �ϴ� Logic
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.pack();											
		frame.setVisible(true);	
	}
}

