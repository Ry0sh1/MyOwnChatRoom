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

            case "logOut" -> {
                System.out.println("LogOut Button Working");
                frame.dispose();
                new Frame_IpInput();
            }
            case "group" -> System.out.println("Group Button Working");
            //TODO
            case "contacts" -> {
                frame.dispose();
                new Frame_Contacts();
            }
            case "chats" -> {
                frame.dispose();
                new Frame_PrivateChats();
            }

        }

    }

}
