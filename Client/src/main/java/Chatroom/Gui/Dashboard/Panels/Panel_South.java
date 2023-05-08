package Chatroom.Gui.Dashboard.Panels;

import javax.swing.*;
import java.awt.*;

public class Panel_South extends JPanel {

    public Panel_South(){

        JLabel label = new JLabel("Upcoming Changes");
        JTextArea upcomingUpdates = new JTextArea();
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

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(0,50,50,50));

        add(label);
        add(pane);

    }

}
