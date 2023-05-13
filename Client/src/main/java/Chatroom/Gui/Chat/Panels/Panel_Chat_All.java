package Chatroom.Gui.Chat.Panels;

import Chatroom.Global;
import Chatroom.Gui.Chat.Frame_Chat;
import Chatroom.User;

import javax.swing.*;
import java.awt.*;

public class Panel_Chat_All extends JPanel {

    private final Panel_Chat_North north;

    public Panel_Chat_All(Frame_Chat frame, User with){

        north = new Panel_Chat_North(with);
        Panel_Chat_South south = new Panel_Chat_South(frame, with);

        setBackground(Global.BACKGROUND_1);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(CENTER_ALIGNMENT);
        add(north);
        add(south);

    }

    public void append(String message){

        north.append(message);

    }

}
