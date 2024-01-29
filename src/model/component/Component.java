package model.component;

import model.timeblock.CurrentTimeBlock;

public interface Component {
	public void showTimeSetter();
	
	public void showDisplay();
	
	public int getCode();
	
	public void alertON(CurrentTimeBlock currentTime);
	
	public void alertOFF();
}
