package Chatroom.Gui.Group.GroupDetails;

import Chatroom.Global;
import Chatroom.Gui.Group.Frame_Group;
import Chatroom.Gui.Group.GroupDetails.Panels.Panel_GroupDetails_All;

import javax.swing.*;

public class Frame_GroupDetails extends JFrame {

    public Frame_GroupDetails(int x, int y){

        add(new Panel_GroupDetails_All(this));

        setLocation(x,y);
        setJMenuBar(Global.MENUBAR);
        setBackground(Global.BACKGROUND_1);
        setTitle(Frame_Group.getGroupName());
        pack();
        setVisible(true);

    }

}
