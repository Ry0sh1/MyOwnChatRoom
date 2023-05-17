package Chatroom.Gui.Group.GroupDetails.EditGroup.AddMember.Listener;

import Chatroom.Global;
import Chatroom.Gui.Group.Frame_Group;
import Chatroom.Gui.Group.GroupDetails.EditGroup.AddMember.Frame_AddMember;
import Chatroom.Gui.Group.GroupDetails.EditGroup.AddMember.Panels.Panel_AddMember_Center;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Listener_AddMember_Action implements ActionListener {

    private Frame_AddMember frame;
    private String buttonName;

    public Listener_AddMember_Action(Frame_AddMember frame, String buttonName) {
        this.frame = frame;
        this.buttonName = buttonName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (buttonName.equals("cancel")){

            frame.dispose();

        } else if (buttonName.equals("add")) {

            try {

                Socket sqlClient = Global.SQL_CLIENT;
                PrintWriter out = new PrintWriter(sqlClient.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(sqlClient.getInputStream()));

                out.println("quSELECT id FROM groups WHERE name = '" + Frame_Group.getGroupName() + "'");
                String groupId = in.readLine();

                for (String s: Panel_AddMember_Center.getUSER()) {

                    out.println("upINSERT INTO userToGroup(groupID, username, rights) VALUES (" + groupId + ", '" + s + "',0)");
                    Global.sendMessageFromServer(s, "You got added to a new Group: " + Frame_Group.getGroupName());

                }

                JOptionPane.showMessageDialog(frame, "Member added to Group");

                Panel_AddMember_Center.clearUSER();

                frame.dispose();

            }catch (IOException i){

                i.printStackTrace();

            }

        }

    }

}
