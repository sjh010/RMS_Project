package rms.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class RmsUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("�ε��� ���� �ý���");				//Ÿ��Ʋ���� ����
		frame.setLocation(30, 30);							//���� ���� ������ġ
		frame.setPreferredSize(new Dimension(1250, 900));		//�г��� ũ��
		Container contentPane = frame.getContentPane();			//�������� contentPane�� ����
		
		frame.setLayout(null); 									//���̾ƿ��� ���� �ʰڴ�.
		
		JButton button1 = new JButton("�ǹ�����");
		button1.setSize(100, 20);
		button1.setLocation(20, 20);
		JButton button2 = new JButton("�������");
		button2.setSize(100, 20);
		button2.setLocation(120, 20);
		JButton button3 = new JButton("��");
		button3.setSize(100, 20);
		button3.setLocation(220, 20);
		JButton button4 = new JButton("ȣ��");
		button4.setSize(100, 20);
		button4.setLocation(320, 20);
		JButton button5 = new JButton("��");
		button5.setSize(100, 20);
		button5.setLocation(420, 20);
		JButton button6 = new JButton("������");
		button6.setSize(100, 20);
		button6.setLocation(520, 20);
		JButton button7 = new JButton("������");
		button7.setSize(100, 20);
		button7.setLocation(620, 20);
		JButton button8 = new JButton("����������");
		button8.setSize(100, 20);
		button8.setLocation(720, 20);
		JButton button9 = new JButton("����");
		button9.setSize(100, 20);
		button9.setLocation(820, 20);
		JButton button10 = new JButton("��������");
		button10.setSize(100, 20);
		button10.setLocation(920, 20);
		JButton button11 = new JButton("�Է�");
		button11.setSize(80, 40);
		button11.setLocation(1040, 20);
		
		//�޺��ڽ� �����
		Vector list1 = new Vector();
		list1.add("����Ʈ");
		list1.add("����");
		list1.add("����");
		JComboBox comboBox1 = new JComboBox(list1);
		comboBox1.setSize(100, 20);
		comboBox1.setLocation(20, 40);
		contentPane.add(comboBox1);
		
		Vector list2 = new Vector();
		list2.add("����");
		list2.add("����");
		list2.add("�Ÿ�");
		JComboBox comboBox2 = new JComboBox(list2);
		comboBox2.setSize(100, 20);
		comboBox2.setLocation(120, 40);
		contentPane.add(comboBox2);
		
		JTextField text1 = new JTextField();			//�ؽ�Ʈ �ʵ带 ����� ���
		text1.setSize(100, 20);
		text1.setLocation(220, 40);
		contentPane.add(text1);
		JTextField text2 = new JTextField();
		text2.setSize(100, 20);
		text2.setLocation(320, 40);
		contentPane.add(text2);
		JTextField text3 = new JTextField();
		text3.setSize(100, 20);
		text3.setLocation(420, 40);
		contentPane.add(text3);
		JTextField text4 = new JTextField();
		text4.setSize(100, 20);
		text4.setLocation(520, 40);
		contentPane.add(text4);
		JTextField text5 = new JTextField();
		text5.setSize(100, 20);
		text5.setLocation(620, 40);
		contentPane.add(text5);
		JTextField text6 = new JTextField();
		text6.setSize(100, 20);
		text6.setLocation(720, 40);
		contentPane.add(text6);
		JTextField text7 = new JTextField();
		text7.setSize(100, 20);
		text7.setLocation(820, 40);
		contentPane.add(text7);
		JTextField text8 = new JTextField();
		text8.setSize(100, 20);
		text8.setLocation(920, 40);
		contentPane.add(text8);
		
		
		contentPane.add(button1);
		contentPane.add(button2);
		contentPane.add(button3);
		contentPane.add(button4);
		contentPane.add(button5);
		contentPane.add(button6);
		contentPane.add(button7);
		contentPane.add(button8);
		contentPane.add(button9);
		contentPane.add(button10);
		contentPane.add(button11);
		
		
		String buildingType = (String)comboBox1.getSelectedItem();
		String constractType = (String)comboBox2.getSelectedItem();
		
		ActionListener listener = 
				new RegistButtonActionListener(comboBox1, comboBox2, text1, text2, text3, text4, text5, text6, text7, text8);
		button11.addActionListener(listener);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//X������ ���α׷� ����ǰ�
		frame.pack();											//�����쿡 ���÷����ϴ� ����1
		frame.setVisible(true);									//�����쿡 ���÷����ϴ� ����2
	}
}
