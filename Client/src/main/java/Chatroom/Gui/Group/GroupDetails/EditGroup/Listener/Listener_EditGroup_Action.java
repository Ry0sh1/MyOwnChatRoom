package Chatroom.Gui.Group.GroupDetails.EditGroup.Listener;

import Chatroom.Global;
import Chatroom.Gui.Group.Frame_Group;
import Chatroom.Gui.Group.GroupDetails.EditGroup.Options.AddAdmin.Frame_AddAdmin;
import Chatroom.Gui.Group.GroupDetails.EditGroup.Options.AddMember.Frame_AddMember;
import Chatroom.Gui.Group.GroupDetails.EditGroup.Options.KickMember.Frame_KickMember;
import Chatroom.Gui.Group.GroupDetails.EditGroup.Options.RemoveAdmin.Frame_RemoveAdmin;
import Chatroom.Gui.Group.GroupDetails.EditGroup.Frame_EditGroup;
import Chatroom.Gui.Group.GroupDetails.EditGroup.Panels.Panel_EditGroup_Center;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Listener_EditGroup_Action implements ActionListener {

    private Frame_EditGroup frame;
    private String buttonName;

    public Listener_EditGroup_Action(Frame_EditGroup frame, String buttonName) {
        this.frame = frame;
        this.buttonName = buttonName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (buttonName.equals("cancel")){

            frame.dispose();

        } else if (buttonName.equals("add")) {

            new Frame_AddMember(frame.getX(),frame.getY());

        } else if (buttonName.equals("kick")) {

            new Frame_KickMember(frame.getX(),frame.getY());

        } else if (buttonName.equals("admin")) {

            new Frame_AddAdmin(frame.getX(),frame.getY());

        } else if (buttonName.equals("remAdmin")) {

            new Frame_RemoveAdmin(frame.getX(),frame.getY());

        } else if (buttonName.equals("apply")) {

            try {
                PrintWriter out = new PrintWriter(Global.SQL_CLIENT.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(Global.SQL_CLIENT.getInputStream()));
                out.println("quSELECT id FROM groups WHERE name = '" + Frame_Group.getGroupName() + "'");
                String groupID = in.readLine();
                out.println("upUPDATE groups SET description = '"+ Panel_EditGroup_Center.getDESCRIPTION().getText() +"' WHERE id = " + groupID);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }

    }

}
