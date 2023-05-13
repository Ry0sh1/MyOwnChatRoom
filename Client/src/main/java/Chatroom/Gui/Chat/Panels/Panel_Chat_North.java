package Chatroom.Gui.Chat.Panels;

import Chatroom.Global;
import Chatroom.SQL.LiteSQL;
import Chatroom.User;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Panel_Chat_North extends JPanel{

    private final JTextArea chat;
    private final User with;

    public Panel_Chat_North(User with) {

        this.with = with;

        chat = new JTextArea();
        chat.setEditable(false);
        chat.setAutoscrolls(true);
        chat.setWrapStyleWord(true);
        chat.setLineWrap(true);
        loadChat();
        JScrollPane pane = new JScrollPane(chat);
        pane.getVerticalScrollBar().setUI(Global.SCROLLBAR_UI);

        pane.setPreferredSize(new Dimension(400,400));

        Global.setActualChatNickname(with.getUsername());
        Global.setActualChat(chat);
        add(pane);

    }

    public void append(String message){

        chat.append(message + "\n");

    }

    public void loadChat(){

        try {

            PreparedStatement stmt = LiteSQL.prepareStatement("SELECT time, message, owner FROM messages WHERE username = '" + with.getUsername() + "' ORDER BY time");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){

                long time = Long.parseLong(rs.getString("time"));
                Date d = new Date(time);

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                String formattedTime = sdf.format(d);

                String owner = rs.getString("owner");

                append(owner + ": " + formattedTime + ": " + rs.getString("message"));

            }

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }

}
