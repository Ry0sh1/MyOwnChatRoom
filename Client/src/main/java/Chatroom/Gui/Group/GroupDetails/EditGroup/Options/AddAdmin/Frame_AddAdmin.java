package Chatroom.Gui.Group.GroupDetails.EditGroup.Options.AddAdmin;

import Chatroom.Global;
import Chatroom.Gui.Group.GroupDetails.EditGroup.Options.AddAdmin.Panels.Panel_AddAdmin_All;

import javax.swing.*;

public class Frame_AddAdmin extends JFrame {

    public Frame_AddAdmin(int x, int y){

        add(new Panel_AddAdmin_All(this));

        setLocation(x,y);
        setJMenuBar(Global.MENUBAR);
        setBackground(Global.BACKGROUND_1);
        pack();
        setVisible(true);

    }

}
