package org.example.controller;

import org.example.entity.RegisteredUser;
import org.example.entity.User;
import org.example.entity.Address;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class RegisteredUserSingleton {
    private static RegisteredUserSingleton onlyInstance;
    private ArrayList<User> regUsers;

    private RegisteredUserSingleton() throws Exception{
        ConnectionSingleton single = ConnectionSingleton.getOnlyInstance();
        Connection con = single.getCon();
        Statement st = con.createStatement();

        String query = "select * from users where userType = 'R';";

        ResultSet rs = st.executeQuery(query);

        while(rs.next())
        {
            int id = rs.getInt("userid");
            String fName = rs.getString("firstName");
            String lName = rs.getString("lastName");
            String email = rs.getString("email");
            Address add = new Address(rs.getString("street"), rs.getString("city"));
            String username = rs.getString("username");
            String password = rs.getString("pass");
            boolean notification = rs.getBoolean("notification");


            RegisteredUser register = new RegisteredUser(id, fName, lName, email, add, username, password, notification);
            regUsers.add(register);
        }

    }

    public static RegisteredUserSingleton getOnlyInstance() throws Exception{
        if(onlyInstance == null){
            onlyInstance = new RegisteredUserSingleton();
        }
        return onlyInstance;
    }

    public void addRegUser(RegisteredUser r){
        regUsers.add(r);
    }

    public void removeRegUser(RegisteredUser r){
        regUsers.remove(r);
    }
}
