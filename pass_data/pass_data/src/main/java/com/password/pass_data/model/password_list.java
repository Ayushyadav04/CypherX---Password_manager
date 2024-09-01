package com.password.pass_data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class password_list {
    int Id;
    String username;
    String website;
    String password;

    public password_list(int id, String username, String website, String password) {
        this.Id = id;
        this.username = username;
        this.website = website;
        this.password = password;

    }

    public password_list() {

    }

    @Id
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}


