package Chatroom.Gui.Contacts.Panels;

import Chatroom.Global;
import Chatroom.Gui.Contacts.Frame_Contacts;

import javax.swing.*;
import java.awt.*;

public class Panel_Contacts_All extends JPanel {

    public Panel_Contacts_All(Frame_Contacts frame) {

        Panel_Contacts_Top top = new Panel_Contacts_Top();
        Panel_Contacts_South south = new Panel_Contacts_South(frame);

        setBackground(Global.BACKGROUND_1);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(CENTER_ALIGNMENT);
        add(top);
        add(south);

    }

}