package org.example.controller;

import org.example.entity.Address;
import org.example.entity.Agent;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class AgentSingleton {
    private static AgentSingleton onlyInstance;
    private ArrayList<Agent> agents;

    public void addAgent(Agent a){
        agents.add(a);
    }

    public void removeAgent(Agent a){
        agents.remove(a);
    }

    private AgentSingleton() throws Exception{
        ConnectionSingleton single = ConnectionSingleton.getOnlyInstance();
        Connection con = single.getCon();
        Statement st = con.createStatement();

        String query = "select * from users where userType = 'G';";
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


            Agent ag = new Agent(id, fName, lName, email, add, username, password, notification);
            agents.add(ag);

        }
    }
}
