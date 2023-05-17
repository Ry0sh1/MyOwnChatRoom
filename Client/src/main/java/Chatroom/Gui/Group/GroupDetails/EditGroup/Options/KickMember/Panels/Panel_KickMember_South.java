package Chatroom.Gui.Group.GroupDetails.EditGroup.Options.KickMember.Panels;

import Chatroom.Global;
import Chatroom.Gui.Group.GroupDetails.EditGroup.Options.KickMember.Frame_KickMember;
import Chatroom.Gui.Group.GroupDetails.EditGroup.Options.KickMember.Listener.Listener_KickMember_Action;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel_KickMember_South extends JPanel {

    public Panel_KickMember_South(Frame_KickMember frame){

        JButton cancel = new JButton("Cancel");
        JButton create = new JButton("Kick");
        cancel.setName("cancel");
        create.setName("kick");
        ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(cancel);
        buttons.add(create);

        for (JButton b:buttons) {

            b.setBorder(BorderFactory.createLineBorder(Global.LINE, 2));
            b.setBackground(Global.BACKGROUND_1);
            b.setForeground(Global.FOREGROUND);
            b.addMouseListener(Global.EXIT);
            b.addMouseListener(Global.ENTER);
            b.addActionListener(new Listener_KickMember_Action(frame, b.getName()));
            b.setPreferredSize(new Dimension(120,80));
            b.setFocusable(false);
            add(b);

        }

        setBackground(Global.BACKGROUND_1);

    }

}
