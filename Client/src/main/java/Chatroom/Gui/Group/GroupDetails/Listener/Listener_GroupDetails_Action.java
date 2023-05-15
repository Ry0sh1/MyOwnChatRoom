package Chatroom.Gui.Group.GroupDetails.Listener;

import Chatroom.Global;
import Chatroom.Group;
import Chatroom.Gui.Dashboard.Frame_Dashboard;
import Chatroom.Gui.Group.Frame_Group;
import Chatroom.Gui.Group.GroupDetails.Frame_GroupDetails;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Listener_GroupDetails_Action implements ActionListener {

    private Frame_GroupDetails frame;
    private String buttonName;

    public Listener_GroupDetails_Action(Frame_GroupDetails frame, String buttonName) {
        this.frame = frame;
        this.buttonName = buttonName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (buttonName.equals("cancel")){

            frame.dispose();
            new Frame_Group(new Group(Frame_Group.getGroupName()));

        } else if (buttonName.equals("leave")) {

            try {

                Socket sqlClient = Global.SQL_CLIENT;
                PrintWriter out = new PrintWriter(sqlClient.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(sqlClient.getInputStream()));

                out.println("quSELECT id FROM groups WHERE name = '" + Frame_Group.getGroupName() + "'");
                String groupId = in.readLine();

                out.println("upDELETE FROM userToGroup WHERE username = '" + Global.USER.getUsername() + "' AND groupID = " + groupId);
                JOptionPane.showMessageDialog(frame, "You left " + Frame_Group.getGroupName());

                out.println("quSELECT COUNT(*) FROM userToGroup WHERE groupID = " + groupId);

                if (Integer.parseInt(in.readLine())<=0){

                    out.println("upDELETE FROM groups WHERE id = " + groupId);

                }

                frame.dispose();
                new Frame_Dashboard();

            }catch (IOException i){

                System.out.println("Error");

            }

        }

    }

}
