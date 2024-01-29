package model.component;

import controller.TimeBlockController;
import model.timeblock.CurrentTimeBlock;
import view.component.TVLivingDisplay;
import view.TimeLogs;

public class TVLiving implements Component {
    private TVLivingDisplay tvLivingDisplay;
    private TimeLogs tvLivingTime;
    final int CODE = 4;

    public TVLiving(){
        tvLivingDisplay = new TVLivingDisplay();
    }

    public void showTimeSetter(){
        if(tvLivingTime == null){
            tvLivingTime = new TimeLogs("TV (Living Room)", 15, 300, CODE);
        }
        tvLivingTime.setVisible(true);
    }

    public void showDisplay(){
        tvLivingDisplay.setVisible(true);
    }

    public int getCode(){
        return this.CODE;
    }

    public void alertON(CurrentTimeBlock currentTime){
        boolean isValid = TimeBlockController.checkTime(CODE, currentTime.getStartHour(), currentTime.getStartMinute());
        tvLivingDisplay.alertedON(isValid);
    }

    public void alertOFF(){
        tvLivingDisplay.alertedOFF();
    }
}