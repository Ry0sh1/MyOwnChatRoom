package Chatroom.Gui.LogIn;

import Chatroom.Distributor;
import Chatroom.Global;
import Chatroom.Gui.Dashboard.Frame_Dashboard;
import Chatroom.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Frame_LogIn extends JFrame implements ActionListener {

    private final JTextField userIn;
    private final JTextField passwordIn;
    private final Socket sqlClient;
    private final Socket distributor;
    private final String serverip;

    public Frame_LogIn(String serverip){

        this.serverip = serverip;

        JLabel user = new JLabel("Username: ");
        user.setPreferredSize(new Dimension(100,20));
        JLabel password = new JLabel("Password: ");
        password.setPreferredSize(new Dimension(100,20));
        userIn = new JTextField();
        userIn.setPreferredSize(new Dimension(100,20));
        passwordIn = new JTextField();
        passwordIn.setPreferredSize(new Dimension(100,20));
        JButton logIn = new JButton("GO");
        logIn.setPreferredSize(new Dimension(100,20));
        logIn.addActionListener(this);

        setLayout(new GridLayout(3,2));
        add(user);
        add(userIn);
        add(password);
        add(passwordIn);
        add(new JLabel(""));
        add(logIn);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        try {

            sqlClient = new Socket(serverip, 9383);
            distributor = new Socket(serverip, 9382);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String uIn = userIn.getText();
        String pIn = passwordIn.getText();

        User user = new User(uIn, pIn);

        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(sqlClient.getInputStream()));
            PrintWriter out = new PrintWriter(sqlClient.getOutputStream(), true);

            String query = "quSELECT password FROM user WHERE username = '" + uIn + "'";
            out.println(query);
            out.flush();

            if (in.readLine().equals(pIn)) {

                PrintWriter disOut = new PrintWriter(distributor.getOutputStream(), true);
                disOut.println("pr");
                disOut.println(user.getUsername());

                Thread thread = new Thread(new Distributor(distributor, user));
                thread.start();

                System.out.println("Login succeed");

                new Global(serverip, sqlClient, distributor, user);
                new Frame_Dashboard();
                dispose();

            } else {

                JOptionPane.showMessageDialog(this, "Something went wrong");

            }

        }catch (IOException ex){

            ex.printStackTrace();

        }

    }

}
