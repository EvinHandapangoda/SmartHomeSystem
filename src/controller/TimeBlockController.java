package controller;

import db.DBConnection;
import db.TimeBlockList;
import model.timeblock.*;

public class TimeBlockController {
	public static void add(TimeBlock timeBlock){
		TimeBlockList timeBlockList = DBConnection.getInstance().getTimeBlockList();
		timeBlockList.add(timeBlock);
	}
	
	public static boolean isAlreadySet(int startHour, int startMinute, int endHour, int endMinute, int code){
		TimeBlock timeBlock = null;
		switch(code){
			case 1 : timeBlock = new SpeakerTimeBlock(startHour,startMinute,endHour,endMinute);	break;
			case 2 : timeBlock = new WindowTimeBlock(startHour,startMinute,endHour,endMinute); break;
			case 3 : timeBlock = new TVDiningTimeBlock(startHour,startMinute,endHour,endMinute); break;
			case 4 : timeBlock = new TVLivingTimeBlock(startHour,startMinute,endHour,endMinute); break;
		}
		TimeBlockList timeBlockList = DBConnection.getInstance().getTimeBlockList();
		if(timeBlockList.isEquals(timeBlock, code)){
			return true;
		}
		return false;
	}
	
	public static boolean checkTime(int code, int setHour, int setMinute){
		TimeBlockList timeBlockList = DBConnection.getInstance().getTimeBlockList();
		TimeBlock[] timeBlockArray = timeBlockList.toArray(code);
		TimeBlock mostSutiable = null;
		
		if(timeBlockArray.length != 0){
			int minHour = 9999;
			int minMinute = 9999;
			
			for(int i =0; i<timeBlockArray.length; i++){
				if(timeBlockArray[i].getStartHour() ==  setHour){
					if(timeBlockArray[i].getStartMinute() <= setMinute){
						int min = setMinute - timeBlockArray[i].getStartMinute();
						if(min < 0){return false;}
						if(min <= minMinute){
							mostSutiable = timeBlockArray[i];
						}
					}
				}else if(timeBlockArray[i].getStartHour() < setHour){
					int min = setHour - timeBlockArray[i].getStartHour();
					if(min < 0){return false;}
					if(min <= minHour){
						mostSutiable = timeBlockArray[i];
					}
				}
			}
			if(mostSutiable != null){		
				if(mostSutiable.getEndHour() == setHour){
					if(mostSutiable.getEndMinute() <= setMinute){
						mostSutiable = null;
					}
				}else if(mostSutiable.getEndHour() < setHour){
					mostSutiable = null;
				}
			}
		}
				
		return mostSutiable != null;
	}
		
}
