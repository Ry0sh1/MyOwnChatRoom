package Chatroom.Gui.Group.GroupDetails.Panels.North;

import Chatroom.Global;

import javax.swing.*;

public class Panel_GroupDetails_North extends JPanel {

    public Panel_GroupDetails_North(){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(CENTER_ALIGNMENT);
        setBackground(Global.BACKGROUND_1);
        setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        add(new Panel_GroupDetails_North_GroupName());
        add(new Panel_GroupDetails_North_Created());
        add(new Panel_GroupDetails_North_Description());

    }

}
