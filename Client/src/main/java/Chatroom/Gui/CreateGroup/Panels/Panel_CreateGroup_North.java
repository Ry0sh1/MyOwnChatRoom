package Chatroom.Gui.CreateGroup.Panels;

import Chatroom.Global;
import Chatroom.Gui.CreateGroup.Frame_CreateGroup;

import javax.swing.*;
import java.awt.*;

public class Panel_CreateGroup_North extends JPanel {

    public Panel_CreateGroup_North(Frame_CreateGroup frame){

        JLabel title = new JLabel("Select member you want to add to the group");
        title.setBackground(Global.BACKGROUND_1);
        title.setForeground(Global.FOREGROUND);

        add(title);
        setBackground(Global.BACKGROUND_1);

    }

}
