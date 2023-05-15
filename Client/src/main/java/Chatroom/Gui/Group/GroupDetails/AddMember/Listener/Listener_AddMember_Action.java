package Chatroom.Gui.Group.GroupDetails.AddMember.Listener;

import Chatroom.Gui.Group.GroupDetails.AddMember.Frame_AddMember;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener_AddMember_Action implements ActionListener {

    private Frame_AddMember frame;
    private String buttonName;

    public Listener_AddMember_Action(Frame_AddMember frame, String buttonName) {
        this.frame = frame;
        this.buttonName = buttonName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (buttonName.equals("cancel")){

            frame.dispose();

        } else if (buttonName.equals("add")) {

            //TODO

        }

    }

}
