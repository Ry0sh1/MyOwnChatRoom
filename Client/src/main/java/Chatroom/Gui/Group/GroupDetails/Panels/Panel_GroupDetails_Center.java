package Chatroom.Gui.Group.GroupDetails.Panels;

import Chatroom.Global;
import Chatroom.Gui.Group.Frame_Group;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Panel_GroupDetails_Center extends JPanel {

    public Panel_GroupDetails_Center(){

        JScrollPane contact_pane;
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(Global.SQL_CLIENT.getInputStream()));
            PrintWriter out = new PrintWriter(Global.SQL_CLIENT.getOutputStream(), true);
            out.println("quSELECT COUNT(*) FROM userToGroup INNER JOIN groups g on g.id = userToGroup.groupID INNER JOIN user u on u.username = userToGroup.username WHERE name = '" + Frame_Group.getGroupName() + "'");

            int columnCount = Integer.parseInt(in.readLine());
            String[] col = {"Member"};
            Object[][] data = new Object[columnCount][col.length];

            out.println("pr" + String.format("%1$-30s", "username") + "SELECT u.username FROM userToGroup INNER JOIN groups g on g.id = userToGroup.groupID INNER JOIN user u on u.username = userToGroup.username WHERE name = '" + Frame_Group.getGroupName() + "'");

            for (int i = 0; i < columnCount;i++){

                data[i][0] = in.readLine();

            }

            setBackground(Global.BACKGROUND_1);
            JTable contacts = new JTable(data, col);
            contacts.setBackground(Global.BACKGROUND_1);
            contacts.setGridColor(Global.BACKGROUND_2);
            contacts.setForeground(Global.FOREGROUND);
            contacts.getTableHeader().setBackground(Global.BACKGROUND_2);
            contacts.getTableHeader().setForeground(Global.FOREGROUND);
            contacts.setBorder(BorderFactory.createEmptyBorder());
            contact_pane = new JScrollPane(contacts);
            contact_pane.setBorder(BorderFactory.createEmptyBorder());
            contact_pane.getVerticalScrollBar().setUI(Global.BUTTON_SCROLLBAR_UI);
            contact_pane.setBackground(Global.BACKGROUND_1);
            contact_pane.setPreferredSize(new Dimension(350,100));

            setPreferredSize(new Dimension(350,120));
            setBackground(Global.BACKGROUND_1);
            setForeground(Global.FOREGROUND);
            setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
            add(contact_pane);

        }catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

}
