package org.example.entity;

public class RegisteredUser extends User{

    public RegisteredUser(int userid, String firstname, String lastname, String email, Address address, String username, String password, boolean notifications) {
        super(userid,firstname, lastname, email, address,  username,  password, notifications);
    }


}
