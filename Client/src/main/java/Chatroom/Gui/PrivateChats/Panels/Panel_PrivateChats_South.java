package Chatroom.Gui.PrivateChats.Panels;

import Chatroom.Global;
import Chatroom.Gui.PrivateChats.Frame_PrivateChats;
import Chatroom.Gui.PrivateChats.Listener.Listener_PrivateChats_Action;

import javax.swing.*;
import java.awt.*;

public class Panel_PrivateChats_South extends JPanel {

    public Panel_PrivateChats_South(Frame_PrivateChats frame) {
        JButton cancel = new JButton("Cancel");
        cancel.setPreferredSize(new Dimension(200,40));
        cancel.setFocusable(false);
        cancel.setName("cancel");
        cancel.addActionListener(new Listener_PrivateChats_Action(frame,"cancel"));
        cancel.setForeground(Global.FOREGROUND);
        cancel.setBackground(Global.BACKGROUND_1);
        cancel.addMouseListener(Global.ENTER);
        cancel.addMouseListener(Global.EXIT);
        cancel.setBorder(BorderFactory.createLineBorder(Global.LINE,2));

        setBackground(Global.BACKGROUND_1);
        add(cancel);

    }

}
