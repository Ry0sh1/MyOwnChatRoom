package Chatroom.Gui.Dashboard.Panels;

import Chatroom.Gui.Dashboard.Frame_Dashboard;
import Chatroom.Gui.Dashboard.Listener.Listener_Action;

import javax.swing.*;
import java.awt.*;

public class Panel_East extends JPanel{

    public Panel_East(Frame_Dashboard frame){

        JButton logOut = new JButton("Log Out");
        logOut.setName("logOut");
        logOut.addActionListener(new Listener_Action(frame, logOut.getName()));
        logOut.setPreferredSize(new Dimension(200,50));
        logOut.setFocusable(false);
        JButton group = new JButton("Create Group");
        group.setName("group");
        group.addActionListener(new Listener_Action(frame, group.getName()));
        group.setPreferredSize(new Dimension(200,50));
        group.setFocusable(false);
        JButton contacts = new JButton("Contacts");
        contacts.setName("contacts");
        contacts.addActionListener(new Listener_Action(frame, contacts.getName()));
        contacts.setPreferredSize(new Dimension(200,50));
        contacts.setFocusable(false);
        JButton chats = new JButton("Chats");
        chats.setName("chats");
        chats.addActionListener(new Listener_Action(frame, chats.getName()));
        chats.setPreferredSize(new Dimension(200,50));
        chats.setFocusable(false);

        setLayout(new GridLayout(8,1));
        add(logOut);
        add(group);
        add(contacts);
        add(chats);

    }

}
