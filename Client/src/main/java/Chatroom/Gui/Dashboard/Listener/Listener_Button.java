package Chatroom.Gui.Dashboard.Listener;

import Chatroom.Group;
import Chatroom.Gui.Dashboard.Frame_Dashboard;
import Chatroom.Gui.Group.Frame_Group;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener_Button implements ActionListener {

    private final String groupName;
    private final Frame_Dashboard dashboard;

    public Listener_Button(String groupName, Frame_Dashboard dashboard) {

        this.dashboard = dashboard;
        this.groupName = groupName;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        dashboard.dispose();
        Group selectedGroup = new Group(groupName);
        Frame_Group group = new Frame_Group(selectedGroup);

    }

}
