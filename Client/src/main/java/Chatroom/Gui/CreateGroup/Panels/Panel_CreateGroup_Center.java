package Chatroom.Gui.CreateGroup.Panels;

import Chatroom.Global;
import Chatroom.Gui.CreateGroup.Frame_CreateGroup;
import Chatroom.Gui.CreateGroup.Listener.Listener_CreateGroup_Action;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Panel_CreateGroup_Center extends JPanel {

    private final JPanel panel;
    private final Frame_CreateGroup frame;
    private static ArrayList<String> USER = new ArrayList<>();
    private MouseAdapter clicked = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            JButton b = (JButton) e.getSource();
            if (USER.contains(b.getName())){

                USER.remove(b.getName());
                b.setBackground(Global.BACKGROUND_2);
                b.addMouseListener(Global.EXIT);
                b.addMouseListener(Global.ENTER);

            }else {

                USER.add(b.getName());
                b.setBackground(new Color(80,60,180));
                b.removeMouseListener(Global.ENTER);
                b.removeMouseListener(Global.EXIT);


            }

        }

    };

    public Panel_CreateGroup_Center(Frame_CreateGroup frame) {

        this.frame = frame;

        panel = new JPanel(new GridLayout(0,1));
        JScrollPane chatPane = new JScrollPane(panel);
        chatPane.getVerticalScrollBar().setUI(Global.BUTTON_SCROLLBAR_UI);
        chatPane.setBackground(Global.BACKGROUND_1);
        chatPane.setForeground(Global.FOREGROUND);
        chatPane.setBorder(BorderFactory.createEmptyBorder());
        chatPane.setPreferredSize(new Dimension(400,250));

        displayChats();
        setBackground(Global.BACKGROUND_1);
        add(chatPane);

    }

    public void addChat(String chatname){

        JButton button = new JButton(chatname);
        button.setName(chatname);
        button.setPreferredSize(new Dimension(200,40));
        button.addActionListener(new Listener_CreateGroup_Action(frame, button.getName()));
        button.setFocusable(false);
        button.setBackground(Global.BACKGROUND_1);
        button.addMouseListener(Global.EXIT);
        button.addMouseListener(Global.ENTER);
        button.addMouseListener(clicked);
        button.setBorder(BorderFactory.createLineBorder(Global.LINE,2));
        button.setForeground(Global.FOREGROUND);
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

                String user = in.readLine();
                if (!user.equals(Global.USER.getUsername())){

                    addChat(user);

                }

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public static ArrayList<String> getUSER(){
        return USER;
    }

    public static void clearUSER(){
        USER.clear();
    }

}
