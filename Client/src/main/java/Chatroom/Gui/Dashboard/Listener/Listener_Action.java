package Chatroom.Gui.Dashboard.Listener;

import Chatroom.Gui.Contacts.Frame_Contacts;
import Chatroom.Gui.CreateGroup.Frame_CreateGroup;
import Chatroom.Gui.Dashboard.Frame_Dashboard;
import Chatroom.Gui.LogIn.Frame_IpInput;
import Chatroom.Gui.PrivateChats.Frame_PrivateChats;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener_Action implements ActionListener {

    private final Frame_Dashboard frame;
    private final String buttonName;


    public Listener_Action(Frame_Dashboard frame, String buttonName){
        this.frame = frame;
        this.buttonName = buttonName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (buttonName) {

            case "Log Out" -> {
                frame.dispose();
                new Frame_IpInput();
            }
            case "Create Group" -> {
                frame.dispose();
                new Frame_CreateGroup(frame.getX(),frame.getY());
            }
            case "Contacts" -> {
                frame.dispose();
                new Frame_Contacts(frame.getX(),frame.getY());
            }
            case "Chats" -> {
                frame.dispose();
                new Frame_PrivateChats(frame.getX(),frame.getY());
            }

        }

    }

}
