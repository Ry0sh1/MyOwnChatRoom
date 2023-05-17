package Chatroom.Gui.Group.GroupDetails.Panels.North;

import Chatroom.Global;
import Chatroom.Gui.Group.Frame_Group;

import javax.swing.*;
import java.awt.*;

public class Panel_GroupDetails_North_GroupName extends JPanel {

    public Panel_GroupDetails_North_GroupName() {

        JLabel groupName = new JLabel(Frame_Group.getGroupName(), SwingConstants.CENTER);
        groupName.setForeground(Global.FOREGROUND);
        groupName.setBackground(Global.BACKGROUND_1);
        groupName.setFont(new Font("TimesRoman", Font.BOLD, 20));
        setBackground(Global.BACKGROUND_1);
        add(groupName);

    }

}
