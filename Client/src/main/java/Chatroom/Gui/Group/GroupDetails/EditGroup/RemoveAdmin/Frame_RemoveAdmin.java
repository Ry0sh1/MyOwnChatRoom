package Chatroom.Gui.Group.GroupDetails.EditGroup.RemoveAdmin;

import Chatroom.Global;
import Chatroom.Gui.Group.GroupDetails.EditGroup.RemoveAdmin.Panels.Panel_RemoveAdmin_All;

import javax.swing.*;

public class Frame_RemoveAdmin extends JFrame {

    public Frame_RemoveAdmin(int x, int y){

        add(new Panel_RemoveAdmin_All(this));

        setLocation(x,y);
        setJMenuBar(Global.MENUBAR);
        setBackground(Global.BACKGROUND_1);
        pack();
        setVisible(true);

    }

}
