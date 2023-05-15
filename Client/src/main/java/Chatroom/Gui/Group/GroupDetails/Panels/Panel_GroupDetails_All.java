package Chatroom.Gui.Group.GroupDetails.Panels;

import Chatroom.Global;
import Chatroom.Gui.Group.GroupDetails.Frame_GroupDetails;

import javax.swing.*;

public class Panel_GroupDetails_All extends JPanel {

    public Panel_GroupDetails_All(Frame_GroupDetails frame){

        Panel_GroupDetails_South south = new Panel_GroupDetails_South(frame);
        Panel_GroupDetails_Center center = new Panel_GroupDetails_Center();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(CENTER_ALIGNMENT);
        add(center);
        add(south);
        setBackground(Global.BACKGROUND_1);

    }

}
