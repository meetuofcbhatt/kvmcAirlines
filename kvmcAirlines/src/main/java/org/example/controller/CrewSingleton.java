package org.example.controller;

import org.example.entity.Crew;
import org.example.entity.Staff;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class CrewSingleton {

    private static CrewSingleton onlyInstance;
    private ArrayList<Crew> crews;
    private CrewSingleton() throws Exception{
        ConnectionSingleton single = ConnectionSingleton.getOnlyInstance();
        Connection con = single.getCon();
        Statement st = con.createStatement();

        String query = "select * from users crew;";
        ResultSet rs = st.executeQuery(query);

        while(rs.next())
        {
//            System.out.println("crewID: " + rs.getInt(1) + " CrewNum: " + rs.getInt(2));
            int id = rs.getInt("crewID");
            ArrayList<Staff> staffs = new ArrayList<>();
            Crew crew = new Crew(staffs, id);
            crews.add(crew);
        }

        for (Crew crew: crews)
        {
            int crewID = crew.getCrewid();
            ArrayList<Staff> staffs = crew.getStaff();

            query = "select * from users where crewID = '" + String.valueOf(crewID) + "';";
            ResultSet rs1 = st.executeQuery(query);
            while(rs1.next())
            {
                int id = rs.getInt("userid");

                String firstname = rs.getString("firstName");
                String lastname = rs.getString("lastName");
                String stafftype = rs.getString("staffType");
                Staff newStaff = new Staff(id, crewID, firstname,lastname, stafftype);

                staffs.add(newStaff);
            }
            crew.setStaff(staffs);
        }

    }

    public static CrewSingleton getOnlyInstance() throws Exception{
        if(onlyInstance == null)
        {
            onlyInstance = new CrewSingleton();
        }
        return onlyInstance;
    }

    public ArrayList<Crew> getCrews(){return crews;}

    public void addCrew(Crew c){
        crews.add(c);
    }

    public void removeCrew(Crew c){
        crews.remove(c);
    }
    public static void main(String [] args)
    {

    }
}
