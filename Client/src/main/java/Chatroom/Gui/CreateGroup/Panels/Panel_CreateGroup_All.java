package Chatroom.Gui.CreateGroup.Panels;

import Chatroom.Global;
import Chatroom.Gui.CreateGroup.Frame_CreateGroup;

import javax.swing.*;
import java.awt.*;

public class Panel_CreateGroup_All extends JPanel {

    private static JTextField IN;

    public Panel_CreateGroup_All(Frame_CreateGroup frame){

        Panel_CreateGroup_South south = new Panel_CreateGroup_South(frame);
        Panel_CreateGroup_North north = new Panel_CreateGroup_North(frame);
        Panel_CreateGroup_Center center = new Panel_CreateGroup_Center(frame);
        JPanel inp = new JPanel(new FlowLayout());
        inp.setBackground(Global.BACKGROUND_1);
        JLabel out = new JLabel("Group name:");
        out.setForeground(Global.FOREGROUND);
        out.setBackground(Global.BACKGROUND_1);
        IN = new JTextField();
        IN.setForeground(Global.FOREGROUND);
        IN.setBackground(Global.BACKGROUND_2);
        IN.setBorder(BorderFactory.createLineBorder(Global.LINE,2));
        IN.setPreferredSize(new Dimension(160,20));

        inp.add(out);
        inp.add(IN);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(CENTER_ALIGNMENT);
        setBackground(Global.BACKGROUND_1);
        add(north);
        add(center);
        add(inp);
        add(south);

    }

    public static JTextField getIN(){
        return IN;
    }

    public static void clearIN(){
        IN.setText("");
    }

}
