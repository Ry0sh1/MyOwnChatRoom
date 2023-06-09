package Chatroom.Gui.Chat.Panels;

import Chatroom.Global;
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
        input.setBackground(Global.BACKGROUND_2);
        input.setForeground(Global.FOREGROUND);
        input.setBorder(BorderFactory.createLineBorder(Global.LINE,2));

        JButton send = new JButton("Send");
        send.setBackground(Global.BACKGROUND_1);
        send.setBorder(BorderFactory.createLineBorder(Global.LINE,2));
        send.setForeground(Global.FOREGROUND);
        send.addMouseListener(Global.ENTER);
        send.addMouseListener(Global.EXIT);
        send.setFocusable(false);
        send.setName("send");
        send.addActionListener(new Listener_Chat_Action(frame,"send", with, this));
        send.setMnemonic(KeyEvent.VK_ENTER);
        send.requestFocusInWindow();
        send.setPreferredSize(new Dimension(80, 50));
        JButton cancel = new JButton("Cancel");
        cancel.setFocusable(false);
        cancel.setName("cancel");
        cancel.addActionListener(new Listener_Chat_Action(frame, "cancel"));
        cancel.setBackground(Global.BACKGROUND_1);
        cancel.setBorder(BorderFactory.createLineBorder(Global.LINE,2));
        cancel.setForeground(Global.FOREGROUND);
        cancel.addMouseListener(Global.ENTER);
        cancel.addMouseListener(Global.EXIT);
        cancel.setPreferredSize(new Dimension(80,50));

        setBackground(Global.BACKGROUND_1);
        setForeground(Global.FOREGROUND);
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
