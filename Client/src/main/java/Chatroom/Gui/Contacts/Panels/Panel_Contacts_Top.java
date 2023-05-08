package Chatroom.Gui.Contacts.Panels;

import Chatroom.Global;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Panel_Contacts_Top extends JPanel {

    public Panel_Contacts_Top() {

        JScrollPane contact_pane;
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(Global.SQL_CLIENT.getInputStream()));
            PrintWriter out = new PrintWriter(Global.SQL_CLIENT.getOutputStream(), true);
            out.println("quSELECT COUNT(*) FROM user");

            int columnCount = Integer.parseInt(in.readLine());
            String[] col = {"Username"};
            Object[][] data = new Object[columnCount][col.length];

            out.println("pr" + String.format("%1$-30s", "username") + "SELECT username FROM user");

            for (int i = 0; i < columnCount;i++){

                data[i][0] = in.readLine();

            }

            JTable contacts = new JTable(data, col);
            contacts.setPreferredSize(new Dimension(400,400));
            contact_pane = new JScrollPane(contacts);
            add(contact_pane);

        }catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

}
