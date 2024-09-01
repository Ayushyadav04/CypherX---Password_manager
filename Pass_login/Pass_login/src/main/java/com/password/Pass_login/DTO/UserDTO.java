package com.password.Pass_login.DTO;

public class UserDTO {
    private int userid;
    private String username;
    private String email;
    private String password;

    public UserDTO() {
    }

    public UserDTO(int userid, String username, String email, String password) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getter for userid
    public int getUserid() {
        return userid;
    }

    // Setter for userid
    public void setUserid(int userid) {
        this.userid = userid;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}
