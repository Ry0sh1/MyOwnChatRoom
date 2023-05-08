package Chatroom.Gui.LogIn;

import Chatroom.SQL.LiteSQL;
import Chatroom.SQL.SQLManager;

import javax.swing.*;
import java.awt.*;

public class Frame_IpInput extends JFrame {

    private final JTextField ip;

    public Frame_IpInput(){

        JLabel label_Ip = new JLabel("Enter Server Ip Address");
        label_Ip.setPreferredSize(new Dimension(150,20));
        ip = new JTextField();
        ip.setPreferredSize(new Dimension(150,20));
        JButton go = new JButton("GO");
        go.setPreferredSize(new Dimension(150,20));
        go.addActionListener(e -> {
            LiteSQL.connect();
            SQLManager.onCreate();
            this.dispose();
            new Frame_LogIn(ip.getText());
        });

        setLayout(new GridLayout(2, 2));
        add(label_Ip);
        add(ip);
        add(new JLabel(""));
        add(go);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

    public static void main(String[] args) {

        System.out.println("~Ryoshi");
        new Frame_IpInput();

    }

}