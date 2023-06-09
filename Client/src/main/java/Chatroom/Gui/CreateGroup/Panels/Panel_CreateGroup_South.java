package Chatroom.Gui.CreateGroup.Panels;

import Chatroom.Global;
import Chatroom.Gui.CreateGroup.Frame_CreateGroup;
import Chatroom.Gui.CreateGroup.Listener.Listener_CreateGroup_Action;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel_CreateGroup_South extends JPanel {

    public Panel_CreateGroup_South(Frame_CreateGroup frame){

        JButton cancel = new JButton("Cancel");
        JButton create = new JButton("Create");
        cancel.setName("cancel");
        create.setName("create");
        ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(cancel);
        buttons.add(create);

        for (JButton b:buttons) {

            b.setBorder(BorderFactory.createLineBorder(Global.LINE, 2));
            b.setBackground(Global.BACKGROUND_1);
            b.setForeground(Global.FOREGROUND);
            b.addMouseListener(Global.EXIT);
            b.addMouseListener(Global.ENTER);
            b.addActionListener(new Listener_CreateGroup_Action(frame, b.getName()));
            b.setPreferredSize(new Dimension(120,80));
            b.setFocusable(false);
            add(b);

        }

        setBackground(Global.BACKGROUND_1);

    }

}
