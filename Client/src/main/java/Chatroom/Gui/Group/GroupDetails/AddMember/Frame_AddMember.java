package Chatroom.Gui.Group.GroupDetails.AddMember;

import Chatroom.Global;
import Chatroom.Gui.Group.GroupDetails.AddMember.Panels.Panel_AddMember_All;

import javax.swing.*;

public class Frame_AddMember extends JFrame {

    public Frame_AddMember(){

        add(new Panel_AddMember_All(this));

        setJMenuBar(Global.MENUBAR);
        setBackground(Global.BACKGROUND_1);
        pack();
        setVisible(true);

    }

}
