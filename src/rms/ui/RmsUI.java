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
		JButton[] button = UIUtility.setButton(contentPane);
		
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
		button[11].addActionListener(listener);
		
		//화면에 디스플레이 하는 Logic
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.pack();											
		frame.setVisible(true);	
	}
}

