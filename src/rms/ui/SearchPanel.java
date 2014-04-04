package rms.ui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rms.service.RmsService;

public class SearchPanel {

	private JPanel panel;
	private JButton[] button;
	private JComboBox[] comboBox;
	private JTextField[] textField;
	JButton searchButton;
	RmsService service;
	
	public SearchPanel(RmsService service){
		this.service = service;
		panel = new JPanel();
		panel.setLayout(null);
		
		makeButton();
		makeComboBox();
		makeTextField();
		
		ActionListener listener = 
				new SearchButtonActionListener(comboBox, textField, service);
		searchButton.addActionListener(listener);
	}
	
	//버튼 만드는 Logic
	private void makeButton(){
		
		String[] buttonName = {"건물종류", "계약종류", "평(최소)",
	               			   "평(최대)", "가격(최소)", "가격(최대)"};
		
		button = UIUtility.setButton(buttonName, panel, 20);
		
		searchButton = new JButton("검색");
		searchButton.setSize(100, 40);
		searchButton.setLocation(630, 20);
		panel.add(searchButton);
	}
	
	//콤보박스 만드는 Logic
	private void makeComboBox(){
		
		String[][] comboBoxList = {{" ", "아파트", "주택", "빌라"},
								   {" ", "월세", "전세", "매매"}};
		comboBox = UIUtility.setComboBox(comboBoxList, panel, 20);
	}
	
	//텍스트필드 만드는 Logic
	private void makeTextField(){
		
		JTextField[] textField = new JTextField[4];
		UIUtility.setTextField(textField, panel, 220);
	}
	
	public JPanel getPanel(){
		return panel;
	}
}
