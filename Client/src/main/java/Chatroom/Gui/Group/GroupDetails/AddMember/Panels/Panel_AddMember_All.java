package Chatroom.Gui.Group.GroupDetails.AddMember.Panels;

import Chatroom.Global;
import Chatroom.Gui.Group.GroupDetails.AddMember.Frame_AddMember;

import javax.swing.*;

public class Panel_AddMember_All extends JPanel {

    public Panel_AddMember_All(Frame_AddMember frame){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(CENTER_ALIGNMENT);
        setBackground(Global.BACKGROUND_1);

        JLabel label = new JLabel("Select Members you want to add");
        label.setForeground(Global.FOREGROUND);
        label.setBackground(Global.BACKGROUND_1);

        add(label);
        add(new Panel_AddMember_Center(frame));
        add(new Panel_AddMember_South(frame));

    }

}
