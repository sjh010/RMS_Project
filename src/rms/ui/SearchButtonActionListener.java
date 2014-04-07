package rms.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import rms.service.RmsService;
import rms.vo.SaleInfo;
import rms.vo.SearchItem;

public class SearchButtonActionListener implements ActionListener{
	JComboBox[] comboBox;
	JTextField[] textField;
	RmsService service;
	SearchButtonActionListener(JComboBox[] comboBox, JTextField[] textField, RmsService service){
		this.comboBox = comboBox;
		this.textField = textField;
		this.service = service;
	}
	public void actionPerformed(ActionEvent e) {
		String buildingType = null;
		String contractType = null;
		int minSize=0;
		int maxSize=0;
		int minPrice=0;
		int maxPrice=0;
		if(((String)comboBox[0].getSelectedItem()).equals(" ") != false)
			buildingType = (String)comboBox[0].getSelectedItem();
		if(((String)comboBox[1].getSelectedItem()).equals(" ") != false)
			contractType = (String)comboBox[1].getSelectedItem();
		minSize = Integer.parseInt(textField[0].getText());
		maxSize = Integer.parseInt(textField[1].getText());
		minPrice = Integer.parseInt(textField[2].getText());
		maxPrice = Integer.parseInt(textField[3].getText());
		SearchItem searchItem = new SearchItem()
								.setBuildingType(buildingType)
								.setContractType(contractType)
								.setMinSize(minSize)
								.setMaxSize(maxSize)
								.setMinPrice(minPrice)
								.setMaxPrice(maxPrice);
		
		List<SaleInfo> list = service.inputSearchInfo(searchItem);
				
		if(list != null)
			new SearchResultFrame(list);
	}
}