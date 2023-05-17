package Chatroom.Gui.Group.GroupDetails.EditGroup.Panels.North;

import Chatroom.Global;
import Chatroom.Gui.Group.Frame_Group;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Panel_EditGroup_North_Created extends JPanel {

    public Panel_EditGroup_North_Created(){

        try {

            PrintWriter out = new PrintWriter(Global.SQL_CLIENT.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(Global.SQL_CLIENT.getInputStream()));

            out.println("quSELECT created FROM groups WHERE name = '" + Frame_Group.getGroupName() + "'");
            setBackground(Global.BACKGROUND_1);
            JLabel created = new JLabel("Created: " + in.readLine(), SwingConstants.CENTER);
            created.setForeground(Global.FOREGROUND);
            created.setBackground(Global.BACKGROUND_1);

            add(created);

        }catch (IOException i){

            System.out.println("Error");

        }

    }

}
