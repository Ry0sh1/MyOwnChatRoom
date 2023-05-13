package Chatroom.Gui.Dashboard.Panels;

import Chatroom.Global;
import Chatroom.Gui.Dashboard.Frame_Dashboard;

import javax.swing.*;
import java.awt.*;

public class Panel_All extends JPanel {

    public Panel_All(Frame_Dashboard frame){

        Panel_East panelEast = new Panel_East(frame);
        Panel_West panelWest = new Panel_West(frame);
        Panel_South panelSouth = new Panel_South();

        setPreferredSize(new Dimension(1000,600));
        setLayout(new BorderLayout());
        setName("Panel_All");
        setBackground(Global.BACKGROUND_1);
        setForeground(Global.FOREGROUND);
        add(panelEast, BorderLayout.EAST);
        add(panelWest, BorderLayout.WEST);
        add(panelSouth, BorderLayout.SOUTH);

    }

}