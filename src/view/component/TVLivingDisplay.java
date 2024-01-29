package view.component;

import javax.swing.*;
import java.awt.*;

public class TVLivingDisplay extends JFrame {
    private JLabel notificationLabel;

    public TVLivingDisplay(){
        setSize(400,200);
        setTitle("TV (Living Room)");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(150, 60);
        setLayout(new BorderLayout());
        Color blue = new Color(50, 170, 190);
        Color black = new Color(0, 0, 0);
        getContentPane().setBackground(black);
        setVisible(true);

        notificationLabel = new JLabel("OFF");
        notificationLabel.setFont(new Font("Consolas", 1, 60));
        notificationLabel.setForeground(blue);
        notificationLabel.setHorizontalAlignment(JLabel.CENTER);
        add("Center", notificationLabel);

    }

    public void alertedON(boolean isValid){
        if(isValid){
            notificationLabel.setText("ON");
        }else{
            notificationLabel.setText("OFF");
        }
    }

    public void alertedOFF(){
        notificationLabel.setText("OFF");
    }
}