package Chatroom.Gui.Group.GroupDetails.KickMember;

import Chatroom.Global;
import Chatroom.Gui.Group.GroupDetails.KickMember.Panels.Panel_KickMember_All;

import javax.swing.*;

public class Frame_KickMember extends JFrame {

    public Frame_KickMember(int x, int y){

        add(new Panel_KickMember_All(this));

        setLocation(x,y);
        setJMenuBar(Global.MENUBAR);
        setBackground(Global.BACKGROUND_1);
        pack();
        setVisible(true);

    }

}
