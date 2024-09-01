package com.add_pass.add_pass.Model;

public class password_list {
    int id;
    String username;
    String website;
    String password;

    public password_list(int id, String username, String website, String password) {
        this.id = id;
        this.username = username;
        this.website = website;
        this.password = password;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


