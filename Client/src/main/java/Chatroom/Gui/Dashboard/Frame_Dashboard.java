package Chatroom.Gui.Dashboard;

import Chatroom.Global;
import Chatroom.Gui.Dashboard.Panels.Panel_All;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Frame_Dashboard extends JFrame implements ActionListener {

    public Panel_All panelAll;
    private JMenuItem[] colors = new JMenuItem[5];

    public Frame_Dashboard(){

        JMenuBar menubar = new JMenuBar();
        JMenu settings = new JMenu("Menu");
        JMenu menuColors = new JMenu("Select Color");
        panelAll = new Panel_All(this);
        add(panelAll);

        String[] colorNames = {"Red", "Blue", "Green", "Yellow", "Magenta"};

        for (int i = 0; i < 5; i++){

            JMenuItem c = new JMenuItem(colorNames[i]);
            c.setName(colorNames[i]);
            c.addActionListener(this);
            menuColors.add(c);
            colors[i] = c;

        }

        settings.add(menuColors);
        settings.setFocusable(true);
        settings.setEnabled(true);

        menubar.add(settings);

        setJMenuBar(menubar);
        setBackground(Global.BACKGROUND_1);
        setForeground(Global.FOREGROUND);
        setTitle(Global.USER.getUsername());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (Arrays.asList(colors).contains(e.getSource())){

            JMenuItem j = (JMenuItem) e.getSource();

            switch (j.getName()){

                case "Blue" -> Global.setLINE(1);
                case "Red" -> Global.setLINE(0);
                case "Green" -> Global.setLINE(2);
                case "Yellow" -> Global.setLINE(3);
                case "Magenta" -> Global.setLINE(4);

            }

            repaint();
            revalidate();
        }

    }

}
