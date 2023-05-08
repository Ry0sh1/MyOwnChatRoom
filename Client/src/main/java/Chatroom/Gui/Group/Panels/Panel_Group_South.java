package Chatroom.Gui.Group.Panels;

import Chatroom.Group;
import Chatroom.Gui.Group.Frame_Group;
import Chatroom.Gui.Group.Listener.Listener_Group_Action;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.Socket;

public class Panel_Group_South extends JPanel {

    private final JTextField input;

    public Panel_Group_South(Socket groupClient, Group group, Frame_Group frame) {

        input = new JTextField();
        input.setPreferredSize(new Dimension(400,50));

        JButton send = new JButton("Send");
        send.setFocusable(false);
        send.setName("send");
        send.addActionListener(new Listener_Group_Action(groupClient,"send", this, group));
        send.setMnemonic(KeyEvent.VK_ENTER);
        send.requestFocusInWindow();
        JButton cancel = new JButton("Cancel");
        cancel.setFocusable(false);
        cancel.setName("cancel");
        cancel.addActionListener(new Listener_Group_Action(groupClient, frame, "cancel", group));

        setLayout(new FlowLayout());
        add(input);
        add(send);
        add(cancel);

    }

    public String getText(){

        String message = input.getText();
        input.setText("");
        return message;

    }

}
