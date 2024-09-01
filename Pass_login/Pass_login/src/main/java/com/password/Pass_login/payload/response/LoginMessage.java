package com.password.Pass_login.payload.response;

public class LoginMessage {
    String message;
    Boolean status;
    int id;
    String username;
    String Email;

    public LoginMessage(String message, boolean status, int id,String username, String Email) {
        this.message = message;
        this.status = status;
        this.id = id;
        this.username = username;
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }

}
