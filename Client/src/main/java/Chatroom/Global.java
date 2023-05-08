package Chatroom;

import javax.swing.*;
import java.net.Socket;

public class Global {

    public static String SERVERIP;
    public static Socket SQL_CLIENT;
    public static Socket DIS_CLIENT;
    public static User USER;
    public static JTextArea ACTUAL_CHAT;
    public static String ACTUAL_CHAT_NICKNAME;

    public Global(String serverIp, Socket sqlClient, Socket disClient, User user){

        SERVERIP = serverIp;
        SQL_CLIENT = sqlClient;
        DIS_CLIENT = disClient;
        USER = user;
        System.out.println("Global constants initialized");

    }

    public static void setActualChat(JTextArea n){

        ACTUAL_CHAT = n;

    }

    public static void setActualChatNickname(String nickname){

        ACTUAL_CHAT_NICKNAME = nickname;

    }

}
