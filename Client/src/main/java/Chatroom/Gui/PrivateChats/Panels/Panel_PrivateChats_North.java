package Chatroom.Gui.PrivateChats.Panels;

import Chatroom.Global;
import Chatroom.Gui.PrivateChats.Frame_PrivateChats;
import Chatroom.Gui.PrivateChats.Listener.Listener_PrivateChats_Action;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Panel_PrivateChats_North extends JPanel {

    private final JPanel panel;
    private final Frame_PrivateChats frame;

    public Panel_PrivateChats_North(Frame_PrivateChats frame) {

        this.frame = frame;

        panel = new JPanel(new GridLayout(0,1));
        JScrollPane chatPane = new JScrollPane(panel);
        chatPane.setPreferredSize(new Dimension(300,200));

        displayChats();

        add(chatPane);

    }

    public void addChat(String chatname){

        JButton button = new JButton(chatname);
        button.setName(chatname);
        button.setPreferredSize(new Dimension(200,40));
        button.addActionListener(new Listener_PrivateChats_Action(frame, button.getName()));
        button.setFocusable(false);
        panel.add(button);
        revalidate();
        repaint();

    }

    public void displayChats(){

        String state = "SELECT username FROM user";

        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(Global.SQL_CLIENT.getInputStream()));
            PrintWriter out = new PrintWriter(Global.SQL_CLIENT.getOutputStream(), true);

            String query = "SELECT COUNT(username) FROM user";
            out.println("qu" + query);
            int columnCount = Integer.parseInt(in.readLine());

            String name = String.format("%1$-30s", "username");
            out.println("pr" + name + state);


            for (int i = 0; i<columnCount;i++) {

                addChat(in.readLine());

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }


}
