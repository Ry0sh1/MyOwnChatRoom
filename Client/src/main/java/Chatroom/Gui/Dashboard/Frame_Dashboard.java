package Chatroom.Gui.Dashboard;

import Chatroom.Global;
import Chatroom.Gui.Dashboard.Panels.Panel_All;

import javax.swing.*;

public class Frame_Dashboard extends JFrame{

    public Panel_All panelAll;
    public Frame_Dashboard(){

        panelAll = new Panel_All(this);
        add(panelAll);

        setJMenuBar(Global.MENUBAR);
        setBackground(Global.BACKGROUND_1);
        setForeground(Global.FOREGROUND);
        setTitle(Global.USER.getUsername());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

}
