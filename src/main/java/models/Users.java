package models;

public class Users {
    String email;
    String password;

    public Users withEmail(String email) {
        this.email = email;
        return this;
    }

    public Users withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
