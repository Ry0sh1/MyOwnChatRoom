package Chatroom.Gui.PrivateChats;

import Chatroom.Global;
import Chatroom.Gui.PrivateChats.Panels.Panel_PrivateChats_All;

import javax.swing.*;

public class Frame_PrivateChats extends JFrame {

    Panel_PrivateChats_All all;

    public Frame_PrivateChats(){

        all = new Panel_PrivateChats_All(this);
        add(all);

        setBackground(Global.BACKGROUND_1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

}