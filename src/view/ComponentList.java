package view;

import model.component.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ComponentList extends JFrame{
	private JList<String> componentList;
	private DefaultListModel<String> dlm;
	private JScrollPane listPane;
	
	private Component switchTime ;
	private Component windowTime ;
	private Component tvDiningTime ;
	private Component tvLivingTime ;

	public ComponentList(Component switchTime, Component windowTime, Component tvDiningTime, Component tvLivingTime){
		setSize(500, 155);
		setTitle("Controller");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(700, 560);
		setLayout(new BorderLayout());
		Color blue = new Color(50, 170, 190);
		Color black = new Color(0, 0, 0);
		this.switchTime = switchTime;
		this.windowTime = windowTime;
		
		dlm = new DefaultListModel<>();
		dlm.addElement(" TV (Living Room)");
		dlm.addElement(" Speaker (Living Room)");
		dlm.addElement(" Window (Living Room)");
		dlm.addElement(" TV (Dining Room)");
		componentList = new JList<>(dlm);
		
		componentList.setBounds(0, 0, 400, 400);
		componentList.setFont(new Font("Consolas", 1, 20));
		componentList.setBackground(black);
		componentList.setForeground(blue);
		
		componentList.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount() == 2){
					String option = componentList.getSelectedValue();
					if(option.equals(" TV (Living Room)")){
						tvLivingTime.showTimeSetter();				
					}else if(option.equals(" Speaker (Living Room)")){
						switchTime.showTimeSetter();			
						
					}else if(option.equals(" Window (Living Room)")){
						windowTime.showTimeSetter();		
					}else{
						tvDiningTime.showTimeSetter();
					}					
				}
			}
		});
		add(componentList);
	}
}
