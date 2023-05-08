package Chatroom.Gui.PrivateChats.Panels;

import Chatroom.Gui.PrivateChats.Frame_PrivateChats;

import javax.swing.*;
import java.awt.*;

public class Panel_PrivateChats_All extends JPanel {

    public Panel_PrivateChats_All(Frame_PrivateChats frame){

        Panel_PrivateChats_North north = new Panel_PrivateChats_North(frame);
        Panel_PrivateChats_South south = new Panel_PrivateChats_South(frame);

        setLayout(new BorderLayout());

        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);

    }

}
