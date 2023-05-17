package Chatroom.Gui.Group.GroupDetails.EditGroup.RemoveAdmin.Panels;

import Chatroom.Global;
import Chatroom.Gui.Group.GroupDetails.EditGroup.RemoveAdmin.Frame_RemoveAdmin;
import Chatroom.Gui.Group.GroupDetails.EditGroup.RemoveAdmin.Listener.Listener_RemoveAdmin_Action;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel_RemoveAdmin_South extends JPanel {

    public Panel_RemoveAdmin_South(Frame_RemoveAdmin frame){

        JButton cancel = new JButton("Cancel");
        JButton create = new JButton("Remove Admin");
        cancel.setName("cancel");
        create.setName("remAdmin");
        ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(cancel);
        buttons.add(create);

        for (JButton b:buttons) {

            b.setBorder(BorderFactory.createLineBorder(Global.LINE, 2));
            b.setBackground(Global.BACKGROUND_1);
            b.setForeground(Global.FOREGROUND);
            b.addMouseListener(Global.EXIT);
            b.addMouseListener(Global.ENTER);
            b.addActionListener(new Listener_RemoveAdmin_Action(frame, b.getName()));
            b.setPreferredSize(new Dimension(120,80));
            b.setFocusable(false);
            add(b);

        }

        setBackground(Global.BACKGROUND_1);

    }

}
