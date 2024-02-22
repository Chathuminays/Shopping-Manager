// Represents a user in the system
public class User {
    private String username;    // User's username
    private String password;    // User's password
    private boolean newUser;    // Flag indicating whether the user is new

    // Constructor to initialize user's attributes
    public User(String username, String password, boolean newUser) {
        this.username = username;
        this.password = password;
        this.newUser = newUser;
    }

    // Getter method to check if the user is new
    public boolean isNewUser() {
        return newUser;
    }

    // Setter method to set the new user flag
    public void setNewUser(boolean newUser) {
        this.newUser = newUser;
    }

    // Getter method to retrieve the username
    public String getUsername() {
        return username;
    }

    // Setter method to set the username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter method to retrieve the password
    public String getPassword() {
        return password;
    }

    // Setter method to set the password
    public void setPassword(String password) {
        this.password = password;
    }
}
