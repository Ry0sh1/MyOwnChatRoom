package Chatroom.Gui.Group.GroupDetails.AddMember.Panels;

import Chatroom.Global;
import Chatroom.Gui.CreateGroup.Listener.Listener_CreateGroup_Action;
import Chatroom.Gui.Group.GroupDetails.AddMember.Frame_AddMember;
import Chatroom.Gui.Group.GroupDetails.AddMember.Listener.Listener_AddMember_Action;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel_AddMember_South extends JPanel {

    public Panel_AddMember_South(Frame_AddMember frame){

        JButton cancel = new JButton("Cancel");
        JButton create = new JButton("Add");
        cancel.setName("cancel");
        create.setName("add");
        ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(cancel);
        buttons.add(create);

        for (JButton b:buttons) {

            b.setBorder(BorderFactory.createLineBorder(Global.LINE, 2));
            b.setBackground(Global.BACKGROUND_1);
            b.setForeground(Global.FOREGROUND);
            b.addMouseListener(Global.EXIT);
            b.addMouseListener(Global.ENTER);
            b.addActionListener(new Listener_AddMember_Action(frame, b.getName()));
            b.setPreferredSize(new Dimension(120,80));
            b.setFocusable(false);
            add(b);

        }

        setBackground(Global.BACKGROUND_1);

    }

}
