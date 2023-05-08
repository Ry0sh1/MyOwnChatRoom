package Chatroom.Gui.PrivateChats;

import Chatroom.Gui.PrivateChats.Panels.Panel_PrivateChats_All;

import javax.swing.*;

public class Frame_PrivateChats extends JFrame {

    Panel_PrivateChats_All all;

    public Frame_PrivateChats(){

        all = new Panel_PrivateChats_All(this);
        add(all);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

}