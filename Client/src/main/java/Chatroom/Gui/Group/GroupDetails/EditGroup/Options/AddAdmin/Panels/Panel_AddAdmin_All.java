package Chatroom.Gui.Group.GroupDetails.EditGroup.Options.AddAdmin.Panels;

import Chatroom.Global;
import Chatroom.Gui.Group.GroupDetails.EditGroup.Options.AddAdmin.Frame_AddAdmin;

import javax.swing.*;

public class Panel_AddAdmin_All extends JPanel {

    public Panel_AddAdmin_All(Frame_AddAdmin frame){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(CENTER_ALIGNMENT);
        setBackground(Global.BACKGROUND_1);

        JLabel label = new JLabel("Select Members you want to give Admin rights");
        label.setForeground(Global.FOREGROUND);
        label.setBackground(Global.BACKGROUND_1);

        add(label);
        add(new Panel_AddAdmin_Center(frame));
        add(new Panel_AddAdmin_South(frame));

    }

}
