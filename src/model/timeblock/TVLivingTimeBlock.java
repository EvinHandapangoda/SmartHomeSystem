package model.timeblock;

public class TVLivingTimeBlock implements TimeBlock{
    final int CODE = 4;
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;

    public TVLivingTimeBlock(int startHour, int startMinute, int endHour, int endMinute){
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