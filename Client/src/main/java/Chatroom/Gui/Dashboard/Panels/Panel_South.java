package Chatroom.Gui.Dashboard.Panels;

import Chatroom.Global;

import javax.swing.*;
import java.awt.*;

public class Panel_South extends JPanel {

    public Panel_South(){

        JLabel label = new JLabel("Upcoming Changes");
        label.setForeground(Global.FOREGROUND);
        JTextArea upcomingUpdates = new JTextArea();
        upcomingUpdates.setBackground(Global.BACKGROUND_2);
        upcomingUpdates.setForeground(Global.FOREGROUND);
        upcomingUpdates.setBorder(BorderFactory.createEmptyBorder());
        upcomingUpdates.setLineWrap(true);
        upcomingUpdates.setEditable(false);
        upcomingUpdates.setFocusable(false);
        upcomingUpdates.setPreferredSize(new Dimension(800,100));

        upcomingUpdates.setText("Temp database to store messages for User who are offline + loading from database\n" +
                "Message Notification\n" +
                "10 Groups per User\n" +
                "Beautiful GUI\n" +
                "Visual Notification on new Message\n" +
                "Saw message indicator\n");

        JScrollPane pane = new JScrollPane(upcomingUpdates);
        pane.setBorder(BorderFactory.createEmptyBorder());

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(0,50,50,50));
        setBackground(Global.BACKGROUND_1);
        setForeground(Global.FOREGROUND);

        add(label);
        add(pane);

    }

}
