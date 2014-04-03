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
		JFrame frame = new JFrame("부동산 관리 시스템");				//타이틀바의 제목
		frame.setLocation(30, 30);							//왼쪽 위의 시작위치
		frame.setPreferredSize(new Dimension(1250, 900));		//패널의 크기
		Container contentPane = frame.getContentPane();			//프레임의 contentPane을 얻음
		
		frame.setLayout(null); 									//레이아웃을 쓰지 않겠다.
		
		JButton button1 = new JButton("건물종류");
		button1.setSize(100, 20);
		button1.setLocation(20, 20);
		JButton button2 = new JButton("계약종류");
		button2.setSize(100, 20);
		button2.setLocation(120, 20);
		JButton button3 = new JButton("평");
		button3.setSize(100, 20);
		button3.setLocation(220, 20);
		JButton button4 = new JButton("호수");
		button4.setSize(100, 20);
		button4.setLocation(320, 20);
		JButton button5 = new JButton("세");
		button5.setSize(100, 20);
		button5.setLocation(420, 20);
		JButton button6 = new JButton("보증금");
		button6.setSize(100, 20);
		button6.setLocation(520, 20);
		JButton button7 = new JButton("세입자");
		button7.setSize(100, 20);
		button7.setLocation(620, 20);
		JButton button8 = new JButton("세입자전번");
		button8.setSize(100, 20);
		button8.setLocation(720, 20);
		JButton button9 = new JButton("주인");
		button9.setSize(100, 20);
		button9.setLocation(820, 20);
		JButton button10 = new JButton("주인전번");
		button10.setSize(100, 20);
		button10.setLocation(920, 20);
		JButton button11 = new JButton("입력");
		button11.setSize(80, 40);
		button11.setLocation(1040, 20);
		
		//콤보박스 만들기
		Vector list1 = new Vector();
		list1.add("아파트");
		list1.add("주택");
		list1.add("빌라");
		JComboBox comboBox1 = new JComboBox(list1);
		comboBox1.setSize(100, 20);
		comboBox1.setLocation(20, 40);
		contentPane.add(comboBox1);
		
		Vector list2 = new Vector();
		list2.add("월세");
		list2.add("전세");
		list2.add("매매");
		JComboBox comboBox2 = new JComboBox(list2);
		comboBox2.setSize(100, 20);
		comboBox2.setLocation(120, 40);
		contentPane.add(comboBox2);
		
		JTextField text1 = new JTextField();			//텍스트 필드를 만드는 방법
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
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//X누르면 프로그램 종료되게
		frame.pack();											//윈도우에 디스플레이하는 과정1
		frame.setVisible(true);									//윈도우에 디스플레이하는 과정2
	}
}
