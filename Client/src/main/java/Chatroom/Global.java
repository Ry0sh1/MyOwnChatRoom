package Chatroom;

import Chatroom.SQL.LiteSQL;

import javax.swing.*;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class Global implements ActionListener {

    public static String SERVERIP;
    public static Socket SQL_CLIENT;
    public static Socket DIS_CLIENT;
    public static User USER;
    public static JTextArea ACTUAL_CHAT;
    public static String ACTUAL_CHAT_NICKNAME;
    public static Color BACKGROUND_1;
    public static Color BACKGROUND_2;
    public static Color FOREGROUND;
    public static Color LINE;
    public static MouseAdapter ENTER;
    public static MouseAdapter EXIT;
    public static ScrollBarUI BUTTON_SCROLLBAR_UI;
    public static ScrollBarUI TEXTAREA_SCROLLBAR_UI;
    public static JMenuBar MENUBAR;
    private static PrintWriter DIS_OUT;
    private JMenuItem[] colors = new JMenuItem[6];

    public Global(String serverIp, Socket sqlClient, Socket disClient, User user, Color background, Color background2, Color foreground){

        SERVERIP = serverIp;
        SQL_CLIENT = sqlClient;
        DIS_CLIENT = disClient;
        USER = user;
        BACKGROUND_1 = background;
        BACKGROUND_2 = background2;
        FOREGROUND = foreground;
        System.out.println("Global constants initialized");

        try {
            DIS_OUT = new PrintWriter(DIS_CLIENT.getOutputStream(),true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ENTER = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton b = (JButton) e.getComponent();
                b.setBackground(BACKGROUND_2);
            }
        };
        EXIT = new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                JButton b = (JButton) e.getComponent();
                b.setBackground(BACKGROUND_1);
            }
        };

        BUTTON_SCROLLBAR_UI = new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Global.BACKGROUND_2;
                this.trackColor = Global.BACKGROUND_1;
            }
            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton jbutton = new JButton();
                jbutton.setPreferredSize(new Dimension(0, 0));
                jbutton.setMinimumSize(new Dimension(0, 0));
                jbutton.setMaximumSize(new Dimension(0, 0));
                return jbutton;
            }
        };

        TEXTAREA_SCROLLBAR_UI = new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Global.BACKGROUND_1;
                this.trackColor = Global.BACKGROUND_2;
            }
            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton jbutton = new JButton();
                jbutton.setPreferredSize(new Dimension(0, 0));
                jbutton.setMinimumSize(new Dimension(0, 0));
                jbutton.setMaximumSize(new Dimension(0, 0));
                return jbutton;
            }
        };

        String[] colorNames = {"Red", "Blue", "Green", "Yellow", "Magenta", "Kevin"};
        MENUBAR = new JMenuBar();
        JMenuItem logout = new JMenuItem("LogOut");
        JMenu settings = new JMenu("Menu");
        JMenu menuColors = new JMenu("Select Color");
        JMenuItem back = new JMenuItem("Back");

        for (int i = 0; i < colorNames.length; i++){

            JMenuItem c = new JMenuItem(colorNames[i]);
            c.setName(colorNames[i]);
            c.addActionListener(this);
            menuColors.add(c);
            colors[i] = c;

        }

        settings.add(menuColors);
        settings.add(logout);
        settings.add(back);
        settings.setFocusable(true);
        settings.setEnabled(true);

        MENUBAR.add(settings);

    }

    public static void setActualChat(JTextArea n){

        ACTUAL_CHAT = n;

    }

    public static void setActualChatNickname(String nickname){

        ACTUAL_CHAT_NICKNAME = nickname;

    }

    public static void setLINE(int i){

        LiteSQL.onUpdate("UPDATE settings SET color = " + i);

        switch (i){

            case 0 -> LINE = new Color(180, 10, 10);
            case 1 -> LINE = Color.BLUE;
            case 2 -> LINE = Color.GREEN;
            case 3 -> LINE = Color.YELLOW;
            case 4 -> LINE = Color.MAGENTA;
            case 5 -> LINE = new Color(0x11d99a);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (Arrays.asList(colors).contains(e.getSource())){

            JMenuItem j = (JMenuItem) e.getSource();

            switch (j.getName()){

                case "Blue" -> Global.setLINE(1);
                case "Red" -> Global.setLINE(0);
                case "Green" -> Global.setLINE(2);
                case "Yellow" -> Global.setLINE(3);
                case "Magenta" -> Global.setLINE(4);
                case "Kevin" -> Global.setLINE(5);

            }

        }

    }
    public static void sendMessageFromServer(String recipient, String message){
        DIS_OUT.println("pr" + formatStringForPrivateMessages("Server") + formatStringForPrivateMessages(recipient) + message);
    }

    public static String formatStringForPrivateMessages(String st){
        return String.format("%1$-30s",st);
    }

}
