package Chatroom.Gui.Group.GroupDetails.EditGroup.RemoveAdmin.Listener;

import Chatroom.Global;
import Chatroom.Gui.Group.Frame_Group;
import Chatroom.Gui.Group.GroupDetails.EditGroup.RemoveAdmin.Frame_RemoveAdmin;
import Chatroom.Gui.Group.GroupDetails.EditGroup.RemoveAdmin.Panels.Panel_RemoveAdmin_Center;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Listener_RemoveAdmin_Action implements ActionListener {

    private Frame_RemoveAdmin frame;
    private String buttonName;

    public Listener_RemoveAdmin_Action(Frame_RemoveAdmin frame, String buttonName) {
        this.frame = frame;
        this.buttonName = buttonName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (buttonName.equals("cancel")){

            frame.dispose();

        } else if (buttonName.equals("remAdmin")) {

            try {

                Socket sqlClient = Global.SQL_CLIENT;
                PrintWriter out = new PrintWriter(sqlClient.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(sqlClient.getInputStream()));

                out.println("quSELECT id FROM groups WHERE name = '" + Frame_Group.getGroupName() + "'");
                String groupId = in.readLine();

                for (String s: Panel_RemoveAdmin_Center.getUSER()) {

                    out.println("upUPDATE userToGroup SET rights = 0 WHERE username = '" + s + "' AND groupID = " + groupId);
                    Global.sendMessageFromServer(s, "You aren't an Admin anymore in Group: " + Frame_Group.getGroupName());

                }

                JOptionPane.showMessageDialog(frame, "Member removed Admin rights");

                Panel_RemoveAdmin_Center.clearUSER();

                frame.dispose();

            }catch (IOException i){

                i.printStackTrace();

            }

        }

    }

}
