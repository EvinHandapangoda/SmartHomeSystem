package model.component;

import model.timeblock.CurrentTimeBlock;

import controller.TimeBlockController;
import view.TimeLogs;
import view.component.WindowDisplay;

public class Window implements Component {
	private WindowDisplay windowDisplay;
	private TimeLogs windowTime;
	final int CODE = 2;

	public Window(){
		windowDisplay = new WindowDisplay();
	}
	
	public void showTimeSetter(){
		if(windowTime == null){
			windowTime = new TimeLogs("Window", 1200, 300, CODE);
		}
		windowTime.setVisible(true);
	}	
	
	public void showDisplay(){
		windowDisplay.setVisible(true);
	}
	
	public int getCode(){
		return this.CODE;
	}
	
	public void alertON(CurrentTimeBlock currentTime){
		boolean isValid = TimeBlockController.checkTime(CODE, currentTime.getStartHour(), currentTime.getStartMinute());
		windowDisplay.alertedON(isValid);
	}
	
	public void alertOFF(){
		windowDisplay.alertedOFF();
	}
}

