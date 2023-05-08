package Chatroom.SQL;

import java.io.File;
import java.sql.*;

public class LiteSQL {

    private static Connection conn = null;
    private static Statement statement;

    public static void connect(){

        try{

            File file = new File("datenbank.db");

            if(!file.exists()){

                file.createNewFile();

            }

            String url = "jdbc:sqlite:" + file.getPath();
            conn = DriverManager.getConnection(url);

            System.out.println("Connected to database");

            statement = conn.createStatement();

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    public static int onUpdate(String sql){

        try{

            statement.execute(sql);

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

        return 0;
    }

    public static ResultSet onQuery(String sql){

        try {

            return statement.executeQuery(sql);

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }
    public static PreparedStatement prepareStatement(String sql) {

        try {

            return conn.prepareStatement(sql);

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }

}