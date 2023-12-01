package org.example.entity;

public abstract class User {
    private int userid;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
    private String username;
    private String password;
    private boolean notifications;

    public User(int userid, String firstname, String lastname, String email, Address address, String username, String password, boolean notifications) {
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
        this.notifications = notifications;
    }
}
