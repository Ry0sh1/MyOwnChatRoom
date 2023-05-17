package Chatroom.Gui.Group.GroupDetails.EditGroup.Panels;

import Chatroom.Global;
import Chatroom.Gui.Group.Frame_Group;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Panel_EditGroup_Center extends JPanel{

    private static JTextArea DESCRIPTION;

    public Panel_EditGroup_Center(){

        DESCRIPTION = new JTextArea();
        DESCRIPTION.setPreferredSize(new Dimension(200,150));
        Global.textAreaFactory(DESCRIPTION);
        JScrollPane scrollPane = new JScrollPane(DESCRIPTION);
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

            BufferedReader in = new BufferedReader(new InputStreamReader(Global.SQL_CLIENT.getInputStream()));
            PrintWriter out = new PrintWriter(new PrintWriter(Global.SQL_CLIENT.getOutputStream()), true);
            out.println("quSELECT description FROM groups WHERE name = '" + Frame_Group.getGroupName() + "'");
            DESCRIPTION.setText(in.readLine());

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    public static JTextArea getDESCRIPTION(){
        return DESCRIPTION;
    }

}
