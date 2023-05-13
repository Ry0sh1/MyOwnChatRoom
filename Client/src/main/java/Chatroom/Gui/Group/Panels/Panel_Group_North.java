package Chatroom.Gui.Group.Panels;


import Chatroom.Global;

import javax.swing.*;
import java.awt.*;

public class Panel_Group_North extends JPanel {

    private final JTextArea chat;
    public Panel_Group_North() {

        chat = new JTextArea();
        chat.setEditable(false);
        chat.setAutoscrolls(true);
        chat.setWrapStyleWord(true);
        chat.setLineWrap(true);
        chat.setBackground(Global.BACKGROUND_2);
        chat.setForeground(Global.FOREGROUND);
        JScrollPane pane = new JScrollPane(chat);

        pane.setBackground(Global.BACKGROUND_2);
        pane.setForeground(Global.FOREGROUND);
        pane.setBorder(BorderFactory.createLineBorder(Global.LINE,2));
        pane.getVerticalScrollBar().setUI(Global.SCROLLBAR_UI);

        setBackground(Global.BACKGROUND_1);
        setForeground(Global.FOREGROUND);
        pane.setPreferredSize(new Dimension(720,400));

        add(pane);

    }

    public void append(String message){

        chat.append(message + "\n");

    }

}
