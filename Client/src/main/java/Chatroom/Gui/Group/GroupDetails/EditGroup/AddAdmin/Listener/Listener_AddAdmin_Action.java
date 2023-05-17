package Chatroom.Gui.Group.GroupDetails.EditGroup.AddAdmin.Listener;

import Chatroom.Global;
import Chatroom.Gui.Group.Frame_Group;
import Chatroom.Gui.Group.GroupDetails.EditGroup.AddAdmin.Frame_AddAdmin;
import Chatroom.Gui.Group.GroupDetails.EditGroup.AddAdmin.Panels.Panel_AddAdmin_Center;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Listener_AddAdmin_Action implements ActionListener {

    private Frame_AddAdmin frame;
    private String buttonName;

    public Listener_AddAdmin_Action(Frame_AddAdmin frame, String buttonName) {
        this.frame = frame;
        this.buttonName = buttonName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (buttonName.equals("cancel")){

            frame.dispose();

        } else if (buttonName.equals("admin")) {

            try {

                Socket sqlClient = Global.SQL_CLIENT;
                PrintWriter out = new PrintWriter(sqlClient.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(sqlClient.getInputStream()));

                out.println("quSELECT id FROM groups WHERE name = '" + Frame_Group.getGroupName() + "'");
                String groupId = in.readLine();

                for (String s:Panel_AddAdmin_Center.getUSER()) {

                    out.println("upUPDATE userToGroup SET rights = 1 WHERE username = '" + s + "' AND groupID = " + groupId);
                    Global.sendMessageFromServer(s, "You are now an Admin in Group: " + Frame_Group.getGroupName());

                }

                JOptionPane.showMessageDialog(frame, "Member granted Admin rights");

                Panel_AddAdmin_Center.clearUSER();

                frame.dispose();

            }catch (IOException i){

                i.printStackTrace();

            }

        }

    }

}
