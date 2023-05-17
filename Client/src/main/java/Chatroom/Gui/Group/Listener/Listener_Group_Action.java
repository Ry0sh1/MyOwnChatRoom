package Chatroom.Gui.Group.Listener;

import Chatroom.Group;
import Chatroom.Gui.Dashboard.Frame_Dashboard;
import Chatroom.Gui.Group.Frame_Group;
import Chatroom.Gui.Group.GroupDetails.Frame_GroupDetails;
import Chatroom.Gui.Group.Panels.Panel_Group_South;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Listener_Group_Action implements ActionListener{

    private final Socket groupClient;
    private final String buttonName;
    private Panel_Group_South south;
    private final Group group;
    private Frame_Group frame;

    public Listener_Group_Action(Socket groupClient, String buttonName, Panel_Group_South south, Group group) {

        this.groupClient = groupClient;
        this.buttonName = buttonName;
        this.south = south;
        this.group = group;

    }

    public Listener_Group_Action(Socket groupClient, Frame_Group frame, String buttonName, Group group) {

        this.groupClient = groupClient;
        this.frame = frame;
        this.buttonName = buttonName;
        this.group = group;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (buttonName.equals("send")){

            try {

                String message = "gr" + String.format("%04d", group.getId()) + south.getText();
                PrintWriter out = new PrintWriter(groupClient.getOutputStream(), true);
                out.println(message);

                //"0001TEST"

            }catch (IOException a){

                a.printStackTrace();

            }

        } else if (buttonName.equals("cancel")){

            try {

                String message = "gr" + String.format("%04d", group.getId()) + "left the chat!";
                PrintWriter out = new PrintWriter(groupClient.getOutputStream(), true);
                out.println(message);
                frame.dispose();
                groupClient.close();
                new Frame_Dashboard(frame.getX(),frame.getY());

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        } else if (buttonName.equals("viewGroup")) {

            try {

                String message = "gr" + String.format("%04d", group.getId()) + "left the chat!";
                PrintWriter out = new PrintWriter(groupClient.getOutputStream(), true);
                out.println(message);
                frame.dispose();
                groupClient.close();
                new Frame_GroupDetails(frame.getX(),frame.getY());

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }

    }

}
