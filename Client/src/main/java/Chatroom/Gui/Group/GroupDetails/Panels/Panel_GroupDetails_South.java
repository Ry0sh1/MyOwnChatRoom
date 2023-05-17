package Chatroom.Gui.Group.GroupDetails.Panels;

import Chatroom.Global;
import Chatroom.Gui.Group.Frame_Group;
import Chatroom.Gui.Group.GroupDetails.Frame_GroupDetails;
import Chatroom.Gui.Group.GroupDetails.Listener.Listener_GroupDetails_Action;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Panel_GroupDetails_South extends JPanel {

    public Panel_GroupDetails_South(Frame_GroupDetails frame){

        ArrayList<JButton> buttons = new ArrayList<>();
        JButton cancel = new JButton("Cancel");
        cancel.setName("cancel");
        JButton leave = new JButton("Leave Group");
        leave.setName("leave");
        buttons.add(leave);
        buttons.add(cancel);
        setBackground(Global.BACKGROUND_1);

        try {

            Socket sqlClient = Global.SQL_CLIENT;
            BufferedReader in = new BufferedReader(new InputStreamReader(sqlClient.getInputStream()));
            PrintWriter out = new PrintWriter(sqlClient.getOutputStream(), true);
            out.println("quSELECT id FROM groups WHERE name = '" + Frame_Group.getGroupName() + "'");
            String groupId = in.readLine();
            out.println("quSELECT rights FROM userToGroup WHERE username = '" + Global.USER.getUsername() + "' AND groupID =" + groupId);

            if (Integer.parseInt(in.readLine())==1) {

                JButton edit = new JButton("Edit Group");
                edit.setName("edit");
                buttons.add(edit);

            }

        }catch (IOException i){
            System.out.println("Error");
        }

        for (JButton b:buttons) {
            Global.buttonFactory(b);
            b.addActionListener(new Listener_GroupDetails_Action(frame, b.getName()));
            add(b);
        }

        setLayout(new FlowLayout());
        setBackground(Global.BACKGROUND_1);

    }

}
