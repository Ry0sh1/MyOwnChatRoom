package Server;

import Server.SQL.LiteSQL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server_SQL implements Runnable{

    ServerSocket server;
    private ExecutorService pool;

    @Override
    public void run() {

        try {

            server = new ServerSocket(9383);

            pool = Executors.newCachedThreadPool();

            System.out.println("Server ist hochgefahren \nWaiting for Connections..");

            while (true) {

                Socket client = server.accept();

                ConnectionHandler conn = new ConnectionHandler(client);

                pool.execute(conn);

            }

        }catch (IOException e){

            e.printStackTrace();

        }

    }

    class ConnectionHandler implements Runnable {

        private Socket client;
        private PrintWriter out;
        private BufferedReader in;

        public ConnectionHandler(Socket client) {

            this.client = client;


            try {

                String ip = client.getInetAddress().getHostAddress();
                String username = LiteSQL.onQuery("SELECT username FROM user WHERE ip = '" + ip + "'").getString("username");

                if (username == null){

                    System.out.println("Address is reading: " + client.getInetAddress().getHostAddress());

                }else {

                    System.out.println(username + " is reading!");

                }

            } catch (SQLException e) {

                throw new RuntimeException(e);

            }

        }

        @Override
        public void run() {

            try {

                out = new PrintWriter(client.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                String query;

                while ((query = in.readLine()) != null) {

                    String command = query.substring(0,2);
                    query = query.substring(2);

                    if (command.equals("qu")){

                        out.println(LiteSQL.onQuery(query).getString(1));

                    } else if (command.equals("pr")) {

                        String columnName = query.substring(0,30);
                        query = query.substring(30);

                        columnName = columnName.replace(" ","");

                        PreparedStatement stmt = LiteSQL.prepareStatement(query);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()){

                            out.println(rs.getString(columnName));

                        }

                    } else if (command.equals("up")) {

                        LiteSQL.onUpdate(query);

                    }

                }

            }catch (IOException | SQLException s){

                try {

                    String nickname = LiteSQL.onQuery("SELECT username FROM user WHERE ip = '" + client.getInetAddress().getHostAddress() + "'").getString(1);

                    if (nickname == null || nickname.equals("null")){

                        System.out.println("Connection with " + client.getInetAddress().getHostAddress() + " lost!");

                    }else {

                        System.out.println("Connection with " + nickname + " lost!");

                    }

                } catch (SQLException e) {

                    throw new RuntimeException(e);

                }

            }

        }

    }

    public static void main(String[] args) {

        LiteSQL.connect();
        Server_SQL s = new Server_SQL();
        s.run();

    }

}