package Chatroom.Gui.Group.Panels;

import Chatroom.Global;
import Chatroom.Group;
import Chatroom.Gui.Group.Frame_Group;

import javax.swing.*;
import java.awt.*;
import java.net.Socket;

public class Panel_Group_All extends JPanel {

    private final Panel_Group_North north;

    public Panel_Group_All(Socket groupClient, Group group, Frame_Group frame){

        north = new Panel_Group_North();
        Panel_Group_South south = new Panel_Group_South(groupClient, group, frame);

        setBackground(Global.BACKGROUND_1);
        setForeground(Global.FOREGROUND);
        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);

    }

    public void append(String message){

       north.append(message);

    }

}
