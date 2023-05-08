package Chatroom.Gui.Chat.Panels;

import Chatroom.Gui.Chat.Frame_Chat;
import Chatroom.Gui.Chat.Listener.Listener_Chat_Action;
import Chatroom.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Panel_Chat_South extends JPanel {

    private final JTextField input;

    public Panel_Chat_South(Frame_Chat frame, User with) {

        input = new JTextField();
        input.setPreferredSize(new Dimension(400,50));

        JButton send = new JButton("Send");
        send.setFocusable(false);
        send.setName("send");
        send.addActionListener(new Listener_Chat_Action(frame, "send", with, this));
        send.setMnemonic(KeyEvent.VK_ENTER);
        send.requestFocusInWindow();
        JButton cancel = new JButton("Cancel");
        cancel.setFocusable(false);
        cancel.setName("cancel");
        cancel.addActionListener(new Listener_Chat_Action(frame, "cancel"));

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
