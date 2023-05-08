package Server;

import Server.SQL.LiteSQL;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Server implements Runnable{

    private ServerSocket server;
    private ArrayList<ConnectionHandler> connections;
    private ExecutorService pool;
    private Socket sqlConnection;
    private final String serverIp = "178.142.66.123";
    private final int sqlPort = 9383;
    private final int port = 9382;

    public Server(){

        connections = new ArrayList<>();

    }

    @Override
    public void run() {

        try {

            server = new ServerSocket(port);

            sqlConnection = new Socket(serverIp, sqlPort);

            pool = Executors.newCachedThreadPool();

            System.out.println("Server started. \nServer connected with Data-bank. \nWaiting for Connections..");

            while (true){

                Socket client = server.accept();

                ConnectionHandler conn = new ConnectionHandler(client, sqlConnection);

                connections.add(conn);

                pool.execute(conn);

            }

        }catch (IOException e){

            System.out.println("Server Problems");

        }

    }

    public void broadcast(String message){

        for (ConnectionHandler ch: connections) {

            if (ch != null && ch.verified){

                ch.sendMessage(message);

            }

        }

    }

    class ConnectionHandler implements Runnable{

        private boolean verified;
        private Socket client;
        private PrintWriter out;
        private BufferedReader in;
        private PrintWriter sqlOut;
        private BufferedReader sqlIn;
        private String nickname;
        private int group;
        private String clientIp;

        public ConnectionHandler(Socket client, Socket sqlConnection){

            this.client = client;
            verified = false;
            clientIp = client.getInetAddress().getHostAddress();

            try {

                sqlIn = new BufferedReader(new InputStreamReader(sqlConnection.getInputStream()));
                sqlOut = new PrintWriter(sqlConnection.getOutputStream(), true);

                sqlOut.println("quSELECT username FROM user WHERE ip = '" + clientIp + "'");

                String username = sqlIn.readLine();

                if (username == null || username.equals("null")){

                    System.out.println("Unknown address is trying to connect: " + clientIp);

                }else {

                    System.out.println(username + " just connected!");

                }

            }catch (IOException e) {

                System.out.println("Connection with SQL-Server lost");

            }

        }

        public void sendMessage(String message){
            out.println(message);
        }

        @Override
        public void run() {

            try {

                out = new PrintWriter(client.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                verified = true;

                String groupOrPrivate = in.readLine();

                if (groupOrPrivate.startsWith("gr")) {

                    nickname = in.readLine();
                    group = Integer.parseInt(in.readLine());

                    broadcast(String.format("%04d", group) + nickname + ": joined the chat!");

                    String message;

                    while ((message = in.readLine())!=null){

                        String groupid = message.substring(2,6);

                        broadcast(groupid + nickname + ": " + message.substring(6));

                    }

                } else if (groupOrPrivate.startsWith("pr")) {

                    nickname = in.readLine();

                    sqlOut.println("upUPDATE user SET ip = '" + client.getInetAddress().getHostAddress() + "' WHERE username = '" + nickname + "'");

                    System.out.println(nickname + " is receiving private Messages");

                    String message;

                    while ((message = in.readLine())!=null){

                        broadcast(message);

                    }

                }

            } catch (IOException e) {

                if (nickname == null || nickname.equals("null")){

                    System.out.println("Connection with " + clientIp + " lost");

                }

                System.out.println("Connection with " + nickname + " lost");

            }

        }

        private void shutdown(){

            try {

                Iterator<ConnectionHandler> iter = connections.iterator();

                while (iter.hasNext()) {

                    ConnectionHandler ch = iter.next();

                    if (ch == this) {

                        iter.remove();

                    }

                }
                client.close();

            } catch (IOException e) {

                System.out.println("Something went wrong");

            }

        }

    }

    public static void main(String [] args) {

        LiteSQL.connect();
        Server server = new Server();
        server.run();

    }

}