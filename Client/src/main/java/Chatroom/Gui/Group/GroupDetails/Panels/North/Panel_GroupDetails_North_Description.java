package Chatroom.Gui.Group.GroupDetails.Panels.North;

import Chatroom.Global;
import Chatroom.Gui.Group.Frame_Group;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Panel_GroupDetails_North_Description extends JPanel {

    public Panel_GroupDetails_North_Description(){

        JTextArea description = new JTextArea();
        description.setPreferredSize(new Dimension(200,150));
        Global.textAreaFactory(description);
        JScrollPane scrollPane = new JScrollPane(description);
        scrollPane.setPreferredSize(new Dimension(200,150));
        Global.scrollPaneFactory(scrollPane);
        setPreferredSize(new Dimension(200,200));
        setBorder(BorderFactory.createEmptyBorder(0,0,20,0));

        add(scrollPane);
        setBackground(Global.BACKGROUND_1);

    }

    private void takeDescription(){

        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(Global.SQL_CLIENT.getInputStream()));
            PrintWriter out = new PrintWriter(new PrintWriter(Global.SQL_CLIENT.getOutputStream()));

            out.println("quSELECT description FROM groups WHERE name = '" + Frame_Group.getGroupName() + "'");

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

}
