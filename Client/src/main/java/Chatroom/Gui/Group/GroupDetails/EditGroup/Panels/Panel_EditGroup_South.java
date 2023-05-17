package Chatroom.Gui.Group.GroupDetails.EditGroup.Panels;

import Chatroom.Global;
import Chatroom.Gui.Group.GroupDetails.EditGroup.Frame_EditGroup;
import Chatroom.Gui.Group.GroupDetails.EditGroup.Listener.Listener_EditGroup_Action;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel_EditGroup_South extends JPanel {

    public Panel_EditGroup_South(Frame_EditGroup frame){

        setLayout(new FlowLayout());
        setBackground(Global.BACKGROUND_1);

        ArrayList<JButton> buttons = new ArrayList<>();
        JButton cancel = new JButton("Cancel");
        cancel.setName("cancel");
        buttons.add(cancel);
        JButton add = new JButton("Add Member");
        add.setName("add");
        buttons.add(add);
        JButton kick = new JButton("Kick Member");
        kick.setName("kick");
        buttons.add(kick);
        JButton admin = new JButton("Make Admin");
        admin.setName("admin");
        buttons.add(admin);
        JButton remAdmin = new JButton("Remove Admin");
        remAdmin.setName("remAdmin");
        buttons.add(remAdmin);
        JButton apply = new JButton("Apply");
        apply.setName("apply");
        buttons.add(apply);

        for (JButton b:buttons) {
            Global.buttonFactory(b);
            b.addActionListener(new Listener_EditGroup_Action(frame, b.getName()));
            add(b);
        }

    }

}
