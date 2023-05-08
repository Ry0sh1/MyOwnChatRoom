package Chatroom.Gui.Chat;

import Chatroom.Gui.Chat.Panels.Panel_Chat_All;
import Chatroom.User;

import javax.swing.*;

public class Frame_Chat extends JFrame {

    public Frame_Chat(User with){

        add(new Panel_Chat_All(this, with));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

}
