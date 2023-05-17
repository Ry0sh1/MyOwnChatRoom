package Chatroom.Gui.Group.GroupDetails.EditGroup.KickMember.Panels;

import Chatroom.Global;
import Chatroom.Gui.Group.GroupDetails.EditGroup.KickMember.Frame_KickMember;

import javax.swing.*;

public class Panel_KickMember_All extends JPanel {

    public Panel_KickMember_All(Frame_KickMember frame){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(CENTER_ALIGNMENT);
        setBackground(Global.BACKGROUND_1);

        JLabel label = new JLabel("Select Members you want to kick");
        label.setForeground(Global.FOREGROUND);
        label.setBackground(Global.BACKGROUND_1);

        add(label);
        add(new Panel_KickMember_Center(frame));
        add(new Panel_KickMember_South(frame));

    }

}
