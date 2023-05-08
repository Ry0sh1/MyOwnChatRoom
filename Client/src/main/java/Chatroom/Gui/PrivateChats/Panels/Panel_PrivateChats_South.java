package Chatroom.Gui.PrivateChats.Panels;

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

        add(cancel);

    }

}
