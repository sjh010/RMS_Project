package rms.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import rms.service.RmsService;
import rms.service.RmsServiceImpl;
import rms.vo.Customer;

public class RegistButtonActionListener implements ActionListener{
	JComboBox comboBox1;
	JComboBox comboBox2;
	JTextField text1;
	JTextField text2;
	JTextField text3;
	JTextField text4;
	JTextField text5;
	JTextField text6;
	JTextField text7;
	JTextField text8;
	
	private TotalSaleInfo obj;
	private Date date;
	
	private String building_type;
	private int building_size;
	private String building_addr;
	
	private Building building;
	private String contactType;
	private int price;
	private int deposit;
	
	private String name;
	private String phoneNum;
	
	private Customer tenant;
	private Customer host;
	
	
	
	
	RegistButtonActionListener(JComboBox comboBox1, JComboBox comboBox2, JTextField text1, JTextField text2, JTextField text3, JTextField text4, JTextField text5, JTextField text6, JTextField text7, JTextField text8){
		this.comboBox1 = comboBox1;
		this.comboBox2 = comboBox2;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		this.text4 = text4;
		this.text5 = text5;
		this.text6 = text6;
		this.text7 = text7;
		this.text8 = text8;	
	}
	
	public void actionPerformed(ActionEvent e) {
		this.date = new Date(System.currentTimeMillis());
		
		building_type = (String)comboBox1.getSelectedItem();
	
		///////////////
		switch (building_type){
		
		case "아파트":
			building_type = "BT1";
			break;
		case "빌라":
			building_type = "BT2";
			break;
		case "주택":
			building_type = "BT3";
			break;
		}
		////////////////
		
		building_size = Integer.parseInt(text1.getText());
		building_addr = text2.getText(); 
		
		building = new Building(building_type, building_size, building_addr);
		contactType = (String)comboBox2.getSelectedItem();
		
		///////////////////
		switch(contactType){
		
		case "월세":
			contactType = "CT1";
			break;
		case "전세":
			contactType = "CT2";
			break;
		case "매매":
			contactType = "CT3";
		}
		
		///////////////
		price = Integer.parseInt(text3.getText());
		deposit = Integer.parseInt(text4.getText());
		
		name = text5.getText();
		phoneNum = text6.getText();
		tenant = new Customer(name, phoneNum);
		
		name = text7.getText();
		phoneNum = text8.getText();
		host = new Customer(name, phoneNum);
		
		obj = new TotalSaleInfo(date, building, contactType, price, deposit, tenant, host);
		System.out.println(building_type + " " + building_size);
		
		RmsService service = new RmsServiceImpl();
		service.inputSaleInfo(obj);
	}
}
