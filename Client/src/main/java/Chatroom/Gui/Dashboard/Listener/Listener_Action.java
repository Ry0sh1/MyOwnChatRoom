package Chatroom.Gui.Dashboard.Listener;

import Chatroom.Gui.Contacts.Frame_Contacts;
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
                System.out.println("LogOut Button Working");
                frame.dispose();
                new Frame_IpInput();
            }
            case "Create Group" -> System.out.println("Group Button Working");
            //TODO
            case "Contacts" -> {
                frame.dispose();
                new Frame_Contacts();
            }
            case "Chats" -> {
                frame.dispose();
                new Frame_PrivateChats();
            }

        }

    }

}
