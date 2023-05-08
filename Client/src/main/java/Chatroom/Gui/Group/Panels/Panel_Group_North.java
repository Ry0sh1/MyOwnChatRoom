package Chatroom.Gui.Group.Panels;


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
        JScrollPane pane = new JScrollPane(chat);

        pane.setPreferredSize(new Dimension(400,400));

        add(pane);

    }

    public void append(String message){

        chat.append(message + "\n");

    }

}
