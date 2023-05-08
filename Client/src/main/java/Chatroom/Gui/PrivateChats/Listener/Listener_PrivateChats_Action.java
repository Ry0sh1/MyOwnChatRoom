package Chatroom.Gui.PrivateChats.Listener;

import Chatroom.Global;
import Chatroom.Gui.Chat.Frame_Chat;
import Chatroom.Gui.Dashboard.Frame_Dashboard;
import Chatroom.Gui.PrivateChats.Frame_PrivateChats;
import Chatroom.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener_PrivateChats_Action implements ActionListener {

    private final Frame_PrivateChats frame;
    private final String buttonName;

    public Listener_PrivateChats_Action(Frame_PrivateChats frame, String buttonName) {
        this.frame = frame;
        this.buttonName = buttonName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (buttonName.equals("cancel")){

            frame.dispose();
            new Frame_Dashboard();

        }else {

            User with = new User(buttonName);
            new Frame_Chat(with);
            frame.dispose();

        }

    }

}
