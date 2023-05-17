package Chatroom.Gui.Chat.Listener;

import Chatroom.Global;
import Chatroom.Gui.Chat.Frame_Chat;
import Chatroom.Gui.Chat.Panels.Panel_Chat_South;
import Chatroom.Gui.Dashboard.Frame_Dashboard;
import Chatroom.SQL.LiteSQL;
import Chatroom.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.GregorianCalendar;

public class Listener_Chat_Action implements ActionListener {

    private final Frame_Chat frame;
    private final String buttonName;
    private User with;
    private Panel_Chat_South panel;

    public Listener_Chat_Action(Frame_Chat frame, String buttonName){
        this.frame = frame;
        this.buttonName = buttonName;
    }
    public Listener_Chat_Action(Frame_Chat frame, String buttonName, User with, Panel_Chat_South panel){
        this.frame = frame;
        this.buttonName = buttonName;
        this.with = with;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (buttonName.equals("send")){

            try {

                //Message Design: "from.to.message

                String from = String.format("%1$-30s",Global.USER.getUsername());
                String to = String.format("%1$-30s",with.getUsername());
                String message = panel.getText();
                PrintWriter out = new PrintWriter(Global.DIS_CLIENT.getOutputStream(), true);

                out.println("pr" + from + to + message);


            } catch (IOException ex) {

                throw new RuntimeException(ex);

            }

        } else if (buttonName.equals("cancel")) {

            Global.setActualChatNickname(null);
            Global.setActualChat(null);
            frame.dispose();
            new Frame_Dashboard(frame.getX(),frame.getY());

        }

    }

}
