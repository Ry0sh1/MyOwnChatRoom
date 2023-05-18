package Chatroom.Gui.Group.GroupDetails.Panels.North;

import Chatroom.Global;
import Chatroom.Gui.Group.Frame_Group;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class Panel_GroupDetails_North_Created extends JPanel {

    public Panel_GroupDetails_North_Created(){

        try {

            PrintWriter out = new PrintWriter(Global.SQL_CLIENT.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(Global.SQL_CLIENT.getInputStream()));

            out.println("quSELECT created FROM groups WHERE name = '" + Frame_Group.getGroupName() + "'");
            long time = Long.parseLong(in.readLine());
            out.println("quSELECT creator FROM groups WHERE name = '" + Frame_Group.getGroupName() + "'");
            String creator = in.readLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            String formattedTime = sdf.format(time);
            setBackground(Global.BACKGROUND_1);
            JLabel created = new JLabel("Created: " + formattedTime + " by " + creator, SwingConstants.CENTER);
            created.setForeground(Global.FOREGROUND);
            created.setBackground(Global.BACKGROUND_1);

            add(created);

        }catch (IOException i){

            System.out.println("Error");

        }

    }

}
