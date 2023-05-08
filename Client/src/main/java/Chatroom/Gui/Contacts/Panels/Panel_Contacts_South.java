package Chatroom.Gui.Contacts.Panels;

import Chatroom.Gui.Contacts.Frame_Contacts;
import Chatroom.Gui.Contacts.Listener.Listener_Contacts_Action;

import javax.swing.*;

public class Panel_Contacts_South extends JPanel {

    public Panel_Contacts_South(Frame_Contacts frame) {

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new Listener_Contacts_Action("cancel", frame));
        cancel.setName("cancel");
        cancel.setFocusable(false);

        add(cancel);

    }

}
