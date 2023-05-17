package Chatroom.Gui.Group.GroupDetails.EditGroup;

import Chatroom.Global;
import Chatroom.Gui.Group.Frame_Group;
import Chatroom.Gui.Group.GroupDetails.EditGroup.Panels.Panel_EditGroup_All;

import javax.swing.*;

public class Frame_EditGroup extends JFrame {

    public Frame_EditGroup(int x, int y){

        add(new Panel_EditGroup_All(this));
        Global.frameFactory(this);
        setTitle(Frame_Group.getGroupName());
        setLocation(x,y);

    }

}
