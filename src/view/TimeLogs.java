package view;

import controller.TimeBlockController;
import model.timeblock.SpeakerTimeBlock;
import model.timeblock.TVDiningTimeBlock;
import model.timeblock.TVLivingTimeBlock;
import model.timeblock.WindowTimeBlock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeLogs extends JFrame{
	private JList<String> timeSet;
	private DefaultListModel<String> dlm;
	
	private JLabel startLabel;
	private JLabel startHourLabel;
	private JSpinner startHourSpinner;
	private JLabel startMinuteLabel;
	private JSpinner startMinuteSpinner;
	
	private JLabel endLabel;
	private JLabel endHourLabel;
	private JSpinner endHourSpinner;
	private JLabel endMinuteLabel;
	private JSpinner endMinuteSpinner;
	
	private JButton setButton;
	
	private int startHour;
	private int startMinute;
	private int endHour;
	private int endMinute;
	
	private boolean isValid;


	public TimeLogs(String title, int x, int y, int code){
		setSize(680,280);
		setTitle(title);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocation(x, y);
		Color blue = new Color(50, 170, 190);
		Color black = new Color(0, 0, 0);
		setVisible(true);
		
		dlm = new DefaultListModel<>();
		isValid = false;
		
		timeSet = new JList<>(dlm);
		timeSet.setFont(new Font("Consolas", 1, 20));
		timeSet.setBounds(0, 0, 500, 200);
		timeSet.setBackground(black);
		timeSet.setForeground(blue);
		add("Center",timeSet);
		
		JPanel southPanel = new JPanel(new GridLayout(2, 1));
		JPanel southPanelTop = new JPanel(new FlowLayout());
		southPanelTop.setBackground(blue);
		
		JPanel startTimePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		startTimePanel.setBackground(blue);
		startLabel = new JLabel("Start : ");
		startLabel.setFont(new Font("Consolas", 1, 17));
		startHourLabel = new JLabel("Hour:");
		startHourLabel.setFont(new Font("Consolas", 1, 17));
		SpinnerNumberModel startHourModel = new SpinnerNumberModel(0, 0, 24, 1);
		startHourSpinner = new JSpinner(startHourModel);
		startHourSpinner.setFont(new Font("Consolas", 1, 16));
		
		startMinuteLabel = new JLabel("  Minute:");
		startMinuteLabel.setFont(new Font("Consolas", 1, 17));
		SpinnerNumberModel startMinuteModel = new SpinnerNumberModel(0, 0, 60, 1);
		startMinuteSpinner = new JSpinner(startMinuteModel);
		startMinuteSpinner.setFont(new Font("Consolas", 1, 16));
		
		startTimePanel.add(startLabel);
		
		startTimePanel.add(startHourLabel);
		startTimePanel.add(startHourSpinner);
		
		startTimePanel.add(startMinuteLabel);
		startTimePanel.add(startMinuteSpinner);
		
		southPanelTop.add(startTimePanel);
		
		JPanel endTimePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		endTimePanel.setBackground(blue);
		endLabel = new JLabel("|  End : ");
		endLabel.setFont(new Font("Consolas", 1, 17));
		endHourLabel = new JLabel("Hour:");
		endHourLabel.setFont(new Font("Consolas", 1, 17));
		SpinnerNumberModel endHourModel = new SpinnerNumberModel(0, 0, 24, 1);
		endHourSpinner = new JSpinner(endHourModel);
		endHourSpinner.setFont(new Font("Consolas", 1, 16));
		
		endMinuteLabel = new JLabel("  Minute:");
		endMinuteLabel.setFont(new Font("Consolas", 1, 17));
		SpinnerNumberModel endMinuteModel = new SpinnerNumberModel(0, 0, 60, 1);
		endMinuteSpinner = new JSpinner(endMinuteModel);
		endMinuteSpinner.setFont(new Font("Consolas", 1, 16));
		
		endTimePanel.add(endLabel);
		
		endTimePanel.add(endHourLabel);
		endTimePanel.add(endHourSpinner);
		
		endTimePanel.add(endMinuteLabel);
		endTimePanel.add(endMinuteSpinner);
		
		southPanelTop.add(endTimePanel);
		southPanel.add(southPanelTop);
		
		JPanel southPanelBottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
		southPanelBottom.setBackground(black);
		setButton = new JButton("Set");
		setButton.setFont(new Font("Consolas", 1, 20));
		setButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				startHour = (Integer)startHourSpinner.getValue();
				startMinute = (Integer)startMinuteSpinner.getValue();
				endHour = (Integer)endHourSpinner.getValue();
				endMinute = (Integer)endMinuteSpinner.getValue();
				
				if(startHour>endHour){
					JOptionPane.showMessageDialog(null, "Start hour cannot be greater than end hour");
					isValid = false;				
				}else if(startHour == endHour && startMinute == 0 && endMinute == 0){
					JOptionPane.showMessageDialog(null, "Start hour cannot be equal to end hour");
					isValid = false;					
				}else if(startHour == endHour && startMinute>endMinute){
					JOptionPane.showMessageDialog(null, "Start minute cannot be greater than end minute");
					isValid = false;
				}else if(TimeBlockController.isAlreadySet(startHour, startMinute, endHour, endMinute, code)){
					JOptionPane.showMessageDialog(null, "Time period has been set previously");
					isValid = false;
				}else{
					isValid = true;
				}
				
				if(isValid){			
					dlm.addElement
					("Starts at "+startHour+"."+(startMinute<10? "0"+startMinute : startMinute)
					+" Ends at "+endHour+"."+(endMinute<10? "0"+endMinute : endMinute));	
					
					switch(code){
						case 1 :
							TimeBlockController.add(new SpeakerTimeBlock(startHour, startMinute, endHour, endMinute));
							break;
						case 2 :
							TimeBlockController.add(new WindowTimeBlock(startHour, startMinute, endHour, endMinute));
							break;
						case 3 :
							TimeBlockController.add(new TVDiningTimeBlock(startHour, startMinute, endHour, endMinute));
							break;
						case 4 : 
							TimeBlockController.add(new TVLivingTimeBlock(startHour, startMinute, endHour, endMinute));
							break;
						}
				}
			}
		});
		setButton.setBackground(blue);
		southPanelBottom.add(setButton);
		
		southPanel.add(southPanelBottom);

		add("South", southPanel);
		
	}
	
	public int getStartHour(){
		return startHour;
	}
	
	public int getStartMinute(){
		return startHour;
	}
	
	public int getEndHour(){
		return startHour;
	}
	
	public int getEndMinute(){
		return startHour;
	}
}
