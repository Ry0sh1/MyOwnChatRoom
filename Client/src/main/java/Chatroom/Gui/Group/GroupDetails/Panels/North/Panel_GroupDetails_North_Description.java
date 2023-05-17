package Chatroom.Gui.Group.GroupDetails.Panels.North;

import Chatroom.Global;
import Chatroom.Gui.Group.Frame_Group;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Panel_GroupDetails_North_Description extends JPanel {

    private final JTextArea description;

    public Panel_GroupDetails_North_Description(){

        description = new JTextArea();
        description.setPreferredSize(new Dimension(200,150));
        description.setEditable(false);
        Global.textAreaFactory(description);
        JScrollPane scrollPane = new JScrollPane(description);
        scrollPane.setPreferredSize(new Dimension(200,150));
        Global.scrollPaneFactory(scrollPane);
        setPreferredSize(new Dimension(200,200));
        setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
        takeDescription();

        add(scrollPane);
        setBackground(Global.BACKGROUND_1);

    }

    private void takeDescription(){

        try {

            Socket sqlClient = Global.SQL_CLIENT;
            BufferedReader in = new BufferedReader(new InputStreamReader(sqlClient.getInputStream()));
            PrintWriter out = new PrintWriter(new PrintWriter(sqlClient.getOutputStream()), true);
            out.println("quSELECT id FROM groups WHERE name = '" + Frame_Group.getGroupName() + "'");
            String groupID = in.readLine();
            out.println("quSELECT description FROM groups WHERE id = " + groupID);
            String des = in.readLine();
            description.setText(des);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

}
