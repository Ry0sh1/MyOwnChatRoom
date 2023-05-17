package Chatroom.Gui.Group.GroupDetails;

import Chatroom.Global;
import Chatroom.Gui.Group.Frame_Group;
import Chatroom.Gui.Group.GroupDetails.Panels.Panel_GroupDetails_All;

import javax.swing.*;

public class Frame_GroupDetails extends JFrame {

    public Frame_GroupDetails(int x, int y){

        add(new Panel_GroupDetails_All(this));
        Global.frameFactory(this);
        setTitle(Frame_Group.getGroupName());
        setLocation(x,y);
        setBackground(Global.BACKGROUND_1);

    }

}
