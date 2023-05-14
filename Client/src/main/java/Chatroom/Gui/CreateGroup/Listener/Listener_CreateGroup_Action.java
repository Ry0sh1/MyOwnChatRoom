package Chatroom.Gui.CreateGroup.Listener;

import Chatroom.Global;
import Chatroom.Group;
import Chatroom.Gui.CreateGroup.Frame_CreateGroup;
import Chatroom.Gui.CreateGroup.Panels.Panel_CreateGroup_All;
import Chatroom.Gui.CreateGroup.Panels.Panel_CreateGroup_Center;
import Chatroom.Gui.CreateGroup.Panels.Panel_CreateGroup_South;
import Chatroom.Gui.Dashboard.Frame_Dashboard;
import Chatroom.Gui.Group.Frame_Group;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.util.ArrayList;

public class Listener_CreateGroup_Action implements ActionListener {

    private Frame_CreateGroup frame;
    private String buttonName;

    public Listener_CreateGroup_Action(Frame_CreateGroup frame, String buttonName) {
        this.frame = frame;
        this.buttonName = buttonName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (buttonName.equals("cancel")){

            new Frame_Dashboard();
            frame.dispose();

        } else if (buttonName.equals("create")) {

            try {

                ArrayList<String> member = Panel_CreateGroup_Center.getUSER();
                String groupName = Panel_CreateGroup_All.getIN().getText();

                Socket sqlClient = Global.SQL_CLIENT;
                PrintWriter out = new PrintWriter(sqlClient.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(sqlClient.getInputStream()));
                System.out.println(groupName);
                out.println("upINSERT INTO groups(name) VALUES ('" + groupName + "')");
                out.println("quSELECT id FROM groups WHERE name = '" + groupName + "'");
                String groupId = in.readLine();
                System.out.println(groupId);

                for (String s:member) {

                    out.println("upINSERT INTO userToGroup(groupID, username) VALUES (" + groupId + ",'" + s + "')");

                }

                JOptionPane.showMessageDialog(frame, "Group created!");
                Panel_CreateGroup_All.clearIN();
                Panel_CreateGroup_Center.clearUSER();
                frame.dispose();
                new Frame_Dashboard();

            }catch (IOException i){

                JOptionPane.showMessageDialog(frame, "Something went wrong.");

            }

        }

    }

}