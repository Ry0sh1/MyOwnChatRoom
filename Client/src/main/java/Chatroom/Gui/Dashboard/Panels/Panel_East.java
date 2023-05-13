package Chatroom.Gui.Dashboard.Panels;

import Chatroom.Global;
import Chatroom.Gui.Dashboard.Frame_Dashboard;
import Chatroom.Gui.Dashboard.Listener.Listener_Action;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel_East extends JPanel{

    public Panel_East(Frame_Dashboard frame){

        JButton logOut = new JButton("Log Out");
        JButton group = new JButton("Create Group");
        JButton contacts = new JButton("Contacts");
        JButton chats = new JButton("Chats");

        ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(logOut);
        buttons.add(group);
        buttons.add(contacts);
        buttons.add(chats);

        for (JButton b:buttons) {

            b.setName(b.getText());
            b.addActionListener(new Listener_Action(frame, b.getName()));
            b.setPreferredSize(new Dimension(200,50));
            b.setFocusable(false);
            b.setBorder(BorderFactory.createLineBorder(Global.LINE,2));
            b.setBackground(Global.BACKGROUND_1);
            b.setForeground(Global.FOREGROUND);
            b.addMouseListener(Global.ENTER);
            b.addMouseListener(Global.EXIT);

        }

        setBackground(Global.BACKGROUND_1);
        setForeground(Global.FOREGROUND);
        setLayout(new GridLayout(8,1));
        add(logOut);
        add(group);
        add(contacts);
        add(chats);

    }

}
