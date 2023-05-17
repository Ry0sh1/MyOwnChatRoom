package Chatroom.Gui.LogIn;

import Chatroom.Distributor;
import Chatroom.Global;
import Chatroom.Gui.Dashboard.Frame_Dashboard;
import Chatroom.SQL.LiteSQL;
import Chatroom.SQL.SQLManager;
import Chatroom.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;

public class Frame_IpInput extends JFrame implements ActionListener {

    private JTextField ip;
    private final Color foreground = Color.white;
    private final Color background = new Color(40,40,40);
    private final Color background2 = new Color(60, 60, 60);
    private final JTextField userIn = new JTextField();
    private final JPasswordField passwordIn = new JPasswordField();

    public Frame_IpInput(){
        start();
    }
    public Frame_IpInput(int x, int y){
        setLocation(x, y);
        start();
    }

    private void start(){

        //Declarations
        ip = new JTextField();
        JLabel title = new JLabel("By Ryoshi", SwingConstants.CENTER);
        JPanel panelTitle = new JPanel();
        JPanel all = new JPanel();
        JButton go = new JButton("GO");
        JPanel panelIp = new JPanel(new FlowLayout());
        JLabel user = new JLabel("Username: ");
        JLabel password = new JLabel("Password: ");
        JPanel panelUser = new JPanel(new FlowLayout());
        JPanel panelPassword = new JPanel(new FlowLayout());
        JLabel labelIp = new JLabel("Server Ip:");

        try {

            if (LiteSQL.onQuery("SELECT color FROM settings WHERE id = 1").getInt(1)!=0){

                Global.setLINE(LiteSQL.onQuery("SELECT color FROM settings WHERE id = 1").getInt(1));

            }else {

                LiteSQL.onUpdate("INSERT INTO settings(id, color) VALUES (1, 0)");
                Global.setLINE(0);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //MouseAdapter
        MouseAdapter enter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton b = (JButton) e.getComponent();
                b.setBackground(background2);
            }
        };
        MouseAdapter exit = new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                JButton b = (JButton) e.getComponent();
                b.setBackground(background);
            }
        };

        //End MouseAdapter

        panelIp.setBackground(background);

        labelIp.setPreferredSize(new Dimension(100,20));
        labelIp.setForeground(foreground);

        ip.setPreferredSize(new Dimension(100,20));
        ip.setBackground(background2);
        ip.setForeground(foreground);
        ip.setBorder(BorderFactory.createLineBorder(Global.LINE,2));

        go.setPreferredSize(new Dimension(150,20));
        go.setMaximumSize(new Dimension(300,40));
        go.setFocusable(false);
        go.setBorder(BorderFactory.createLineBorder(Global.LINE, 2));
        go.setBackground(background);
        go.setForeground(foreground);

        go.addActionListener(this);

        go.addMouseListener(enter);
        go.addMouseListener(exit);

        panelIp.add(labelIp);
        panelIp.add(ip);
        panelIp.setMaximumSize(new Dimension(400,60));
        panelPassword.setMaximumSize(new Dimension(400,60));
        panelUser.setMaximumSize(new Dimension(400,60));

        user.setPreferredSize(new Dimension(100,20));
        user.setBackground(background);
        user.setForeground(foreground);
        password.setPreferredSize(new Dimension(100,20));
        password.setBackground(background);
        password.setForeground(foreground);
        userIn.setPreferredSize(new Dimension(100,20));
        userIn.setBackground(background2);
        userIn.setForeground(foreground);
        userIn.setBorder(BorderFactory.createLineBorder(Global.LINE, 2));
        passwordIn.setPreferredSize(new Dimension(100,20));
        passwordIn.setBackground(background2);
        passwordIn.setForeground(foreground);
        passwordIn.setBorder(BorderFactory.createLineBorder(Global.LINE, 2));

        panelUser.setBackground(background);
        panelPassword.setBackground(background);
        panelUser.add(user);
        panelUser.add(userIn);
        panelPassword.add(password);
        panelPassword.add(passwordIn);

        panelTitle.setPreferredSize(new Dimension(400,40));
        panelTitle.setMaximumSize(new Dimension(400,40));
        panelTitle.setBackground(background);

        title.setForeground(foreground);
        title.setFont(new Font("TimesRoman", Font.BOLD, 20));

        panelTitle.add(title);
        all.setLayout(new BoxLayout(all, BoxLayout.Y_AXIS));
        all.setAlignmentX(Component.CENTER_ALIGNMENT);
        all.setPreferredSize(new Dimension(250,250));
        all.setBackground(background);
        all.add(panelTitle);
        all.add(panelIp);
        all.add(panelUser);
        all.add(panelPassword);
        all.add(go);

        add(all);

        //setResizable(false);
        setTitle("Log in");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

    public static void main(String[] args) {

        System.out.println("~Ryoshi");
        LiteSQL.connect();
        SQLManager.onCreate();
        new Frame_IpInput();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            Socket sqlClient = new Socket(ip.getText(), 9383);
            Socket distributor = new Socket(ip.getText(), 9382);

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

                    this.dispose();
                    new Global(ip.getText(), sqlClient, distributor, user, background, background2, foreground);
                    new Frame_Dashboard(getX(), getY());

                } else {

                    JOptionPane.showMessageDialog(this, "Something went wrong");

                }

            }catch (IOException ex){

                ex.printStackTrace();

            }

        } catch (IOException i) {

            JOptionPane.showMessageDialog(this, "No Server with this ID found");

        }

    }

}