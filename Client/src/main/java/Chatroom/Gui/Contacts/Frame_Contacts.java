package Chatroom.Gui.Contacts;

import Chatroom.Gui.Contacts.Panels.Panel_Contacts_All;

import javax.swing.*;

public class Frame_Contacts extends JFrame {

    public Frame_Contacts(){

        Panel_Contacts_All all = new Panel_Contacts_All(this);

        add(all);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

}
