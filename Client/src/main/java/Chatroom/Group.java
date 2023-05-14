package Chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Group {

    private final int id;
    private final String name;

    public Group(String name) {

        this.name = name;

        try {

            Socket sqlClient = Global.SQL_CLIENT;

            BufferedReader in = new BufferedReader(new InputStreamReader(sqlClient.getInputStream()));
            PrintWriter out = new PrintWriter(sqlClient.getOutputStream(), true);

            out.println("quSELECT id FROM groups WHERE name = '" + name + "'");

            id = in.read();

        }catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}