package Chatroom.Gui.CreateGroup;

import Chatroom.Global;
import Chatroom.Gui.CreateGroup.Panels.Panel_CreateGroup_All;

import javax.swing.*;

public class Frame_CreateGroup extends JFrame {

    public Frame_CreateGroup(){

        add(new Panel_CreateGroup_All(this));

        setJMenuBar(Global.MENUBAR);
        setBackground(Global.BACKGROUND_1);
        pack();
        setVisible(true);

    }

}
