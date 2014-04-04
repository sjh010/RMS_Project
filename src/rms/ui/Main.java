package rms.ui;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import rms.service.RmsService;
import rms.service.RmsServiceImpl;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("부동산 관리 시스템");				
		frame.setLocation(30, 30);							
		frame.setPreferredSize(new Dimension(1250, 900));
		GridLayout layout = new GridLayout(2, 1);
		frame.setLayout(layout); 									
		Container contentPane = frame.getContentPane();
		
		RmsService service = new RmsServiceImpl();
		
		RegistPanel registPanel = new RegistPanel(service);
		JPanel northPanel = registPanel.getPanel();
		
		SearchPanel searchPanel = new SearchPanel(service);
		JPanel southPanel = searchPanel.getPanel(); 
		
		contentPane.add(northPanel);
		contentPane.add(southPanel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.pack();											
		frame.setVisible(true);	
	}
}
