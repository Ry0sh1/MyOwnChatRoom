package Chatroom.Gui.Group.GroupDetails.EditGroup.Options.KickMember.Listener;

import Chatroom.Global;
import Chatroom.Gui.Group.Frame_Group;
import Chatroom.Gui.Group.GroupDetails.EditGroup.Options.KickMember.Panels.Panel_KickMember_Center;
import Chatroom.Gui.Group.GroupDetails.EditGroup.Options.KickMember.Frame_KickMember;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Listener_KickMember_Action implements ActionListener {

    private Frame_KickMember frame;
    private String buttonName;

    public Listener_KickMember_Action(Frame_KickMember frame, String buttonName) {
        this.frame = frame;
        this.buttonName = buttonName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (buttonName.equals("cancel")){

            frame.dispose();

        } else if (buttonName.equals("kick")) {

            try {

                Socket sqlClient = Global.SQL_CLIENT;
                PrintWriter out = new PrintWriter(sqlClient.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(sqlClient.getInputStream()));

                out.println("quSELECT id FROM groups WHERE name = '" + Frame_Group.getGroupName() + "'");
                String groupId = in.readLine();

                for (String s: Panel_KickMember_Center.getUSER()) {

                    out.println("upDELETE FROM userToGroup WHERE groupID = " + groupId + " AND username = '" + s + "'");
                    Global.sendMessageFromServer(s, "You got kicked out of Group: " + Frame_Group.getGroupName());

                }

                JOptionPane.showMessageDialog(frame, "Member kicked out of Group");

                Panel_KickMember_Center.clearUSER();

                frame.dispose();

            }catch (IOException i){

                i.printStackTrace();

            }

        }

    }

}
