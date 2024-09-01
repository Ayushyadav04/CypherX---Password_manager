package com.password.Pass_login.Entity;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name = "user_cred")
public class User {

    @Id
    @Column(name="user_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;

    @Column(name="user_name", length = 255)
    private String username;

    @Column(name="email", length = 255)
    private String email;

    @Column(name="password", length = 255)
    private String password;

    public User(int userid, String username, String email, String password) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {

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


