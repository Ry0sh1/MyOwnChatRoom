package Chatroom.Gui.Group;

import Chatroom.Global;
import Chatroom.Group;
import Chatroom.Gui.Group.GroupDetails.Frame_GroupDetails;
import Chatroom.Gui.Group.Panels.Panel_Group_All;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Frame_Group extends JFrame implements Runnable{

    protected Socket groupClient;
    private final Panel_Group_All all;
    private final Group group;
    public static String GROUP_NAME;

    public Frame_Group(Group group){

        super(group.getName());
        this.group = group;
        GROUP_NAME = group.getName();

        try {
            groupClient = new Socket(Global.SERVERIP, 9382);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Thread thread = new Thread(this);

        all = new Panel_Group_All(groupClient, group, this);
        add(all);

        setJMenuBar(Global.MENUBAR);
        setBackground(Global.BACKGROUND_1);
        setForeground(Global.FOREGROUND);
        setPreferredSize(new Dimension(800,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        thread.start();

        String username = Global.USER.getUsername();
        String groupId = String.valueOf(group.getId());

        try {

            PrintWriter out = new PrintWriter(groupClient.getOutputStream(), true);
            out.println("gr");
            out.println(username);      //TODO: "gr.GroupId.Username.Message
            out.println(groupId);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public void run() {

        try {

            System.out.println("new group client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(groupClient.getInputStream()));

            String message;

            while ((message = in.readLine()) != null) {

                String id = message.substring(0,4);
                message = message.substring(4);

                if (Integer.parseInt(id) == group.getId()){

                    all.append(message);

                }

            }

        } catch (IOException e) {

            System.out.println("Group client closed");

        }

    }

    public static String getGroupName(){
        return GROUP_NAME;
    }

}
