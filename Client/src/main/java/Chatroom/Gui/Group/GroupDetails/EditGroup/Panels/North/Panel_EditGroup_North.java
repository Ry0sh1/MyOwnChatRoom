package Chatroom.Gui.Group.GroupDetails.EditGroup.Panels.North;

import Chatroom.Global;
import Chatroom.Gui.Group.GroupDetails.Panels.North.Panel_GroupDetails_North_Created;
import Chatroom.Gui.Group.GroupDetails.Panels.North.Panel_GroupDetails_North_Description;
import Chatroom.Gui.Group.GroupDetails.Panels.North.Panel_GroupDetails_North_GroupName;

import javax.swing.*;

public class Panel_EditGroup_North extends JPanel {

    public Panel_EditGroup_North(){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(CENTER_ALIGNMENT);
        setBackground(Global.BACKGROUND_1);
        setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        add(new Panel_EditGroup_North_GroupName());
        add(new Panel_EditGroup_North_Created());

    }

}
