package Chatroom;

public class User {

    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
