package Chatroom.Gui.Group.GroupDetails.Panels;

import Chatroom.Global;
import Chatroom.Gui.Group.GroupDetails.Frame_GroupDetails;
import Chatroom.Gui.Group.GroupDetails.Panels.North.Panel_GroupDetails_North;

import javax.swing.*;

public class Panel_GroupDetails_All extends JPanel {

    public Panel_GroupDetails_All(Frame_GroupDetails frame){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Global.BACKGROUND_1);
        setAlignmentX(CENTER_ALIGNMENT);
        add(new Panel_GroupDetails_North());
        add(new Panel_GroupDetails_Center());
        add(new Panel_GroupDetails_South(frame));

    }

}
