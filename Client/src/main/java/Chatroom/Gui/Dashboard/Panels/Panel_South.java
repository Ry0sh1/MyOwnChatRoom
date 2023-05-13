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

        upcomingUpdates.setText("Temp database to store messages for User who are offline + loading from database\n" +
                "Work on Create Group\n" +
                "Message Notification\n" +
                "10 Groups per User\n" +
                "Beautiful GUI\n" +
                "Visual Notification on new Message\n" +
                "Saw message indicator\n" +
                "Editable Profiles\n" +
                "More themes & Colors\n" +
                "Even more security between server and client\n" +
                "Shift settings to menubar + add more menus");

        JScrollPane scPane = new JScrollPane(upcomingUpdates);
        scPane.setPreferredSize(new Dimension(800,100));
        scPane.getVerticalScrollBar().setUI(Global.TEXTAREA_SCROLLBAR_UI);
        scPane.setBorder(BorderFactory.createEmptyBorder());

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(0,50,50,50));
        setBackground(Global.BACKGROUND_1);
        setForeground(Global.FOREGROUND);

        add(label);
        add(scPane);

    }

}
