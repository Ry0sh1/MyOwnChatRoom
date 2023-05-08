package Chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Group {

    private final int id;
    private final String name;

    public Group(String name) {

        this.name = name;

        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(Global.SQL_CLIENT.getInputStream()));
            PrintWriter out = new PrintWriter(Global.SQL_CLIENT.getOutputStream(), true);

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