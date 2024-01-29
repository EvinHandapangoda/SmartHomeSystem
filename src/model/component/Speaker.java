package model.component;

import controller.TimeBlockController;
import model.timeblock.CurrentTimeBlock;
import view.component.SpeakerDisplay;
import view.TimeLogs;

public class Speaker implements Component {
    private SpeakerDisplay speakerDisplay;
    private TimeLogs speakerTime;
    final int CODE = 1;

    public Speaker(){
        speakerDisplay = new SpeakerDisplay();
    }

    public void showTimeSetter(){
        if(speakerTime == null){
            speakerTime = new TimeLogs("Speaker", 15, 600, CODE);
        }
        speakerTime.setVisible(true);
    }

    public void showDisplay(){
        speakerDisplay.setVisible(true);
    }

    public int getCode(){
        return this.CODE;
    }

    public void alertON(CurrentTimeBlock currentTime){
        boolean isValid = TimeBlockController.checkTime(CODE, currentTime.getStartHour(), currentTime.getStartMinute());
        speakerDisplay.alertedON(isValid);
    }

    public void alertOFF(){
        speakerDisplay.alertedOFF();
    }
}