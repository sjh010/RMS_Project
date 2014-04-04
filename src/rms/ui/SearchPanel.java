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
	
	//��ư ����� Logic
	private void makeButton(){
		
		String[] buttonName = {"�ǹ�����", "�������", "��(�ּ�)",
	               			   "��(�ִ�)", "����(�ּ�)", "����(�ִ�)"};
		
		button = UIUtility.setButton(buttonName, panel, 20);
		
		searchButton = new JButton("�˻�");
		searchButton.setSize(100, 40);
		searchButton.setLocation(630, 20);
		panel.add(searchButton);
	}
	
	//�޺��ڽ� ����� Logic
	private void makeComboBox(){
		
		String[][] comboBoxList = {{" ", "����Ʈ", "����", "����"},
								   {" ", "����", "����", "�Ÿ�"}};
		comboBox = UIUtility.setComboBox(comboBoxList, panel, 20);
	}
	
	//�ؽ�Ʈ�ʵ� ����� Logic
	private void makeTextField(){
		
		textField = new JTextField[4];
		UIUtility.setTextField(textField, panel, 220);
	}
	
	public JPanel getPanel(){
		return panel;
	}
}
