package Chatroom.Gui.Contacts.Panels;

import Chatroom.Global;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
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
            contacts.setBackground(Global.BACKGROUND_1);
            contacts.setGridColor(Global.BACKGROUND_2);
            contacts.setForeground(Global.FOREGROUND);
            contacts.getTableHeader().setBackground(Global.BACKGROUND_2);
            contacts.getTableHeader().setForeground(Global.FOREGROUND);
            contacts.setBorder(BorderFactory.createEmptyBorder());
            contacts.setPreferredSize(new Dimension(400,400));
            contact_pane = new JScrollPane(contacts);
            contact_pane.setBorder(BorderFactory.createEmptyBorder());
            contact_pane.getVerticalScrollBar().setUI(Global.BUTTON_SCROLLBAR_UI);

            setBackground(Global.BACKGROUND_1);
            setForeground(Global.FOREGROUND);
            add(contact_pane);

        }catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

}
