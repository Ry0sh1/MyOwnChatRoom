package Server;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GetPublicIPAddress {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.ipify.org");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner scanner = new Scanner(con.getInputStream());
                String response = scanner.nextLine();
                System.out.println("Public IP address: " + response);
            } else {
                System.out.println("Failed to get public IP address");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}