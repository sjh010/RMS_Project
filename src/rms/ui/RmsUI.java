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
		JFrame frame = new JFrame("부동산 관리 시스템");				
		frame.setLocation(30, 30);							
		frame.setPreferredSize(new Dimension(1250, 900));		
		frame.setLayout(null); 									
		Container contentPane = frame.getContentPane();
		
		
		//버튼 만드는 Logic
		JButton[] button = new JButton[12];
		button[0] = new JButton("건물종류");
		button[1] = new JButton("계약종류");
		button[2] = new JButton("평");
		button[3] = new JButton("호수");
		button[4] = new JButton("세(가격)");
		button[5] = new JButton("보증금");
		button[6] = new JButton("세입자이름");
		button[7] = new JButton("세입자전번");
		button[8] = new JButton("주인이름");
		button[9] = new JButton("주인전번");
		button[10] = new JButton("건물특징");
		button[11] = new JButton("입력");
		
		UIUtility.setButton(button, contentPane);
		
		
		//콤보박스 만드는 Logic
		String[] buildingTypeList = {"아파트", "주택", "빌라"};
		String[] contractTypeList = {"월세", "전세", "매매"};
		JComboBox[] comboBox = new JComboBox[2];
		comboBox[0] = new JComboBox(buildingTypeList);
		comboBox[1] = new JComboBox(contractTypeList);
		
		UIUtility.setComboBox(comboBox, contentPane);

		
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

