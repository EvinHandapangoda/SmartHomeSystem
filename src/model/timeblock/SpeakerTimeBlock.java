package model.timeblock;
public class SpeakerTimeBlock implements TimeBlock{
    final int CODE = 1;
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;

    public SpeakerTimeBlock(int startHour, int startMinute, int endHour, int endMinute){
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