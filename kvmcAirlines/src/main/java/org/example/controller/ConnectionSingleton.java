package org.example.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionSingleton {
    private static ConnectionSingleton onlyInstance;
    private Connection con;

    private ConnectionSingleton() throws Exception{
        String url = "jdbc:mysql://localhost:3306/kvmcairlines_two"; //url for connection; kvmcairlines is the database
        String uname = "root";
        String pass = "Mmysql#123";
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, uname, pass);
    }

    public static ConnectionSingleton getOnlyInstance() throws Exception{
        if(onlyInstance == null)
        {
            onlyInstance = new ConnectionSingleton();
        }
        return onlyInstance;
    }

    public void removeConnection() throws Exception{
        con.close();
    }

    public Connection getCon()
    {
        return con;
    }
    public static void main(String[] args) throws Exception
    {
        ConnectionSingleton single = ConnectionSingleton.getOnlyInstance();
        Connection con = single.getCon();

        Statement st = con.createStatement();
        String query = "select * from aircrafts;";
        ResultSet rs = st.executeQuery(query);
        int c = 1;
        String strc = String.valueOf(c);
        String query1 = "select * from aircrafts where aircraftID = " + strc + ";";
//        while(rs.next())
//        {
//            System.out.println("bookingID: " + rs.getString("aircraftID") + " userID: " + rs.getString("model"));
//        }

        rs = st.executeQuery(query1);
        while(rs.next())
        {
            System.out.println("aircraftID: " + rs.getInt(1) + " model: " + rs.getString(2));
        }
    }
}
