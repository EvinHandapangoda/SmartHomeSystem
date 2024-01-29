package model.component;

import controller.TimeBlockController;
import model.timeblock.CurrentTimeBlock;
import view.component.TVDiningDisplay;
import view.TimeLogs;

public class TVDining implements Component {
    private TVDiningDisplay tvDiningDisplay;
    private TimeLogs tvDiningTime;
    final int CODE = 3;

    public TVDining(){
        tvDiningDisplay = new TVDiningDisplay();
    }

    public void showTimeSetter(){
        if(tvDiningTime == null){
            tvDiningTime = new TimeLogs("TV (Dining Room)", 1200, 600, CODE);
        }
        tvDiningTime.setVisible(true);
    }

    public void showDisplay(){
        tvDiningDisplay.setVisible(true);
    }

    public int getCode(){
        return this.CODE;
    }

    public void alertON(CurrentTimeBlock currentTime){
        boolean isValid = TimeBlockController.checkTime(CODE, currentTime.getStartHour(), currentTime.getStartMinute());
        tvDiningDisplay.alertedON(isValid);
    }

    public void alertOFF(){
        tvDiningDisplay.alertedOFF();
    }
}