package Server.SQL;

import java.sql.*;

public class PostgreSQL {

    private static Connection conn = null;
    private static Statement statement;

    public static void DataBase(){

        String url = "jdbc:postgresql://localhost:5432/users";
        String user = "postgres";
        String password = "0r1On_n&b3l_wi/hi";

        try {

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Verbindung zur Datenbank hergestellt");
            statement = conn.createStatement();

        } catch (SQLException e) {

            System.out.println("Verbindung zur Datenbank konnte nicht hergestellt werden Reason:\n" + e);

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
