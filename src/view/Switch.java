package view;

import model.timeblock.CurrentTimeBlock;
import model.component.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Switch extends JFrame{
	private JButton controlBtn;
	private JButton settingsButton;
	private JLabel hourLabel;
	private JSpinner hourControl;
	private JLabel minuteLabel;
	private JSpinner minuteControl;
	private Component[] components;
	private CurrentTimeBlock currentTime;
	private boolean isValid;

	public Switch(Component component1, Component component2, Component component3, Component component4){
		setSize(500,210);
		setTitle("Switch");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 1));
		setLocation(700, 320);
		Color blue = new Color(50, 170, 190);
		Color black = new Color(0, 0, 0);
		getContentPane().setBackground(black);
		components = new Component[4];
		components[0] = component1;
		components[1] = component2;
		components[2] = component3;
		components[3] = component4;
		isValid = false;
		for(Component comp : components){
			comp.showDisplay();
		}  
		JPanel controlBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		controlBtnPanel.setBackground(black);
		controlBtn = new JButton("    ON    ");
		controlBtn.setFont(new Font("Consolas", 1, 25));
		controlBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){	
				int startHour = (Integer)hourControl.getValue();
				int startMinute = (Integer)minuteControl.getValue();	
				if(currentTime == null){
					currentTime = new CurrentTimeBlock();
				}	
				currentTime.setStartHour(startHour);
				currentTime.setStartMinute(startMinute);
				isValid = true;
				
				if(isValid){
					if(controlBtn.getText().equals("    ON    ")){
						for(Component comp : components){
							comp.alertON(currentTime);
						}
						controlBtn.setText("   OFF   ");
					}else{
						for(Component comp : components){
							comp.alertOFF();
						}
						controlBtn.setText("    ON    ");
					}
				}
			}
		});
		controlBtn.setBackground(blue);
		controlBtnPanel.add(controlBtn);
		add(controlBtnPanel);
		
		JPanel settingBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		settingBtnPanel.setBackground(black);
		settingsButton = new JButton(" Settings ");
		settingsButton.setFont(new Font("Consolas", 1, 25));
		settingsButton.setBackground(blue);
		settingBtnPanel.add(settingsButton);
		settingsButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Component speaker = null;
				Component window = null;
				Component tvDining = null;
				Component tvLiving = null;
				
				for(int i =0; i<components.length; i++){
					switch(components[i].getCode()){
						case 1 : speaker = components[i]; break;
						case 2 : window = components[i]; break;
						case 3 : tvDining = components[i]; break;
						case 4 : tvLiving = components[i]; break;
						default : break;
					}
				}
				new ComponentList(speaker, window, tvDining, tvLiving).setVisible(true);
			}
		});
		add(settingBtnPanel);
		
		JPanel timeSetPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		timeSetPanel.setBackground(black);
		
		JPanel hourPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		hourPanel.setBackground(black);
		hourLabel = new JLabel("Hours : ");
		hourLabel.setFont(new Font("Consolas", 1, 23));
		hourLabel.setForeground(blue);
		SpinnerNumberModel hourModel = new SpinnerNumberModel(0, 0, 24, 1);
		hourControl = new JSpinner(hourModel);
		hourControl.setFont(new Font("Consolas", 1, 20));
		hourPanel.add(hourLabel);
		hourPanel.add(hourControl);
		
		JPanel minutePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		minutePanel.setBackground(black);
		minuteLabel = new JLabel("  Minutes : ");
		minuteLabel.setFont(new Font("Consolas", 1, 23));
		minuteLabel.setForeground(blue);
		SpinnerNumberModel minuteModel = new SpinnerNumberModel(0, 0, 60, 1);
		minuteControl = new JSpinner(minuteModel);
		minuteControl.setFont(new Font("Consolas", 1, 20));
		minutePanel.add(minuteLabel);
		minutePanel.add(minuteControl);
		
		timeSetPanel.add(hourPanel);
		timeSetPanel.add(minutePanel);
		
		add(timeSetPanel);
	} 
}
