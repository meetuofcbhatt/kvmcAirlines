package org.example.entity;

public class Agent extends User {

    public Agent(int userid, String firstname, String lastname, String email, Address address, String username, String password, boolean notifications) {
        super(userid,firstname, lastname, email, address,  username,  password, notifications);
    }
}

