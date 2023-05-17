package Chatroom.Gui.Group.GroupDetails.EditGroup.Panels;

import Chatroom.Global;
import Chatroom.Gui.Group.Frame_Group;
import Chatroom.Gui.Group.GroupDetails.EditGroup.Frame_EditGroup;
import Chatroom.Gui.Group.GroupDetails.EditGroup.Panels.North.Panel_EditGroup_North;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Panel_EditGroup_All extends JPanel {

    public Panel_EditGroup_All(Frame_EditGroup frame){

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setAlignmentX(CENTER_ALIGNMENT);
        setBackground(Global.BACKGROUND_1);

        add(new Panel_EditGroup_North());
        add(new Panel_EditGroup_Center());
        add(new Panel_EditGroup_South(frame));

    }

}
