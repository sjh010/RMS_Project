package rms.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import rms.service.RmsService;
import rms.service.RmsServiceImpl;
import rms.vo.Customer;
import rms.vo.SaleInfo;

public class RegistButtonActionListener implements ActionListener{
	JComboBox[] comboBox;
	JTextField[] textField;
	
	RegistButtonActionListener(JComboBox[] comboBox, JTextField[] textField){
		this.comboBox = comboBox;
		this.textField = textField;
	}
	
	public void actionPerformed(ActionEvent e) {
		String buildingType;
		String contractType;
		int size;
		String addr;
		int price;
		int deposit;
		Customer tenant;
		Customer host;
		String buildingFeature;
		
		buildingType = (String)comboBox[0].getSelectedItem();
		contractType = (String)comboBox[1].getSelectedItem();;
		size = Integer.parseInt(textField[0].getText());;
		addr = textField[1].getText();;
		price = Integer.parseInt(textField[2].getText());;
		deposit = Integer.parseInt(textField[3].getText());
		tenant = new Customer(textField[4].getText(), textField[5].getText());
		host = new Customer(textField[6].getText(), textField[7].getText());
		buildingFeature = textField[8].getText();

		SaleInfo saleInfo = new SaleInfo()
							.setBuildingType(buildingType)
							.setContractType(contractType)
							.setSize(size)
							.setAddr(addr)
							.setPrice(price)
							.setDeposit(deposit)
							.setTenant(tenant)
							.setHost(host)
							.setBuildingFeature(buildingFeature);
		
		RmsService service = new RmsServiceImpl();
		service.inputSaleInfo(saleInfo);//
	}
}
