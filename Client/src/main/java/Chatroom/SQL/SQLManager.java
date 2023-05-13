package Chatroom.SQL;

public class SQLManager {

    public static void onCreate(){

        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS messages(time TEXT NOT NULL,\n" +
                " username TEXT NOT NULL,\n" +
                "  message TEXT NOT NULL,\n" +
                "   owner TEXT NOT NULL, \n " +
                "PRIMARY KEY (time, username, message, owner))");
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS settings(id INT, color INT NOT NULL)");

    }

}
