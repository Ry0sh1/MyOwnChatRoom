package Chatroom.Gui.Contacts.Panels;

import Chatroom.Global;
import Chatroom.Gui.Contacts.Frame_Contacts;
import Chatroom.Gui.Contacts.Listener.Listener_Contacts_Action;

import javax.swing.*;
import java.awt.*;

public class Panel_Contacts_South extends JPanel {

    public Panel_Contacts_South(Frame_Contacts frame) {

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new Listener_Contacts_Action("cancel", frame));
        cancel.setPreferredSize(new Dimension(80,60));
        cancel.setBackground(Global.BACKGROUND_1);
        cancel.setForeground(Global.FOREGROUND);
        cancel.addMouseListener(Global.EXIT);
        cancel.addMouseListener(Global.ENTER);
        cancel.setBorder(BorderFactory.createLineBorder(Global.LINE, 2));
        cancel.setName("cancel");
        cancel.setFocusable(false);

        setBackground(Global.BACKGROUND_1);
        add(cancel);

    }

}
