package Chatroom.Gui.Group.Panels;

import Chatroom.Global;
import Chatroom.Group;
import Chatroom.Gui.Group.Frame_Group;
import Chatroom.Gui.Group.GroupDetails.Frame_GroupDetails;
import Chatroom.Gui.Group.Listener.Listener_Group_Action;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.Socket;
import java.sql.ShardingKey;

public class Panel_Group_South extends JPanel {

    private final JTextField input;

    public Panel_Group_South(Socket groupClient, Group group, Frame_Group frame) {

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
        send.addActionListener(new Listener_Group_Action(groupClient,"send", this, group));
        send.setMnemonic(KeyEvent.VK_ENTER);
        send.requestFocusInWindow();
        send.setPreferredSize(new Dimension(80, 50));
        JButton cancel = new JButton("Cancel");
        cancel.setFocusable(false);
        cancel.setName("cancel");
        cancel.addActionListener(new Listener_Group_Action(groupClient, frame, "cancel", group));
        cancel.setBackground(Global.BACKGROUND_1);
        cancel.setBorder(BorderFactory.createLineBorder(Global.LINE,2));
        cancel.setForeground(Global.FOREGROUND);
        cancel.addMouseListener(Global.ENTER);
        cancel.addMouseListener(Global.EXIT);
        cancel.setPreferredSize(new Dimension(80,50));

        JButton viewGroup = new JButton("View Group");
        viewGroup.setName("viewGroup");
        viewGroup.setBackground(Global.BACKGROUND_1);
        viewGroup.setForeground(Global.FOREGROUND);
        viewGroup.addMouseListener(Global.ENTER);
        viewGroup.addMouseListener(Global.EXIT);
        viewGroup.setFocusable(false);
        viewGroup.setBorder(BorderFactory.createLineBorder(Global.LINE, 2));
        viewGroup.addActionListener(new Listener_Group_Action(groupClient, frame, "viewGroup", group));
        viewGroup.setPreferredSize(new Dimension(80,50));


        setBackground(Global.BACKGROUND_1);
        setForeground(Global.FOREGROUND);
        setLayout(new FlowLayout());
        add(viewGroup);
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
