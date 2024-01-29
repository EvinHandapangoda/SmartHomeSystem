package model.timeblock;

public class CurrentTimeBlock {
	private int startHour;
	private int startMinute;
	private int code = 0;

	public CurrentTimeBlock(){
		this.startHour = startHour;
		this.startMinute = startMinute;
	}
	
	public int getCode(){
		return this.code;
	}
	
	public int getStartHour(){
		return this.startHour;
	}
	
	public int getStartMinute(){
		return this.startMinute;
	}
	
	public void setStartHour(int startHour){
		this.startHour = startHour;
	}
	
	public void setStartMinute(int startMinute){
		this.startMinute = startMinute;
	}
	
}
