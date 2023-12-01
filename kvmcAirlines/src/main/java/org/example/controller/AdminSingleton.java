package org.example.controller;

import org.example.entity.Address;
import org.example.entity.Admin;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class AdminSingleton {
    private static AdminSingleton onlyInstance;

    private ArrayList<Admin> admins;

    public static AdminSingleton getOnlyInstance() throws Exception{
        if(onlyInstance == null){
            onlyInstance = new AdminSingleton();
        }
        return onlyInstance;
    }

    public void addAdmin(Admin a){
        admins.add(a);
    }

    public void removeAdmin(Admin a){
        admins.remove(a);
    }

    private AdminSingleton() throws Exception{
        ConnectionSingleton single = ConnectionSingleton.getOnlyInstance();
        Connection con = single.getCon();
        Statement st = con.createStatement();

        String query = "select * from users where userType = 'A';";
        ResultSet rs = st.executeQuery(query);

        while(rs.next())
        {
            int id = rs.getInt("userid");
            String fname = rs.getString("firstName");
            String lname = rs.getString("lastName");
            String email = rs.getString("email");
            Address add = new Address(rs.getString("street"), rs.getString("city"));
            String username = rs.getString("username");
            String password = rs.getString("pass");
            boolean notification = rs.getBoolean("notification");

            Admin admin = new Admin(id, fname, lname, email, add, username, password, notification);
            admins.add(admin);
        }
    }
}
