package Chatroom.Gui.Group.GroupDetails.AddAdmin.Panels;

import Chatroom.Global;
import Chatroom.Gui.Group.GroupDetails.AddAdmin.Frame_AddAdmin;
import Chatroom.Gui.Group.GroupDetails.AddAdmin.Listener.Listener_AddAdmin_Action;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel_AddAdmin_South extends JPanel {

    public Panel_AddAdmin_South(Frame_AddAdmin frame){

        JButton cancel = new JButton("Cancel");
        JButton create = new JButton("Make Admin");
        cancel.setName("cancel");
        create.setName("admin");
        ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(cancel);
        buttons.add(create);

        for (JButton b:buttons) {

            b.setBorder(BorderFactory.createLineBorder(Global.LINE, 2));
            b.setBackground(Global.BACKGROUND_1);
            b.setForeground(Global.FOREGROUND);
            b.addMouseListener(Global.EXIT);
            b.addMouseListener(Global.ENTER);
            b.addActionListener(new Listener_AddAdmin_Action(frame, b.getName()));
            b.setPreferredSize(new Dimension(120,80));
            b.setFocusable(false);
            add(b);

        }

        setBackground(Global.BACKGROUND_1);

    }

}
