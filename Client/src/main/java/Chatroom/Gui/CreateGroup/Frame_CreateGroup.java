package Chatroom.Gui.CreateGroup;

import Chatroom.Global;
import Chatroom.Gui.CreateGroup.Panels.Panel_CreateGroup_All;

import javax.swing.*;

public class Frame_CreateGroup extends JFrame {

    public Frame_CreateGroup(int x, int y){

        add(new Panel_CreateGroup_All(this));

        setLocation(x,y);
        setJMenuBar(Global.MENUBAR);
        setBackground(Global.BACKGROUND_1);
        pack();
        setVisible(true);

    }

}
