package Chatroom.Gui.Contacts;

import Chatroom.Global;
import Chatroom.Gui.Contacts.Panels.Panel_Contacts_All;

import javax.swing.*;
import java.awt.*;

public class Frame_Contacts extends JFrame {

    public Frame_Contacts(){

        Panel_Contacts_All all = new Panel_Contacts_All(this);

        add(all);

        setBackground(Global.BACKGROUND_1);
        setForeground(Global.FOREGROUND);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

}
