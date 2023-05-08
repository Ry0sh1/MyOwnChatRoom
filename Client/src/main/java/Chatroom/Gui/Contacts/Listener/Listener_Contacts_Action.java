package Chatroom.Gui.Contacts.Listener;

import Chatroom.Global;
import Chatroom.Gui.Contacts.Frame_Contacts;
import Chatroom.Gui.Dashboard.Frame_Dashboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener_Contacts_Action implements ActionListener {

    private final String buttonName;
    private final Frame_Contacts frame;

    public Listener_Contacts_Action(String buttonName, Frame_Contacts frame){

        this.buttonName = buttonName;
        this.frame = frame;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (buttonName.equals("cancel")){

            frame.dispose();
            new Frame_Dashboard();

        }

    }

}
