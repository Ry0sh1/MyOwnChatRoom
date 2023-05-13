package Chatroom.Gui.Dashboard.Panels;

import Chatroom.Global;
import Chatroom.Gui.Dashboard.Frame_Dashboard;
import Chatroom.Gui.Dashboard.Listener.Listener_Button;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.metal.MetalScrollBarUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Panel_West extends JPanel {

    private final JPanel groupPanel;
    private final Frame_Dashboard frame;

    public Panel_West(Frame_Dashboard frame){

        this.frame = frame;

        groupPanel = new JPanel(new GridLayout(0,1));

        JScrollPane scrollPane = new JScrollPane(groupPanel);

        displayGroups();
        setBackground(Global.BACKGROUND_1);
        setForeground(Global.FOREGROUND);
        scrollPane.setPreferredSize(new Dimension(700, 400));
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUI(Global.BUTTON_SCROLLBAR_UI);

        setBorder(BorderFactory.createEmptyBorder(10,40,10,80));
        add(scrollPane);

    }

    public void addGroup(String groupName){

        JButton button = new JButton(groupName);
        button.setPreferredSize(new Dimension(500,100));
        button.addActionListener(new Listener_Button(groupName, frame));
        button.setFocusable(false);
        button.addMouseListener(Global.ENTER);
        button.addMouseListener(Global.EXIT);
        button.setBackground(Global.BACKGROUND_1);
        button.setForeground(Global.FOREGROUND);
        button.setBorder(BorderFactory.createLineBorder(Global.LINE, 2));
        groupPanel.add(button);
        revalidate();
        repaint();

    }

    public void displayGroups(){

        String state = "SELECT name FROM userToGroup INNER JOIN groups ON groups.id = userToGroup.groupID" +
                    " INNER JOIN user ON user.username = userToGroup.username WHERE user.username = '" + Global.USER.getUsername() + "'";

        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(Global.SQL_CLIENT.getInputStream()));
            PrintWriter out = new PrintWriter(Global.SQL_CLIENT.getOutputStream(), true);

            String query = "SELECT COUNT(*) FROM userToGroup INNER JOIN groups ON groups.id = userToGroup.groupID" +
                    " INNER JOIN user ON user.username = userToGroup.username WHERE user.username = '" + Global.USER.getUsername() + "'";
            out.println("qu" + query);
            int columnCount = Integer.parseInt(in.readLine());

            String name = String.format("%1$-30s", "name");
            out.println("pr" + name + state);


            for (int i = 0; i<columnCount;i++) {

                addGroup(in.readLine());

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}