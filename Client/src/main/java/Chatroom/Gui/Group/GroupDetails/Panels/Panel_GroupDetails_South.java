package Chatroom.Gui.Group.GroupDetails.Panels;

import Chatroom.Global;
import Chatroom.Gui.Group.GroupDetails.Frame_GroupDetails;
import Chatroom.Gui.Group.GroupDetails.Listener.Listener_GroupDetails_Action;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel_GroupDetails_South extends JPanel {

    public Panel_GroupDetails_South(Frame_GroupDetails frame){

        ArrayList<JButton> buttons = new ArrayList<>();
        JButton cancel = new JButton("Cancel");
        cancel.setName("cancel");
        JButton leave = new JButton("Leave Group");
        leave.setName("leave");
        JButton add = new JButton("Add Member");
        add.setName("add");
        buttons.add(leave);
        buttons.add(cancel);
        buttons.add(add);

        for (JButton b:buttons) {

            b.setBackground(Global.BACKGROUND_1);
            b.setForeground(Global.FOREGROUND);
            b.addMouseListener(Global.ENTER);
            b.addMouseListener(Global.EXIT);
            b.setFocusable(false);
            b.setBorder(BorderFactory.createLineBorder(Global.LINE, 2));
            b.addActionListener(new Listener_GroupDetails_Action(frame, b.getName()));
            b.setPreferredSize(new Dimension(120,60));
            add(b);

        }

        setLayout(new FlowLayout());
        setBackground(Global.BACKGROUND_1);

    }

}
