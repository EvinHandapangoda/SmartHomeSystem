package model.timeblock;

public class WindowTimeBlock implements TimeBlock{
	final int CODE = 2;
	private int startHour;
	private int startMinute;
	private int endHour;
	private int endMinute;
	
	public WindowTimeBlock(int startHour, int startMinute, int endHour, int endMinute){
		this.startHour = startHour;
		this.startMinute = startMinute;
		this.endHour = endHour;
		this.endMinute = endMinute;
	}	
	
	public int getCode(){
		return this.CODE;
	}
	
	public int getStartHour(){
		return this.startHour;
	}
	
	public int getStartMinute(){
		return this.startMinute;
	}
	
	public int getEndHour(){
		return this.endHour;
	}
	
	public int getEndMinute(){
		return this.endMinute;
	}
}
