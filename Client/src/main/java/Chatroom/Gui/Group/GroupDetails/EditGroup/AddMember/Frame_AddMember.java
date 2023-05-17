package Chatroom.Gui.Group.GroupDetails.EditGroup.AddMember;

import Chatroom.Global;
import Chatroom.Gui.Group.GroupDetails.EditGroup.AddMember.Panels.Panel_AddMember_All;

import javax.swing.*;

public class Frame_AddMember extends JFrame {

    public Frame_AddMember(int x, int y){

        add(new Panel_AddMember_All(this));

        setLocation(x,y);
        setJMenuBar(Global.MENUBAR);
        setBackground(Global.BACKGROUND_1);
        pack();
        setVisible(true);

    }

}
