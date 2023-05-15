package Chatroom;

import Chatroom.SQL.LiteSQL;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Distributor implements Runnable{
    private final User user;
    private final Socket dis;

    public Distributor(Socket dis, User user){

        this.user = user;
        this.dis = dis;

    }

    @Override
    public void run(){

        try {

            System.out.println("Receiving messages from Server");

            BufferedReader in = new BufferedReader(new InputStreamReader(dis.getInputStream()));

            String message;

            while ((message = in.readLine()) != null){

                if (message.startsWith("pr")){

                    //Message Design: "pr.from.to.message
                    String from = message.substring(2, 32).replace(" ", "");    //PARTNER
                    String to = message.substring(32, 62).replace(" ", "");     //ME
                    String aMessage = message.substring(62);                            //MESSAGE

                    String username;

                    if (!to.equals(Global.USER.getUsername())){

                        username = to;

                    } else {

                        username = from;

                    }

                    if (from.equals(user.getUsername()) || to.equals(user.getUsername()) ) {

                        if (!from.equals("Server")) {

                            GregorianCalendar calendar = new GregorianCalendar();

                            try {

                                LiteSQL.onUpdate("INSERT INTO messages(time, message, username, owner) VALUES('"
                                        + calendar.getTime().getTime() + "','"
                                        + aMessage + "','"
                                        + username + "','"
                                        + from + "')");

                            } catch (RuntimeException r) {

                                JOptionPane.showMessageDialog(null, "Not saving redundant Information");

                            }

                            long time = calendar.getTime().getTime();
                            Date d = new Date(time);

                            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                            String formattedTime = sdf.format(d);
                            if (Global.ACTUAL_CHAT_NICKNAME != null) {

                                if (Global.ACTUAL_CHAT_NICKNAME.equals(from) || Global.USER.getUsername().equals(from)) {

                                    Global.ACTUAL_CHAT.append(from + ": " + formattedTime + ": " + aMessage + "\n");

                                }

                            } else {

                                if (SystemTray.isSupported()) {

                                    SystemTray tray = SystemTray.getSystemTray();
                                    Image img = Toolkit.getDefaultToolkit().getImage("icon.png");
                                    TrayIcon trayIcon = new TrayIcon(img, "Tray Demo");
                                    trayIcon.setImageAutoSize(true);
                                    trayIcon.setToolTip("System try icon demo");
                                    tray.add(trayIcon);
                                    trayIcon.displayMessage(from, aMessage, TrayIcon.MessageType.NONE);

                                }

                            }

                        }else {

                            SystemTray tray = SystemTray.getSystemTray();
                            Image img = Toolkit.getDefaultToolkit().getImage("icon.png");
                            TrayIcon trayIcon = new TrayIcon(img, "Tray Demo");
                            trayIcon.setImageAutoSize(true);
                            trayIcon.setToolTip("System try icon demo");
                            tray.add(trayIcon);
                            trayIcon.displayMessage(from, aMessage, TrayIcon.MessageType.NONE);

                        }

                    }

                }

            }

        }catch (IOException i){

            i.printStackTrace();

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

    }

}