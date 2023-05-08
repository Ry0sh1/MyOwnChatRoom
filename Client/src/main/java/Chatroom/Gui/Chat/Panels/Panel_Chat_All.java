package Chatroom.Gui.Chat.Panels;

import Chatroom.Gui.Chat.Frame_Chat;
import Chatroom.User;

import javax.swing.*;
import java.awt.*;

public class Panel_Chat_All extends JPanel {

    private final Panel_Chat_North north;

    public Panel_Chat_All(Frame_Chat frame, User with){

        north = new Panel_Chat_North(with);
        Panel_Chat_South south = new Panel_Chat_South(frame, with);

        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);

    }

    public void append(String message){

        north.append(message);

    }

}
