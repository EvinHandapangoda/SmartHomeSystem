package controller;

import model.component.Speaker;
import model.component.TVDining;
import model.component.TVLiving;
import model.component.Window;
import view.Switch;

class SuperHomeController {
	public static void main(String[] args){
		Switch mainSwitch = new Switch(new Speaker(), new Window(), new TVDining(), new TVLiving());
		mainSwitch.setVisible(true);		
	}
}
