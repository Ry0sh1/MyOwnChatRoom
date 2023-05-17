package Chatroom.Gui.Group.GroupDetails.EditGroup.RemoveAdmin.Panels;

import Chatroom.Global;
import Chatroom.Gui.Group.GroupDetails.EditGroup.RemoveAdmin.Frame_RemoveAdmin;

import javax.swing.*;

public class Panel_RemoveAdmin_All extends JPanel {

    public Panel_RemoveAdmin_All(Frame_RemoveAdmin frame){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(CENTER_ALIGNMENT);
        setBackground(Global.BACKGROUND_1);

        JLabel label = new JLabel("Select Members you want to give Admin rights");
        label.setForeground(Global.FOREGROUND);
        label.setBackground(Global.BACKGROUND_1);

        add(label);
        add(new Panel_RemoveAdmin_Center(frame));
        add(new Panel_RemoveAdmin_South(frame));

    }

}
