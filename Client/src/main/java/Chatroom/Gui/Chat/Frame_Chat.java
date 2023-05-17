package Chatroom.Gui.Chat;

import Chatroom.Global;
import Chatroom.Gui.Chat.Panels.Panel_Chat_All;
import Chatroom.User;

import javax.swing.*;
import java.awt.*;

public class Frame_Chat extends JFrame {

    public Frame_Chat(User with, int x, int y){

        add(new Panel_Chat_All(this, with));

        setLocation(x,y);
        setJMenuBar(Global.MENUBAR);
        setPreferredSize(new Dimension(800,600));
        setBackground(Global.BACKGROUND_1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

}
